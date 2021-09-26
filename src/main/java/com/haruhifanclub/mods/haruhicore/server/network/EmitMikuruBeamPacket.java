package com.haruhifanclub.mods.haruhicore.server.network;

import java.util.UUID;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.impl.MikurusContactItem;
import org.auioc.mods.ahutils.api.network.IHPacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class EmitMikuruBeamPacket implements IHPacket {

    private final UUID uuid;

    public EmitMikuruBeamPacket(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void handle(Context ctx) {
        ServerPlayerEntity sender = ctx.getSender();
        if (sender != null && this.uuid.equals(sender.getUUID())) {
            Item item = ItemRegistry.MIKURUS_CONTACT_ITEM.get();
            if (!sender.getCooldowns().isOnCooldown(item) && MikurusContactItem.canEmitMikuruBeam(sender)) {
                MikurusContactItem.emitMikuruBeam(sender);
                sender.getCooldowns().addCooldown(item, MikurusContactItem.getCooldown());
            }
        }
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeUUID(this.uuid);
    }

    public static EmitMikuruBeamPacket decode(PacketBuffer buffer) {
        return new EmitMikuruBeamPacket(buffer.readUUID());
    }

}
