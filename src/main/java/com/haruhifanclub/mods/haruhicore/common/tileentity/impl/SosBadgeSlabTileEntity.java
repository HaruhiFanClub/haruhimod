package com.haruhifanclub.mods.haruhicore.common.tileentity.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import com.haruhifanclub.mods.haruhicore.common.block.impl.SosBadgeSlabBlock;
import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import com.haruhifanclub.mods.haruhicore.common.tileentity.TileEntityManager;
import org.auioc.mods.utils.EffectUtils;
import org.auioc.mods.utils.Loggers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;

public class SosBadgeSlabTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 4;
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
                        if (playerList.contains(player)) {
                            int value = entry.getValue();
                            if (value >= 30) {
                                Loggers.debug("hit");
                                EffectUtils.addEffect(player, 24, 62, 0);
                                if (!player.inventory.add(new ItemStack(ItemManager.REINFORCEMENT_STONE_ITEM.get()))) {
                                    Loggers.debug("give failed");
                                }
                                entry.setValue(0);
                            } else {
                                Loggers.debug("pass");
                                entry.setValue(entry.getValue() + 1);
                            }
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
