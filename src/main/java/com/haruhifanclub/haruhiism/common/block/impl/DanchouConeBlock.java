package com.haruhifanclub.haruhiism.common.block.impl;

import org.auioc.mcmod.hulsealib.game.block.HBlockMaterial;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DanchouConeBlock extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 8, 10);

    public DanchouConeBlock() {
        super(
            BlockBehaviour.Properties
                .of(
                    (new HBlockMaterial())
                        .color(MaterialColor.COLOR_BLACK)
                        .notPushable()
                        .flammable()
                        .build()
                )
                .strength(50, 1200)
                .requiresCorrectToolForDrops()
        );
        this.registerDefaultState(
            this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getClockWise());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(
        BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit
    ) {
        if (world.isClientSide) {
            return InteractionResult.PASS;
        }

        if (!player.isSteppingCarefully()) {
            return InteractionResult.PASS;
        }

        Item coneItem = this.asItem();

        Inventory inv = player.getInventory();

        ItemStack headItemStack = inv.armor.get(3);
        if (headItemStack.equals(ItemStack.EMPTY)) {
            // * pass
        } else if (headItemStack.getItem().equals(coneItem)) {
            return InteractionResult.PASS;
        } else {
            int freeSlot = inv.getFreeSlot();
            if (freeSlot == -1) { // Player has no free slots.
                return InteractionResult.FAIL;
            }

            inv.setItem(freeSlot, headItemStack); // Move original head itemstack to free slot.
        }

        player.setItemSlot(EquipmentSlot.HEAD, new ItemStack(coneItem));

        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0); // Remove clicked cone block.

        return InteractionResult.SUCCESS;
    }

}
