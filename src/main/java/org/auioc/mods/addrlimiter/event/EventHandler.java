package org.auioc.mods.addrlimiter.event;

import org.auioc.mods.addrlimiter.command.CommandRegister;
import org.auioc.mods.addrlimiter.config.Config;
import org.auioc.mods.addrlimiter.player.PlayerManager;
import org.auioc.mods.ahutils.server.event.impl.ServerLoginEvent;
import org.auioc.mods.ahutils.utils.LogUtil;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandRegister.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void playerLoggedIn(final PlayerEvent.PlayerLoggedInEvent event) {
        if (Config.EnableAddrLimiter.get()) {
            PlayerManager.getInstance().playerLogin(event.getPlayer());
        }
    }

    @SubscribeEvent
    public static void playerLoggedOut(final PlayerEvent.PlayerLoggedOutEvent event) {
        if (Config.EnableAddrLimiter.get()) {
            PlayerManager.getInstance().playerLogout(event.getPlayer());
        }
    }

    @SubscribeEvent
    public static void onPing(final ServerLoginEvent event) {
        if (event.getPacket().getIntention() == net.minecraft.network.ProtocolType.STATUS) {
            LogUtil.info(String.format("[%s] <-> InitialHandler has pinged", event.getNetworkManager().getRemoteAddress().toString()));
        }
    }
}
