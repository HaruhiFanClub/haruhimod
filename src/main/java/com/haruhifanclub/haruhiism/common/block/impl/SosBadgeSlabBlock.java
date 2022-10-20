package com.haruhifanclub.haruhiism.common.block.impl;

import javax.annotation.Nullable;
import org.auioc.mcmod.hulsealib.game.block.HBlockMaterial;
import com.haruhifanclub.haruhiism.common.blockentity.HMBlockEntities;
import com.haruhifanclub.haruhiism.common.blockentity.impl.SosBadgeSlabBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SosBadgeSlabBlock extends BaseEntityBlock {

    public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public SosBadgeSlabBlock() {
        super(
            BlockBehaviour.Properties
                .of(
                    (new HBlockMaterial())
                        .color(MaterialColor.SNOW)
                        .notPushable()
                        .flammable()
                        .build()
                )
                .strength(50, 1200)
                .requiresCorrectToolForDrops()
        );
        this.registerDefaultState(
            this.defaultBlockState()
                .setValue(TYPE, SlabType.BOTTOM)
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockPos blockpos = ctx.getClickedPos();
        BlockState blockstate = ctx.getLevel().getBlockState(blockpos);
        Direction facing = ctx.getHorizontalDirection().getClockWise();
        if (blockstate.is(this)) {
            return blockstate.setValue(TYPE, SlabType.DOUBLE);
        } else {
            BlockState blockstate1 = this.defaultBlockState().setValue(FACING, facing);
            Direction clickedFace = ctx.getClickedFace();
            return (clickedFace != Direction.UP && (clickedFace == Direction.DOWN || (ctx.getClickLocation().y - (double) blockpos.getY() > 0.5D)))
                ? blockstate1.setValue(TYPE, SlabType.TOP)
                : blockstate1.setValue(TYPE, SlabType.BOTTOM);
        }
    }

    @Override
    public boolean canBeReplaced(BlockState blockstate, BlockPlaceContext ctx) {
        SlabType slabtype = blockstate.getValue(TYPE);
        if (slabtype != SlabType.DOUBLE && ctx.getItemInHand().getItem() == this.asItem()) {
            if (ctx.replacingClickedOnBlock()) {
                boolean flag = ctx.getClickLocation().y - (double) ctx.getClickedPos().getY() > 0.5D;
                Direction clickedFace = ctx.getClickedFace();
                if (slabtype == SlabType.BOTTOM) {
                    return (clickedFace == Direction.UP || flag && clickedFace.getAxis().isHorizontal());
                } else {
                    return (clickedFace == Direction.DOWN || !flag && clickedFace.getAxis().isHorizontal());
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        SlabType slabtype = state.getValue(TYPE);
        switch (slabtype) {
            case DOUBLE:
                return Shapes.block();
            case TOP:
                return TOP_AABB;
            default:
                return BOTTOM_AABB;
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SosBadgeSlabBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : createTickerHelper(type, HMBlockEntities.SOS_BADGE_SLAB_BLOCK_ENTITY.get(), SosBadgeSlabBlockEntity::serverTick);
    }

}
