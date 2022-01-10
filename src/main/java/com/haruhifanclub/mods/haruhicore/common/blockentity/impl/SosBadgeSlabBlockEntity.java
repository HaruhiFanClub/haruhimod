package com.haruhifanclub.mods.haruhicore.common.blockentity.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import com.haruhifanclub.mods.haruhicore.common.advancement.criterion.SosBadgeSlabTrigger;
import com.haruhifanclub.mods.haruhicore.common.block.impl.SosBadgeSlabBlock;
import com.haruhifanclub.mods.haruhicore.common.blockentity.BlockEntityRegistry;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.auioc.mods.arnicalib.utils.LogUtil;
import org.auioc.mods.arnicalib.utils.game.EffectUtils;
import org.auioc.mods.arnicalib.utils.game.ItemUtils;
import org.auioc.mods.arnicalib.utils.game.PlayerUtils;
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

public class SosBadgeSlabBlockEntity extends BlockEntity {

    private static final int MAX_TIME = 20;
    private int timer = 0;

    private HashMap<Player, Integer> storagedPlayerMap = new HashMap<Player, Integer>();

    private static final Logger LOGGER = LogUtil.getLogger("SosBadgeSlabBlockEntity");
    private static final Marker SINGLE_MARKER = LogUtil.getMarker("SINGLE");
    private static final Marker DOUBLE_MARKER = LogUtil.getMarker("DOUBLE");

    public SosBadgeSlabBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.SOS_BADGE_SLAB_BLOCK_ENTITY.get(), pos, state);
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
                    int lootColldown;
                    if (isDouble) {
                        effectCooldown = CommonConfig.DoubleSosBadgeSlabEffectCooldown.get();
                        lootColldown = CommonConfig.DoubleSosBadgeSlabLootCooldown.get();
                    } else {
                        effectCooldown = CommonConfig.SingleSosBadgeSlabEffectCooldown.get();
                        lootColldown = CommonConfig.SingleSosBadgeSlabLootCooldown.get();
                    }

                    if (count % effectCooldown == 0) {
                        addEffect(player, effectCooldown, isDouble);
                    } else {
                    }

                    if (count % lootColldown == 0) {
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
            List<? extends Integer> levelRange = CommonConfig.DoubleSosBadgeSlabEffectLevelRange.get();
            level = Mth.nextInt(player.getRandom(), levelRange.get(0), levelRange.get(1));
        }

        player.addEffect(new MobEffectInstance(EffectUtils.getEffect(Mth.nextInt(player.getRandom(), 1, 32)), duration * 20, level));
    }

    private static void lootItem(Player player, boolean isDouble) {
        String lootTableId = (isDouble) ? CommonConfig.DoubleSosBadgeSlabLootTable.get() : CommonConfig.SingleSosBadgeSlabLootTable.get();
        boolean logDetail = CommonConfig.SosBadgeSlabLogLootDetail.get();

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

        LOGGER.info(isDouble ? DOUBLE_MARKER : SINGLE_MARKER, logs);
    }

}
