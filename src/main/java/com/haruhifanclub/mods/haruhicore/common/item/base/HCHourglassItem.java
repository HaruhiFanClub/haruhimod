package com.haruhifanclub.mods.haruhicore.common.item.base;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.MCTimeUtils;
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

public class HCHourglassItem extends Item {

    public HCHourglassItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(1)
        );
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        return super.use(level, player, hand);
    }


    private static ITextComponent formatTimeMessage(long[] time) {
        int[] formatedDayTime = MCTimeUtils.formatDayTime(time[0]);

        TranslationTextComponent fmt = new TranslationTextComponent(
            "item.haruhicore.hourglass.message.time_fmt",
            String.format("%d", formatedDayTime[0]),
            String.format("%02d", formatedDayTime[1]),
            String.format("%02d", formatedDayTime[2]),
            String.format("%02d", formatedDayTime[3])
        );

        Style style = Style.EMPTY.withHoverEvent(
            new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new StringTextComponent(
                    String.format("Day Time: %s\nGame Time: %s\nReal ime: %d", time[0], time[1], time[2])
                )
            )
        );

        return fmt.withStyle(style);
    }

    protected static ITextComponent getTimeMessage(World level) {
        return formatTimeMessage(MCTimeUtils.getTime(level));
    }

    protected static ITextComponent getTimeMessage(long[] time) {
        return formatTimeMessage(time);
    }


    protected static void broadcast(World level, ITextComponent message) {
        level.getServer().getPlayerList().broadcastMessage(message, ChatType.SYSTEM, Util.NIL_UUID);
    }

    protected static void broadcastTime(World level, PlayerEntity player) {
        broadcast(
            level,
            new TranslationTextComponent("item.haruhicore.hourglass.message", player.getDisplayName(), getTimeMessage(level))
        );
    }

}
