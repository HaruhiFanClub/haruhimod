package com.haruhifanclub.haruhimod.haruhiism.client.event;

import com.haruhifanclub.haruhimod.haruhiism.client.keybinding.HCKeyInputHandler;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HCClientEventHandler {

    @SubscribeEvent
    public static void onInput(InputEvent.KeyInputEvent event) {
        HCKeyInputHandler.onInput();
    }

}
