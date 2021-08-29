package com.haruhifanclub.mods.haruhicore.common.tileentity.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import com.haruhifanclub.mods.haruhicore.common.block.impl.SosBadgeSlabBlock;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.tileentity.TileEntityManager;
import com.mojang.brigadier.StringReader;
import org.auioc.mods.ahutils.utils.LogUtil;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.PlayerUtils;
import net.minecraft.command.arguments.ItemParser;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;

public class SosBadgeSlabTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 20;
    private int timer = 0;

    private HashMap<PlayerEntity, Integer> storagedPlayerMap = new HashMap<PlayerEntity, Integer>();

    public SosBadgeSlabTileEntity() {
        super(TileEntityManager.SOS_BADGE_SLAB_BLOCK_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if (!level.isClientSide) {
            if (timer >= MAX_TIME) {
                SlabType slabtype = this.getBlockState().getValue(SosBadgeSlabBlock.TYPE);

                AxisAlignedBB boundsAbove = new AxisAlignedBB(
                    worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(),
                    worldPosition.getX() + 1, worldPosition.getY() + (slabtype == SlabType.BOTTOM ? 1 : 2), worldPosition.getZ() + 1
                );

                List<PlayerEntity> playerList = level.getEntities(EntityType.PLAYER, boundsAbove, EntityPredicates.NO_SPECTATORS);

                if (!playerList.isEmpty()) {
                    Iterator<Entry<PlayerEntity, Integer>> sit = storagedPlayerMap.entrySet().iterator();
                    while (sit.hasNext()) {
                        Entry<PlayerEntity, Integer> entry = sit.next();
                        PlayerEntity player = entry.getKey();

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
                                addEffect(player, effectCooldown);
                            } else {
                                // log("pass 1");
                            }

                            if (count % lootColldown == 0) {
                                // log("hit 2", player);
                                lootItem(player);
                            } else {
                                // log("pass 2");
                            }

                            entry.setValue(count + 1);
                        } else {
                            // log("remove", player);
                            sit.remove();
                        }
                    }

                    Iterator<PlayerEntity> cit = playerList.iterator();
                    while (cit.hasNext()) {
                        PlayerEntity player = cit.next();
                        if (!storagedPlayerMap.containsKey(player)) {
                            // log("add", player);
                            storagedPlayerMap.put(player, 0);
                        }
                    }
                } else if (storagedPlayerMap.size() > 0) {
                    // log("[clear] (" + worldPosition.toString() + ")");
                    storagedPlayerMap.clear();
                }

                timer = 0;
            }
            timer++;
        }
    }


    private static void addEffect(PlayerEntity player, int duration) {
        EffectUtils.addEffect(player, (new Random()).nextInt((32 - 1) + 1) + 1, duration * 20, 0);
    }

    private static void lootItem(PlayerEntity player) {
        try {
            ItemParser itemParser = new ItemParser(new StringReader(CommonConfig.SosBadgeSlabGiveItemInput.get()), false).parse();
            PlayerUtils.giveItem(((ServerPlayerEntity) player), itemParser.getItem(), itemParser.getNbt(), CommonConfig.SosBadgeSlabGiveItemCount.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void log(String prefix, PlayerEntity player) {
        LogUtil.debug(String.format("[%s] (%s) %s", prefix, worldPosition.toString(), player.getName().getString()));
    }

    private void log(String text) {
        LogUtil.debug(text);
    }

}
