package org.auioc.mods.addrlimiter.event;

import org.auioc.mods.addrlimiter.AddrLimiter;
import org.auioc.mods.addrlimiter.command.CommandRegister;
import org.auioc.mods.addrlimiter.player.PlayerManager;
import org.auioc.mods.ahutils.utils.Loggers;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AddrLimiter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class EventHandler {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        Loggers.debug("[RegisterCommandsEvent]");
        CommandRegister.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void playerLoggedIn(final PlayerEvent.PlayerLoggedInEvent event) {
        Loggers.debug("[PlayerLoggedInEvent]");
        PlayerManager.getInstance().playerLogin(event.getPlayer());
    }

    @SubscribeEvent
    public static void playerLoggedOut(final PlayerEvent.PlayerLoggedOutEvent event) {
        Loggers.debug("[PlayerLoggedInEvent]");
        PlayerManager.getInstance().playerLogout(event.getPlayer());
    }
}
