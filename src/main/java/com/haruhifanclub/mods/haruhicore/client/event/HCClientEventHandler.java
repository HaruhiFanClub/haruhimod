package com.haruhifanclub.mods.haruhicore.client.event;

import com.haruhifanclub.mods.haruhicore.client.keybinding.HCKeyInputHandler;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HCClientEventHandler {

    @SubscribeEvent
    public static void onInput(InputEvent.KeyInputEvent event) {
        HCKeyInputHandler.onInput();
    }

}
