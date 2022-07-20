package com.haruhifanclub.haruhiism.server.event;

import com.haruhifanclub.haruhiism.server.command.HCServerCommands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class HCServerEventHandler {

    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        HCServerCommands.register(event.getDispatcher());
    }

}
