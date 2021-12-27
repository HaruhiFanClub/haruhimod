package com.haruhifanclub.mods.haruhicore.client.keybinding;

import com.haruhifanclub.mods.haruhicore.common.item.impl.MikurusContactItem;
import com.haruhifanclub.mods.haruhicore.common.network.HCPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class KeyInputHandler {

    @SubscribeEvent
    public static void onInput(InputEvent.KeyInputEvent event) {
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
