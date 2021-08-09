package org.auioc.mods.ahutils.server.event;

import org.auioc.mods.ahutils.server.event.impl.ServerLoginEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.CHandshakePacket;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

@OnlyIn(Dist.DEDICATED_SERVER)
public class ServerEventRegister {
    public static void registerServerLoginEvent(final CHandshakePacket packet, final NetworkManager manager) {
        MinecraftForge.EVENT_BUS.post(new ServerLoginEvent(packet, manager));
    }
}
