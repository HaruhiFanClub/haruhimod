package com.haruhifanclub.mods.haruhicore.client.keybinding;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = HaruhiCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyBindingRegistry {

    private static KeyBinding create(String name, KeyConflictContext conflict, int key) {
        return new KeyBinding("key." + HaruhiCore.MOD_ID + "." + name, conflict, InputMappings.Type.KEYSYM, key, "key.category." + HaruhiCore.MOD_ID);
    }

    private static void register(KeyBinding keyBinding) {
        ClientRegistry.registerKeyBinding(keyBinding);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(KeyInputHandler.class);

        register(CONTACT_EMIT_LASER_KEY);
    }


    public static final KeyBinding CONTACT_EMIT_LASER_KEY = create("contace_emit_laser", KeyConflictContext.IN_GAME, GLFW.GLFW_KEY_B);

}
