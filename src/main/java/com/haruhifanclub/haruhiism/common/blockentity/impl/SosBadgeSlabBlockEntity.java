package com.haruhifanclub.haruhiism.common.blockentity.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.apache.logging.log4j.Marker;
import org.auioc.mcmod.arnicalib.base.log.LogUtil;
import org.auioc.mcmod.arnicalib.game.effect.MobEffectRegistry;
import org.auioc.mcmod.arnicalib.game.entity.player.PlayerUtils;
import org.auioc.mcmod.arnicalib.game.item.ItemUtils;
import com.haruhifanclub.haruhiism.Haruhiism;
import com.haruhifanclub.haruhiism.common.advancement.criterion.SosBadgeSlabTrigger;
import com.haruhifanclub.haruhiism.common.block.impl.SosBadgeSlabBlock;
import com.haruhifanclub.haruhiism.common.blockentity.HMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class SosBadgeSlabBlockEntity extends BlockEntity {

    private static final int MAX_TIME = 20;
    private int timer = 0;

    private HashMap<Player, Integer> storagedPlayerMap = new HashMap<Player, Integer>();

    private static final Marker MARKER = LogUtil.getMarker("SosBadgeSlab");
    private static final Marker SINGLE_MARKER = LogUtil.getMarker("SINGLE").addParents(MARKER);
    private static final Marker DOUBLE_MARKER = LogUtil.getMarker("DOUBLE").addParents(MARKER);

    public SosBadgeSlabBlockEntity(BlockPos pos, BlockState state) {
        super(HMBlockEntities.SOS_BADGE_SLAB_BLOCK_ENTITY.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, SosBadgeSlabBlockEntity tile) {
        if (tile.timer < MAX_TIME) {
            tile.timer++;
            return;
        }

        SlabType slabtype = state.getValue(SosBadgeSlabBlock.TYPE);
        boolean isDouble = (slabtype == SlabType.DOUBLE ? true : false);

        HashMap<Player, Integer> map = tile.storagedPlayerMap;

        AABB boundsAbove = new AABB(
            pos.getX(), pos.getY(), pos.getZ(),
            pos.getX() + 1, pos.getY() + (slabtype == SlabType.BOTTOM ? 1 : 2), pos.getZ() + 1
        );

        List<Player> playerList = level.getEntities(EntityType.PLAYER, boundsAbove, (e) -> !e.isSpectator());

        if (!playerList.isEmpty()) {
            Iterator<Entry<Player, Integer>> sit = map.entrySet().iterator();
            while (sit.hasNext()) {
                Entry<Player, Integer> entry = sit.next();
                Player player = entry.getKey();

                counter: if (playerList.contains(player)) {
                    int count = entry.getValue();

                    if (count == 0) {
                        entry.setValue(entry.getValue() + 1);
                        break counter;
                    }

                    int effectCooldown;
                    int lootCooldown;
                    if (isDouble) {
                        effectCooldown = Config.doubleEffectCooldown.get();
                        lootCooldown = Config.doubleLootCooldown.get();
                    } else {
                        effectCooldown = Config.singleEffectCooldown.get();
                        lootCooldown = Config.singleLootCooldown.get();
                    }

                    if (count % effectCooldown == 0) {
                        addEffect(player, effectCooldown, isDouble);
                    } else {
                    }

                    if (count % lootCooldown == 0) {
                        lootItem(player, isDouble);
                    } else {
                    }

                    entry.setValue(count + 1);
                } else {
                    sit.remove();
                }
            }

            Iterator<Player> cit = playerList.iterator();
            while (cit.hasNext()) {
                Player player = cit.next();
                if (!map.containsKey(player)) {
                    map.put(player, 0);
                }
            }
        } else if (map.size() > 0) {
            map.clear();
        }

        tile.timer = 0;
    }

    private static void addEffect(Player player, int duration, boolean isDouble) {
        int level = 0;
        if (isDouble) {
            List<? extends Integer> levelRange = Config.doubleEffectAmplifierRange.get();
            level = Mth.nextInt(player.getRandom(), levelRange.get(0), levelRange.get(1));
        }

        player.addEffect(new MobEffectInstance(MobEffectRegistry.getRandom(true), duration * 20, level));
    }

    private static void lootItem(Player player, boolean isDouble) {
        String lootTableId = (isDouble) ? Config.doubleLootTable.get() : Config.singleLootTable.get();
        boolean logDetail = Config.logLootDetail.get();

        LootContext lootCtx = new LootContext.Builder((ServerLevel) player.level)
            .withParameter(LootContextParams.THIS_ENTITY, player)
            .withParameter(LootContextParams.ORIGIN, player.position())
            .create(LootContextParamSets.GIFT);

        LootTable lootTable = player.getServer().getLootTables().get(new ResourceLocation(lootTableId));
        List<ItemStack> list = lootTable.getRandomItems(lootCtx);

        String logs = "Dropped " + list.size() + " items"
            + ((logDetail) ? (" from table " + lootTableId) : "")
            + " to player " + ((logDetail) ? PlayerUtils.toString(player) : player.getName().getString()) + ".";

        if (!list.isEmpty()) {
            for (ItemStack itemStack : list) {
                PlayerUtils.giveItem(((ServerPlayer) player), itemStack);
                if (logDetail) {
                    logs += "\n\t" + ItemUtils.toString(itemStack);
                }
            }
        }

        SosBadgeSlabTrigger.INSTANCE.trigger(((ServerPlayer) player), isDouble);

        Haruhiism.LOGGER.info(isDouble ? DOUBLE_MARKER : SINGLE_MARKER, logs);
    }


    public static class Config {
        public static BooleanValue logLootDetail;

        public static IntValue singleEffectCooldown;
        public static IntValue singleLootCooldown;
        public static ConfigValue<String> singleLootTable;

        public static IntValue doubleEffectCooldown;
        public static ConfigValue<List<? extends Integer>> doubleEffectAmplifierRange;
        public static IntValue doubleLootCooldown;
        public static ConfigValue<String> doubleLootTable;

        public static void build(final ForgeConfigSpec.Builder b) {
            b.push("sos_badge_slab");
            logLootDetail = b.define("log_loot_detail", false);
            {
                b.push("single");
                singleEffectCooldown = b.defineInRange("effect_cooldown", 6, 1, Integer.MAX_VALUE);
                singleLootCooldown = b.defineInRange("loot_cooldown", 6, 1, Integer.MAX_VALUE);
                singleLootTable = b.define("loot_table", "haruhiism:sos_badge_slab/single");
                b.pop();
            }
            {
                b.push("double");
                doubleEffectCooldown = b.defineInRange("effect_cooldown", 3, 1, Integer.MAX_VALUE);
                doubleLootCooldown = b.defineInRange("loot_cooldown", 3, 1, Integer.MAX_VALUE);
                doubleLootTable = b.define("loot_table", "haruhiism:sos_badge_slab/double");
                doubleEffectAmplifierRange = b
                    .comment("Array: [min, max]", "Range: 0 ~ 255")
                    .define(
                        "effect_amplifier_range",
                        new ArrayList<Integer>(Arrays.asList(0, 2)),
                        (x) -> checkIntArray(x, 2)
                    );
                b.pop();
            }
            b.pop();
        }

        @SuppressWarnings("unchecked")
        private static boolean checkIntArray(Object x, int size) {
            if (!(x instanceof ArrayList)) {
                return false;
            }
            if (((ArrayList<Object>) x).size() != size) {
                return false;
            }
            for (Object o : (ArrayList<Object>) x) {
                if (!(o instanceof Integer)) {
                    return false;
                }
            }
            return true;
        }
    }

}
