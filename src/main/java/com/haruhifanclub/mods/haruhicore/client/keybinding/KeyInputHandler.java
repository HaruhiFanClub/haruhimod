package com.haruhifanclub.mods.haruhicore.client.keybinding;

import com.haruhifanclub.mods.haruhicore.common.item.impl.MikurusContactItem;
import com.haruhifanclub.mods.haruhicore.common.network.HCPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class KeyInputHandler {

    @SubscribeEvent
    public static void onInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null) {
            return;
        }

        if (KeyBindingRegistry.CONTACT_EMIT_LASER_KEY.isDown()) {
            if (MikurusContactItem.canEmitLaser(player)) {
                HCPacketHandler.sendToServer(new com.haruhifanclub.mods.haruhicore.server.network.EmitLaserPacket(player.getUUID()));
            }
        }
    }

}
