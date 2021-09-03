package org.auioc.mods.ahutils.common.event.impl;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

@Cancelable
public class PistonCheckPushableEvent extends BlockEvent {

    private final Direction pushDirection;

    public PistonCheckPushableEvent(BlockState blockState, World level, BlockPos blockPos, Direction pushDirection, boolean p_185646_4_, Direction p_185646_5_) {
        super(level, blockPos, blockState);
        this.pushDirection = pushDirection;
    }

    public Direction getPushDirection() {
        return pushDirection;
    }

}
