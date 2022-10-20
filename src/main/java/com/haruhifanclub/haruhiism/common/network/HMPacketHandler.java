package com.haruhifanclub.haruhiism.common.network;

import org.auioc.mcmod.arnicalib.game.network.HPacketHandler;
import org.auioc.mcmod.arnicalib.game.network.IHPacket;
import com.haruhifanclub.haruhiism.Haruhiism;
import com.haruhifanclub.haruhiism.server.network.EmitMikuruBeamPacket;
import net.minecraft.server.level.ServerPlayer;

public class HMPacketHandler {

    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final HPacketHandler HANDLER = new HPacketHandler(Haruhiism.MOD_ID, PROTOCOL_VERSION);

    public static void init() {
        registerMessage();
    }

    private static void registerMessage() {
        HANDLER.registerClientToServer(EmitMikuruBeamPacket.class, EmitMikuruBeamPacket::decode);
    }

    public static <MSG extends IHPacket> void sendToServer(MSG msg) {
        HANDLER.sendToServer(msg);
    }

    public static <MSG extends IHPacket> void sendToClient(ServerPlayer player, MSG msg) {
        HANDLER.sendToClient(player, msg);
    }

}
