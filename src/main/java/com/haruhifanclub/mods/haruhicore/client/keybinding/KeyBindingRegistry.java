package com.haruhifanclub.mods.haruhicore.client.keybinding;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = HaruhiCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyBindingRegistry {

    private static KeyMapping create(String name, KeyConflictContext conflict, int key) {
        return new KeyMapping("key." + HaruhiCore.MOD_ID + "." + name, conflict, InputConstants.Type.KEYSYM, key, "key.category." + HaruhiCore.MOD_ID);
    }

    private static void register(KeyMapping keyBinding) {
        ClientRegistry.registerKeyBinding(keyBinding);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(KeyInputHandler.class);

        register(EMIT_MIKURU_BEAM_KEY);
    }


    public static final KeyMapping EMIT_MIKURU_BEAM_KEY = create("emit_mikuru_beam", KeyConflictContext.IN_GAME, GLFW.GLFW_KEY_B);

}
