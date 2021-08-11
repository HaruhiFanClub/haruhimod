package org.auioc.mods.ahutils.utils.game;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public interface MessageUtils {
    static void chat(PlayerEntity player, String message) {
        player.sendMessage(new StringTextComponent(message), Util.NIL_UUID);
    }

    static void chat(PlayerEntity player, ITextComponent message) {
        player.sendMessage(message, Util.NIL_UUID);
    }
}
