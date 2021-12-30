package com.haruhifanclub.mods.haruhicore.client.keybinding;

import com.haruhifanclub.mods.haruhicore.common.item.impl.MikurusContactItem;
import com.haruhifanclub.mods.haruhicore.common.network.HCPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KeyInputHandler {

    public static void onInput() {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) {
            return;
        }

        if (KeyBindingRegistry.EMIT_MIKURU_BEAM_KEY.isDown()) {
            if (MikurusContactItem.canEmitMikuruBeam(player)) {
                HCPacketHandler.sendToServer(new com.haruhifanclub.mods.haruhicore.server.network.EmitMikuruBeamPacket(player.getUUID()));
            }
        }
    }

}
