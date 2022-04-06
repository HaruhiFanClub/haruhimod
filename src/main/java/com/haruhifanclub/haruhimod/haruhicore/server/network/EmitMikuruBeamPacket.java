package com.haruhifanclub.haruhimod.haruhicore.server.network;

import java.util.UUID;
import com.haruhifanclub.haruhimod.haruhicore.common.item.HCItems;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.MikurusContactItem;
import org.auioc.mcmod.arnicalib.api.game.network.IHPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraftforge.network.NetworkEvent.Context;

public class EmitMikuruBeamPacket implements IHPacket {

    private final UUID uuid;

    public EmitMikuruBeamPacket(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void handle(Context ctx) {
        ServerPlayer sender = ctx.getSender();
        if (sender != null && this.uuid.equals(sender.getUUID())) {
            Item item = HCItems.MIKURUS_CONTACT_ITEM.get();
            if (!sender.getCooldowns().isOnCooldown(item) && MikurusContactItem.canEmitMikuruBeam(sender)) {
                MikurusContactItem.emitMikuruBeam(sender);
                sender.getCooldowns().addCooldown(item, MikurusContactItem.getCooldown());
            }
        }
    }

    @Override
    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUUID(this.uuid);
    }

    public static EmitMikuruBeamPacket decode(FriendlyByteBuf buffer) {
        return new EmitMikuruBeamPacket(buffer.readUUID());
    }

}
