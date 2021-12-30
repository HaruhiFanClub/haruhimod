package com.haruhifanclub.mods.haruhicore.client.event;

import com.haruhifanclub.mods.haruhicore.client.keybinding.KeyInputHandler;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientForgeEventHandler {

    @SubscribeEvent
    public static void onInput(InputEvent.KeyInputEvent event) {
        KeyInputHandler.onInput();
    }

}
