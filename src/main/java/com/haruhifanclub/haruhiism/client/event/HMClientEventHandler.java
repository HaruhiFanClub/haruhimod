package com.haruhifanclub.haruhiism.client.event;

import com.haruhifanclub.haruhiism.client.keybinding.HMKeyInputHandler;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HMClientEventHandler {

    @SubscribeEvent
    public static void onInput(InputEvent.KeyInputEvent event) {
        HMKeyInputHandler.onInput();
    }

}
