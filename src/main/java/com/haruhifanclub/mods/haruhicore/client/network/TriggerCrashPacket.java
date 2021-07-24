package com.haruhifanclub.mods.haruhicore.client.network;

import com.haruhifanclub.mods.haruhicore.common.network.IHCPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkEvent.Context;


public class TriggerCrashPacket implements IHCPacket {
    @Override
    public void handle(Context ctx) {
        crash();
    }

    @Override
    public void encode(PacketBuffer buffer) {}

    public static TriggerCrashPacket decode(PacketBuffer buffer) {
        return new TriggerCrashPacket();
    }

    @OnlyIn(Dist.CLIENT)
    private static void crash() {
        System.exit(-1);

        // Object[] o = null;
        // while (true) {
        // o = new Object[] {o};
        // }
    }
}
