package com.haruhifanclub.haruhiism.common.item.base;

import org.auioc.mcmod.arnicalib.game.world.MCTimeUtils;
import com.haruhifanclub.haruhiism.api.item.IHMItem;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HMHourglassItem extends Item implements IHMItem {

    public HMHourglassItem() {
        super(
            new Item.Properties()
                .tab(HMCreativeModeTabs.TAB_MAIN)
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
            "item.haruhiism.hourglass.message.time_fmt",
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
            new TranslatableComponent("item.haruhiism.hourglass.message", player.getDisplayName(), getTimeMessage(level))
        );
    }

}
