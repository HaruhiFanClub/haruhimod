package com.haruhifanclub.mods.haruhicore.common.block.impl;

import java.util.Random;
import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import org.auioc.mods.utils.MaterialUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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

    public VoxelShape getShape(BlockState state, IBlockReader render, BlockPos pos, ISelectionContext ctx) {
        if (ctx.isHoldingItem(ItemManager.LIGHT_BLOCK.get()) || ctx.isHoldingItem(Items.DEBUG_STICK)) {
            return VoxelShapes.block();
        }
        return VoxelShapes.empty();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        super.animateTick(state, world, pos, random);

        Minecraft minecraft = Minecraft.getInstance();
        for (ItemStack itemstack : minecraft.player.getHandSlots()) {
            if (itemstack.getItem() == this.asItem()) {
                world.addParticle(
                    ParticleTypes.BARRIER, // TODO: Custom particle
                    (double) pos.getX() + 0.5D,
                    (double) pos.getY() + 0.5D,
                    (double) pos.getZ() + 0.5D,
                    0D, 0D, 0D
                );
                break;
            }
        }
    }
}
