package com.haruhifanclub.mods.haruhicore.common.network;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.server.network.EmitMikuruBeamPacket;
import org.auioc.mods.arnicalib.api.game.network.HPacketHandler;
import org.auioc.mods.arnicalib.api.game.network.IHPacket;
import net.minecraft.server.level.ServerPlayer;

public class HCPacketHandler {

    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final HPacketHandler HANDLER = new HPacketHandler(HaruhiCore.MOD_ID, PROTOCOL_VERSION);

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
