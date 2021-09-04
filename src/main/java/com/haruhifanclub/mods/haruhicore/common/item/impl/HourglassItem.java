package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.HoverEvent;
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

        TranslationTextComponent fmt = new TranslationTextComponent(
            "item.haruhicore.hourglass.message.time_fmt",
            String.format("%d", day),
            String.format("%02d", hour),
            String.format("%02d", min),
            String.format("%02d", sec)
        );

        Style style = Style.EMPTY.withHoverEvent(
            new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new StringTextComponent(
                    String.format("Day time: %s\nGame time: %s", rawDayTime, level.getGameTime())
                )
            )
        );

        ITextComponent message = new TranslationTextComponent(
            "item.haruhicore.hourglass.message",
            player.getDisplayName(),
            fmt.withStyle(style)
        );

        level.getServer().getPlayerList().broadcastMessage(message, ChatType.SYSTEM, Util.NIL_UUID);

        return ActionResult.sidedSuccess(itemStack, false);
    }

}
