package com.haruhifanclub.mods.haruhicore.common.sound;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEventRegistry {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HaruhiCore.MOD_ID);

    private static RegistryObject<SoundEvent> register(String id, String soundPath) {
        return SOUND_EVENTS.register(id, () -> createSoundEvent(soundPath));
    }

    private static SoundEvent createSoundEvent(String soundPath) {
        return new SoundEvent(new ResourceLocation(HaruhiCore.MOD_ID, soundPath));
    }


    // Music Disc
    public static final RegistryObject<SoundEvent> MUSIC_DISC_IN_THE_SUMMERTIME = register("music_disc_in_the_summertime", "music_disc.in_the_summertime");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_SOMEDAY_IN_THE_RAIN = register("music_disc_someday_in_the_rain", "music_disc.someday_in_the_rain");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_VOX_IN_BOX = register("music_disc_vox_in_box", "music_disc.vox_in_box");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_HALO = register("music_disc_halo", "music_disc.halo");

}
