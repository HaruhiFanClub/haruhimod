package com.haruhifanclub.mods.haruhicore.client.event;

import com.haruhifanclub.mods.haruhicore.client.keybinding.KeyBindingRegistry;
import com.haruhifanclub.mods.haruhicore.client.model.LayerDefinitionRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientModEventHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        KeyBindingRegistry.register();
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        LayerDefinitionRegistry.register(event);
    }

}
