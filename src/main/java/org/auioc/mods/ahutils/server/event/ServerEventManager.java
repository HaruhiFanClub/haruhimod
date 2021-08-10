package org.auioc.mods.ahutils.server.event;

import org.auioc.mods.ahutils.server.event.impl.ServerLoginEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.CHandshakePacket;
import net.minecraftforge.common.MinecraftForge;

public class ServerEventManager {
    public static void postServerLoginEvent(final CHandshakePacket packet, final NetworkManager manager) {
        MinecraftForge.EVENT_BUS.post(new ServerLoginEvent(packet, manager));
    }
}
