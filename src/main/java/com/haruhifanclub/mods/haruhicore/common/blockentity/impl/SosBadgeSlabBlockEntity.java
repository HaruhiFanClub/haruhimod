package com.haruhifanclub.mods.haruhicore.common.blockentity.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import com.haruhifanclub.mods.haruhicore.common.advancement.criterion.SosBadgeSlabTrigger;
import com.haruhifanclub.mods.haruhicore.common.block.impl.SosBadgeSlabBlock;
import com.haruhifanclub.mods.haruhicore.common.blockentity.BlockEntityRegistry;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import org.auioc.mods.ahutils.utils.LogUtil;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.ItemUtils;
import org.auioc.mods.ahutils.utils.game.PlayerUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.resources.ResourceLocation;

public class SosBadgeSlabBlockEntity extends BlockEntity {

    private static final int MAX_TIME = 20;
    private int timer = 0;

    private HashMap<Player, Integer> storagedPlayerMap = new HashMap<Player, Integer>();

    public SosBadgeSlabBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.SOS_BADGE_SLAB_BLOCK_TILE_ENTITY.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, SosBadgeSlabBlockEntity tile) {
        if (tile.timer >= MAX_TIME) {
            SlabType slabtype = tile.getBlockState().getValue(SosBadgeSlabBlock.TYPE);

            AABB boundsAbove = new AABB(
                tile.worldPosition.getX(), tile.worldPosition.getY(), tile.worldPosition.getZ(),
                tile.worldPosition.getX() + 1, tile.worldPosition.getY() + (slabtype == SlabType.BOTTOM ? 1 : 2), tile.worldPosition.getZ() + 1
            );

            List<Player> playerList = level.getEntities(EntityType.PLAYER, boundsAbove, (e) -> !e.isSpectator());

            if (!playerList.isEmpty()) {
                Iterator<Entry<Player, Integer>> sit = tile.storagedPlayerMap.entrySet().iterator();
                while (sit.hasNext()) {
                    Entry<Player, Integer> entry = sit.next();
                    Player player = entry.getKey();

                    counter: if (playerList.contains(player)) {
                        int count = entry.getValue();

                        if (count == 0) {
                            entry.setValue(entry.getValue() + 1);
                            break counter;
                        }

                        boolean isDouble = (slabtype == SlabType.DOUBLE ? true : false);

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
                            // log("hit 1", player);
                            addEffect(player, effectCooldown, isDouble);
                        } else {
                            // log("pass 1");
                        }

                        if (count % lootColldown == 0) {
                            // log("hit 2", player);
                            lootItem(player, isDouble);
                        } else {
                            // log("pass 2");
                        }

                        entry.setValue(count + 1);
                    } else {
                        // log("remove", player);
                        sit.remove();
                    }
                }

                Iterator<Player> cit = playerList.iterator();
                while (cit.hasNext()) {
                    Player player = cit.next();
                    if (!tile.storagedPlayerMap.containsKey(player)) {
                        // log("add", player);
                        tile.storagedPlayerMap.put(player, 0);
                    }
                }
            } else if (tile.storagedPlayerMap.size() > 0) {
                // log("[clear] (" + worldPosition.toString() + ")");
                tile.storagedPlayerMap.clear();
            }

            tile.timer = 0;
        }
    }

    private static void addEffect(Player player, int duration, boolean isDouble) {
        int level = 0;
        if (isDouble) {
            List<? extends Integer> levelRange = CommonConfig.DoubleSosBadgeSlabEffectLevelRange.get();
            level = Mth.nextInt(player.getRandom(), levelRange.get(0), levelRange.get(1));
        }

        EffectUtils.addEffect(
            player,
            Mth.nextInt(player.getRandom(), 1, 32),
            duration * 20,
            level
        );
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

        LogUtil.info(logs);
    }

}
