package org.auioc.mods.ahutils.common.block.impl;

import java.util.Random;
import javax.annotation.Nullable;
import org.auioc.mods.ahutils.common.config.CommonConfig;
import org.auioc.mods.ahutils.common.item.ItemManager;
import org.auioc.mods.ahutils.utils.MaterialUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LightBlock extends Block {
    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty VISIBLE = BooleanProperty.create("visible");

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
                .isValidSpawn((s, r, p, e) -> false)
        );
        this.registerDefaultState(
            this.defaultBlockState()
                .setValue(LEVEL, Integer.valueOf(CommonConfig.LightBlockDefaultStateLevel.get()))
                .setValue(WATERLOGGED, Boolean.valueOf(false))
                .setValue(VISIBLE, Boolean.valueOf(CommonConfig.LightBlockDefaultStateVisible.get()))
        );
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LEVEL, WATERLOGGED, VISIBLE);
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.getValue(LEVEL);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        if (state.getValue(VISIBLE)) {
            return BlockRenderType.MODEL;
        }
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, IWorld world, BlockPos pos1, BlockPos pos2) {
        if (state1.getValue(WATERLOGGED)) {
            world.getLiquidTicks().scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state1, direction, state2, world, pos1, pos2);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader render, BlockPos pos, ISelectionContext ctx) {
        if (state.getValue(VISIBLE)) {
            return VoxelShapes.block();
        }
        if (ctx.isHoldingItem(ItemManager.LIGHT_BLOCK.get()) || ctx.isHoldingItem(Items.DEBUG_STICK)) {
            return VoxelShapes.block();
        }
        return VoxelShapes.empty();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        FluidState fluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8));
    }

    @Override
    public boolean isPathfindable(BlockState state, IBlockReader reader, BlockPos pos, PathType path) {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.getValue(VISIBLE)) {
            return;
        }

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
