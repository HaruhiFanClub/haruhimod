package com.haruhifanclub.mods.haruhicore.common.sound;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEventManager {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HaruhiCore.MOD_ID);

    private static RegistryObject<SoundEvent> register(String id, String soundPath) {
        return SOUND_EVENTS.register(id, () -> createSoundEvent(soundPath));
    }

    private static SoundEvent createSoundEvent(String soundPath) {
        return new SoundEvent(new ResourceLocation(HaruhiCore.MOD_ID, soundPath));
    }

}
