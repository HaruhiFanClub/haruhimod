package org.auioc.mods.ahutils.common.event;

import org.auioc.mods.ahutils.common.event.impl.PistonAddBlockLineEvent;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class CommonEventRegistry {
    public static boolean postPistonAddBlockLineEvent(BlockState blockState, World level, BlockPos blockPos, Direction direction) {
        return MinecraftForge.EVENT_BUS.post(new PistonAddBlockLineEvent(blockState, level, blockPos, direction));
    }
}
