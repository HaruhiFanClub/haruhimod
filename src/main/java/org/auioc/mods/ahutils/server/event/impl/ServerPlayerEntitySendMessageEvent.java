package org.auioc.mods.ahutils.server.event.impl;

import java.util.UUID;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class ServerPlayerEntitySendMessageEvent extends Event {
    public ServerPlayerEntitySendMessageEvent(ITextComponent message, ChatType type, UUID uuid) {
        super();
    }
}
