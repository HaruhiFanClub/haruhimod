package com.haruhifanclub.mods.haruhicore.common.block.impl;

import javax.annotation.Nullable;
import com.haruhifanclub.mods.haruhicore.common.tileentity.impl.SosBadgeSlabTileEntity;
import org.auioc.mods.ahutils.utils.game.HBlockMaterial;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class SosBadgeSlabBlock extends Block {

    public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public SosBadgeSlabBlock() {
        super(
            AbstractBlock.Properties
                .of(
                    (new HBlockMaterial.Builder())
                        .color(MaterialColor.SNOW)
                        .notPushable()
                        .flammable()
                        .build()
                )
                .strength(50, 1200)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
        );
        this.registerDefaultState(
            this.defaultBlockState()
                .setValue(TYPE, SlabType.BOTTOM)
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
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
    public boolean canBeReplaced(BlockState blockstate, BlockItemUseContext ctx) {
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
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        SlabType slabtype = state.getValue(TYPE);
        switch (slabtype) {
            case DOUBLE:
                return VoxelShapes.block();
            case TOP:
                return TOP_AABB;
            default:
                return BOTTOM_AABB;
        }
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new SosBadgeSlabTileEntity();
    }
}
