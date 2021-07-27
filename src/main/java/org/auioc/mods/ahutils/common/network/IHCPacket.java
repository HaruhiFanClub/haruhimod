package org.auioc.mods.ahutils.common.network;

import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public interface IHCPacket {
    void handle(NetworkEvent.Context ctx);

    void encode(PacketBuffer buffer);

    static <PACKET extends IHCPacket> void handle(final PACKET message, Supplier<Context> context) {
        Context ctx = context.get();
        ctx.enqueueWork(() -> message.handle(ctx));
        ctx.setPacketHandled(true);
    }
}
