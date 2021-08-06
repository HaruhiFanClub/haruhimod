package com.haruhifanclub.mods.haruhicore.common.block.impl;

import org.auioc.mods.ahutils.utils.MaterialUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class DanchouConeBlock extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;


    private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 8, 10);

    public DanchouConeBlock() {
        super(
            AbstractBlock.Properties
                .of(
                    (new MaterialUtils.Builder())
                        .color(MaterialColor.COLOR_BLACK)
                        .notPushable()
                        .flammable()
                        .build()
                )
                .strength(50, 1200)
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.AXE)
                .harvestLevel(3)
        );
        this.registerDefaultState(
            this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(ROTATION, Integer.valueOf(0))
        );
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, ROTATION);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getClockWise());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType use(
        BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit
    ) {
        if (world.isClientSide) {
            return ActionResultType.PASS;
        }

        if (!player.isSteppingCarefully()) {
            return ActionResultType.PASS;
        }

        Item coneItem = this.getBlock().asItem();

        PlayerInventory inv = player.inventory;

        ItemStack headItemStack = inv.armor.get(3);
        if (headItemStack.equals(ItemStack.EMPTY)) {
            // * pass
        } else if (headItemStack.getItem().equals(coneItem)) {
            return ActionResultType.PASS;
        } else {
            int freeSlot = inv.getFreeSlot();
            if (freeSlot == -1) { // Player has no free slots.
                return ActionResultType.FAIL;
            }

            player.setSlot(freeSlot, headItemStack); // Move original head itemstack to free slot.
        }

        player.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(coneItem));

        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0); // Remove clicked cone block.

        return ActionResultType.SUCCESS;
    }
}
