package com.haruhifanclub.mods.haruhicore.common.network;

import java.util.Optional;
import java.util.function.Function;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import org.auioc.mods.ahutils.api.network.IHPacket;
import org.auioc.mods.ahutils.api.network.IHPacketHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@SuppressWarnings("unused")
public class HCPacketHandler implements IHPacketHandler {

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        register();
    }

    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final SimpleChannel HANDLER = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(HaruhiCore.MOD_ID, "network"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );
    private static int index;

    public static void register() {
        registerClientToServer(com.haruhifanclub.mods.haruhicore.server.network.EmitMikuruBeamPacket.class, com.haruhifanclub.mods.haruhicore.server.network.EmitMikuruBeamPacket::decode);
    }



    private static <MSG extends IHPacket> void registerClientToServer(Class<MSG> type, Function<PacketBuffer, MSG> decoder) {
        registerMessage(type, decoder, NetworkDirection.PLAY_TO_SERVER);
    }

    private static <MSG extends IHPacket> void registerServerToClient(Class<MSG> type, Function<PacketBuffer, MSG> decoder) {
        registerMessage(type, decoder, NetworkDirection.PLAY_TO_CLIENT);
    }

    private static <MSG extends IHPacket> void registerMessage(Class<MSG> type, Function<PacketBuffer, MSG> decoder, NetworkDirection networkDirection) {
        HANDLER.registerMessage(index++, type, IHPacket::encode, decoder, IHPacket::handle, Optional.of(networkDirection));
    }

    public static <MSG extends IHPacket> void sendToServer(MSG msg) {
        HANDLER.sendToServer(msg);
    }

    public static <MSG extends IHPacket> void sendTo(ServerPlayerEntity player, MSG msg) {
        if (!(player instanceof FakePlayer)) {
            HANDLER.sendTo(msg, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
        }
    }

}
