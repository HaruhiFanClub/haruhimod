package com.haruhifanclub.mods.haruhicore.common.block.impl;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class DanchouConeBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 8, 10);

    public DanchouConeBlock() {
        super(
            AbstractBlock.Properties
                .of(Material.HEAVY_METAL)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
