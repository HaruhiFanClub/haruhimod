package com.haruhifanclub.haruhiism.client.keybinding;

import com.haruhifanclub.haruhiism.common.item.impl.MikurusContactItem;
import com.haruhifanclub.haruhiism.common.network.HMPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HMKeyInputHandler {

    public static void onInput() {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) {
            return;
        }

        if (HMKeyMappings.EMIT_MIKURU_BEAM_KEY.isDown()) {
            if (MikurusContactItem.canEmitMikuruBeam(player)) {
                HMPacketHandler.sendToServer(new com.haruhifanclub.haruhiism.server.network.EmitMikuruBeamPacket(player.getUUID()));
            }
        }
    }

}
