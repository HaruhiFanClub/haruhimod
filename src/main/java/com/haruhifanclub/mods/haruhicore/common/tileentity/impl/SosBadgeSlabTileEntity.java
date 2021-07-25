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
import org.auioc.mods.utils.EffectUtils;
import org.auioc.mods.utils.Loggers;
import org.auioc.mods.utils.PlayerUtils;
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

    private HashMap<PlayerEntity, Integer> map = new HashMap<PlayerEntity, Integer>();

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

                List<PlayerEntity> playerList = level.getEntities(EntityType.PLAYER, boundsAbove, EntityPredicates.LIVING_ENTITY_STILL_ALIVE);

                if (!playerList.isEmpty()) {
                    Iterator<Entry<PlayerEntity, Integer>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<PlayerEntity, Integer> entry = it.next();
                        PlayerEntity player = entry.getKey();
                        counter: if (playerList.contains(player)) {
                            int value = entry.getValue();

                            if (value == 0) {
                                entry.setValue(entry.getValue() + 1);
                                break counter;
                            }

                            boolean flag = (slabtype == SlabType.DOUBLE ? true : false);

                            int effectCooldown;
                            int giveColldown;
                            if (flag) {
                                effectCooldown = CommonConfig.DoubleSosBadgeSlabEffectCooldown.get();
                                giveColldown = CommonConfig.DoubleSosBadgeSlabGiveCooldown.get();
                            } else {
                                effectCooldown = CommonConfig.SingleSosBadgeSlabEffectCooldown.get();
                                giveColldown = CommonConfig.SingleSosBadgeSlabGiveCooldown.get();
                            }

                            if (value % effectCooldown == 0) {
                                Loggers.debug("hit 1");
                                EffectUtils.addEffect(player, (new Random()).nextInt((32 - 1) + 1) + 1, effectCooldown * 20, 0);
                            } else {
                                // Loggers.debug("pass 1");
                            }

                            if (value % giveColldown == 0) {
                                Loggers.debug("hit 2");
                                try {
                                    ItemParser itemParser = new ItemParser(new StringReader(CommonConfig.SosBadgeSlabGiveItemInput.get()), false).parse();
                                    PlayerUtils.giveItem(((ServerPlayerEntity) player), itemParser.getItem(), itemParser.getNbt(), CommonConfig.SosBadgeSlabGiveItemCount.get());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                // Loggers.debug("pass 2");
                            }

                            entry.setValue(entry.getValue() + 1);
                        } else {
                            Loggers.debug("remove");
                            it.remove();
                        }
                    }

                    Iterator<PlayerEntity> iterator = playerList.iterator();
                    while (iterator.hasNext()) {
                        PlayerEntity player = iterator.next();
                        if (!map.containsKey(player)) {
                            Loggers.debug("new");
                            map.put(player, 0);
                        }
                    }
                } else if (map.size() > 0) {
                    Loggers.debug("clear");
                    map.clear();
                }

                timer = 0;
            }
            timer++;
        }
    }
}
