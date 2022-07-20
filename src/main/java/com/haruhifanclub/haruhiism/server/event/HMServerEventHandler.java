package com.haruhifanclub.haruhiism.server.event;

import com.haruhifanclub.haruhiism.server.command.HMServerCommands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class HMServerEventHandler {

    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        HMServerCommands.register(event.getDispatcher());
    }

}
