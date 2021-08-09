package org.auioc.mods.ahutils.server.event.impl;

import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.CHandshakePacket;
import net.minecraftforge.eventbus.api.Event;

public class ServerLoginEvent extends Event {
    private final CHandshakePacket packet;
    private final NetworkManager manager;

    public ServerLoginEvent(CHandshakePacket packet, NetworkManager manager) {
        super();
        this.packet = packet;
        this.manager = manager;
    }

    public CHandshakePacket getPacket() {
        return this.packet;
    }

    @Deprecated
    public NetworkManager getManager() {
        return this.manager;
    }

    public NetworkManager getNetworkManager() {
        return this.manager;
    }
}
