package org.auioc.mods.ahutils.utils.game;

import net.minecraft.world.World;

public interface MCTimeUtils {

    static final int ticksAtMidnight = 18000;
    static final int ticksPerDay = 24000;
    static final int ticksPerHour = 1000;
    static final double ticksPerMinute = 1000d / 60d;
    static final double ticksPerSecond = 1000d / 60d / 60d;

    static long[] getTime(World level) {
        return new long[] {level.getDayTime(), level.getGameTime(), System.currentTimeMillis()};
    }

    static int[] formatDayTime(long rawDayTime) {
        // change the server time started with 0 at midnight
        int dayTime = ((int) (rawDayTime % 2147483647L)) - ticksAtMidnight + ticksPerDay;

        int day = dayTime / ticksPerDay;

        /*
        *    int ticks = dayTime % ticksPerDay;
        *    int hour = ticks / ticksPerHour;
        *    ticks -= hour * ticksPerHour;
        *    int minutes = (int) (ticks / ticksPerMinute);
        *    ticks -= minutes * ticksPerMinute;
        *    int seconds = (int) (ticks / ticksPerSecond);
        */
        int ticks = dayTime - day * ticksPerDay;
        int hour = (ticks / ticksPerHour) % 24;
        int min = (int) (ticks / ticksPerMinute) % 60;
        int sec = (int) (ticks / ticksPerSecond) % 60;

        return new int[] {day, hour, min, sec};
    }

}
