package org.auioc.mods.ahutils.common.event.impl;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class PistonAddBlockLineEvent extends Event {

    private final BlockState blockState;
    private final World level;
    private final BlockPos blockPos;
    private final Direction direction;

    public PistonAddBlockLineEvent(BlockState blockState, World level, BlockPos blockPos, Direction direction) {
        super();
        this.blockState = blockState;
        this.level = level;
        this.blockPos = blockPos;
        this.direction = direction;
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public World getLevel() {
        return this.level;
    }

    public BlockState getBlockState() {
        return this.blockState;
    }

    public Direction getDirection() {
        return this.direction;
    }

}
