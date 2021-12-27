package com.haruhifanclub.mods.haruhicore.common.item.base;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.MCTimeUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.world.level.Level;

public class HCHourglassItem extends Item {

    public HCHourglassItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(1)
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return super.use(level, player, hand);
    }


    private static Component formatTimeMessage(long[] time) {
        int[] formatedDayTime = MCTimeUtils.formatDayTime(time[0]);

        TranslatableComponent fmt = new TranslatableComponent(
            "item.haruhicore.hourglass.message.time_fmt",
            String.format("%d", formatedDayTime[0]),
            String.format("%02d", formatedDayTime[1]),
            String.format("%02d", formatedDayTime[2]),
            String.format("%02d", formatedDayTime[3])
        );

        Style style = Style.EMPTY.withHoverEvent(
            new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new TextComponent(
                    String.format("Day Time: %s\nGame Time: %s\nReal ime: %d", time[0], time[1], time[2])
                )
            )
        );

        return fmt.withStyle(style);
    }

    protected static Component getTimeMessage(Level level) {
        return formatTimeMessage(MCTimeUtils.getTime(level));
    }

    protected static Component getTimeMessage(long[] time) {
        return formatTimeMessage(time);
    }


    protected static void broadcast(Level level, Component message) {
        level.getServer().getPlayerList().broadcastMessage(message, ChatType.SYSTEM, Util.NIL_UUID);
    }

    protected static void broadcastTime(Level level, Player player) {
        broadcast(
            level,
            new TranslatableComponent("item.haruhicore.hourglass.message", player.getDisplayName(), getTimeMessage(level))
        );
    }

}
