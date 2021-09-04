package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class HourglassItem extends Item {

    public static final int ticksAtMidnight = 18000;
    public static final int ticksPerDay = 24000;
    public static final int ticksPerHour = 1000;
    public static final double ticksPerMinute = 1000d / 60d;
    public static final double ticksPerSecond = 1000d / 60d / 60d;

    public HourglassItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(1)
        );
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!player.isSteppingCarefully()) {
            return ActionResult.pass(itemStack);
        }

        if (level.isClientSide) {
            return ActionResult.sidedSuccess(itemStack, true);
        }

        int rawDayTime = ((int) (level.getDayTime() % 2147483647L));
        int dayTime = rawDayTime - ticksAtMidnight + ticksPerDay; // change the server time started with 0 at midnight
        int day = dayTime / ticksPerDay;
        int ticks = dayTime - day * ticksPerDay;
        // int ticks = dayTime % ticksPerDay
        // int hour = ticks / ticksPerHour;
        // ticks -= hour * ticksPerHour;
        // int minutes = (int) (ticks / ticksPerMinute);
        // ticks -= minutes * ticksPerMinute;
        // int seconds = (int) (ticks / ticksPerSecond);
        int hour = (ticks / ticksPerHour) % 24;
        int min = (int) (ticks / ticksPerMinute) % 60;
        int sec = (int) (ticks / ticksPerSecond) % 60;

        String fmt = "{d}d {h}:{m}:{s}";
        fmt = fmt.replace("{d}", String.format("%d", day));
        fmt = fmt.replace("{h}", String.format("%02d", hour));
        fmt = fmt.replace("{m}", String.format("%02d", min));
        fmt = fmt.replace("{s}", String.format("%02d", sec));

        level.getServer().getPlayerList().broadcastMessage(new StringTextComponent(fmt), ChatType.SYSTEM, Util.NIL_UUID);

        return ActionResult.success(itemStack);
    }

}
