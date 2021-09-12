package org.auioc.mods.ahutils.server.event;

import org.auioc.mods.ahutils.server.config.ServerConfig;
import org.auioc.mods.ahutils.server.command.ServerCommandRegistry;
import org.auioc.mods.ahutils.server.event.impl.ServerLoginEvent;
import org.auioc.mods.ahutils.utils.LogUtil;
import org.auioc.mods.ahutils.utils.addrlimiter.player.PlayerManager;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerEventHandler {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        ServerCommandRegistry.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void playerLoggedIn(final PlayerEvent.PlayerLoggedInEvent event) {
        if (ServerConfig.EnableAddrLimiter.get()) {
            PlayerManager.getInstance().playerLogin(event.getPlayer());
        }
    }

    @SubscribeEvent
    public static void playerLoggedOut(final PlayerEvent.PlayerLoggedOutEvent event) {
        if (ServerConfig.EnableAddrLimiter.get()) {
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
