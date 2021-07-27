package org.auioc.mods.addrlimiter.event;

import org.auioc.mods.addrlimiter.AddrLimiter;
import org.auioc.mods.addrlimiter.command.CommandRegister;
import org.auioc.mods.addrlimiter.player.PlayerManager;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AddrLimiter.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class EventHandler {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandRegister.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void playerLoggedIn(final PlayerEvent.PlayerLoggedInEvent event) {
        PlayerManager.getInstance().playerLogin(event.getPlayer());
    }

    @SubscribeEvent
    public static void playerLoggedOut(final PlayerEvent.PlayerLoggedOutEvent event) {
        PlayerManager.getInstance().playerLogout(event.getPlayer());
    }
}
