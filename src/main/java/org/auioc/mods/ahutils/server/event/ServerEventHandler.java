package org.auioc.mods.ahutils.server.event;

import org.auioc.mods.ahutils.server.command.ServerCommandRegistry;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerEventHandler {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        ServerCommandRegistry.register(event.getDispatcher());
    }
}
