package com.haruhifanclub.mods.haruhicore.common.block.impl;

import org.auioc.mods.utils.MaterialUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class LightBlock extends Block {
    public static final IntegerProperty LIGHT = IntegerProperty.create("light", 0, 15);

    public LightBlock() {
        super(
            AbstractBlock.Properties
                .of(
                    (new MaterialUtils.Builder())
                        .destroyOnPush()
                        .replaceable()
                        .build()
                )
                .noDrops()
                .noOcclusion()
                .isValidSpawn(LightBlock::never)
        );
        this.registerDefaultState(
            this.defaultBlockState()
                .setValue(LIGHT, Integer.valueOf(0))
        );
    }

    private static Boolean never(BlockState p_235427_0_, IBlockReader p_235427_1_, BlockPos p_235427_2_, EntityType<?> p_235427_3_) {
        return (boolean) false;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIGHT);
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.getValue(LIGHT);
    }

    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }
}
