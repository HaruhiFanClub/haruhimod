package org.auioc.mods.ahutils.common.network;

import java.util.Optional;
import java.util.function.Function;
import org.auioc.mods.ahutils.AhUtils;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public final class PacketHandler {
    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        register();
    }

    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final SimpleChannel HANDLER = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(AhUtils.MOD_ID, "network"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );
    private static int index;

    private static <MSG extends IHCPacket> void registerClientToServer(Class<MSG> type, Function<PacketBuffer, MSG> decoder) {
        registerMessage(type, decoder, NetworkDirection.PLAY_TO_SERVER);
    }

    private static <MSG extends IHCPacket> void registerServerToClient(Class<MSG> type, Function<PacketBuffer, MSG> decoder) {
        registerMessage(type, decoder, NetworkDirection.PLAY_TO_CLIENT);
    }

    private static <MSG extends IHCPacket> void registerMessage(Class<MSG> type, Function<PacketBuffer, MSG> decoder, NetworkDirection networkDirection) {
        HANDLER.registerMessage(index++, type, IHCPacket::encode, decoder, IHCPacket::handle, Optional.of(networkDirection));
    }

    public static void register() {
        // registerClientToServer(TestPacket.class, TestPacket::decode);
        registerServerToClient(org.auioc.mods.ahutils.client.network.TriggerCrashPacket.class, org.auioc.mods.ahutils.client.network.TriggerCrashPacket::decode);
    }

    public static <MSG extends IHCPacket> void sendToServer(MSG msg) {
        HANDLER.sendToServer(msg);
    }

    public static <MSG extends IHCPacket> void sendTo(ServerPlayerEntity player, MSG msg) {
        if (!(player instanceof FakePlayer)) {
            HANDLER.sendTo(msg, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
        }
    }
}
