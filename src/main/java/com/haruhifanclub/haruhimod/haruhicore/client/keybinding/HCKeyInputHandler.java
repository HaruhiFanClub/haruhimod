package com.haruhifanclub.haruhimod.haruhicore.client.keybinding;

import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.MikurusContactItem;
import com.haruhifanclub.haruhimod.haruhicore.common.network.HCPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HCKeyInputHandler {

    public static void onInput() {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) {
            return;
        }

        if (HCKeyMappings.EMIT_MIKURU_BEAM_KEY.isDown()) {
            if (MikurusContactItem.canEmitMikuruBeam(player)) {
                HCPacketHandler.sendToServer(new com.haruhifanclub.haruhimod.haruhicore.server.network.EmitMikuruBeamPacket(player.getUUID()));
            }
        }
    }

}
