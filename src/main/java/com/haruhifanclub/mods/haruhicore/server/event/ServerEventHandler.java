package com.haruhifanclub.mods.haruhicore.server.event;

import com.haruhifanclub.mods.haruhicore.server.command.ServerCommandRegister;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerEventHandler {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        ServerCommandRegister.register(event.getDispatcher());
    }
}
