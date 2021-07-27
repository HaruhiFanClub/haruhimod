package org.auioc.mods.ahutils.client.network;

import org.auioc.mods.ahutils.common.network.IHCPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkEvent.Context;


public class TriggerCrashPacket implements IHCPacket {
    private final int mode;

    public TriggerCrashPacket(int flag) {
        this.mode = flag;
    }

    @Override
    public void handle(Context ctx) {
        crash(mode);
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeInt(mode);
    }

    public static TriggerCrashPacket decode(PacketBuffer buffer) {
        return new TriggerCrashPacket(buffer.readInt());
    }

    @OnlyIn(Dist.CLIENT)
    private static void crash(int flag) {
        // TODO: Use minecraft CrashReport
        System.out.println("Crashes triggered by server-side command, mode " + flag);
        switch (flag) {
            case 0: {
                System.exit(-1);
                break;
            }
            case 1: {
                Object[] o = null;
                while (true) {
                    o = new Object[] {o};
                }
            }
            default:
                System.out.println("Undefined crash mode");
                break;
        }
    }
}
