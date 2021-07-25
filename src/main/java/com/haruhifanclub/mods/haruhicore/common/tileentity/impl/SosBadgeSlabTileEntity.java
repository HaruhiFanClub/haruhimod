package com.haruhifanclub.mods.haruhicore.common.tileentity.impl;

import com.haruhifanclub.mods.haruhicore.common.tileentity.TileEntityManager;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class SosBadgeSlabTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 4;
    private int timer = 0;

    public SosBadgeSlabTileEntity() {
        super(TileEntityManager.SOS_BADGE_SLAB_BLOCK_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if (!level.isClientSide) {
            if (timer >= MAX_TIME) {
                timer = 0;
            }
            timer++;
        }
    }
}
