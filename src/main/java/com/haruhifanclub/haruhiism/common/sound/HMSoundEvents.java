package com.haruhifanclub.haruhiism.common.sound;

import com.haruhifanclub.haruhiism.Haruhiism;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HMSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Haruhiism.MOD_ID);

    private static RegistryObject<SoundEvent> register(String id, String soundPath) {
        return SOUND_EVENTS.register(id, () -> new SoundEvent(new ResourceLocation(Haruhiism.MOD_ID, soundPath)));
    }


    // Music Disc
    public static final RegistryObject<SoundEvent> MUSIC_DISC_IN_THE_SUMMERTIME = register("music_disc_in_the_summertime", "music_disc.in_the_summertime");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_SOMEDAY_IN_THE_RAIN = register("music_disc_someday_in_the_rain", "music_disc.someday_in_the_rain");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_VOX_IN_BOX = register("music_disc_vox_in_box", "music_disc.vox_in_box");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_HALO = register("music_disc_halo", "music_disc.halo");

}
