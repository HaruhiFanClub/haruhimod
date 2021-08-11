package org.auioc.mods.ahutils.utils.game;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public interface SoundUtils {
    static SoundEvent getSoundEvent(String key) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(key));
    }

    static void playSoundToPlayer(PlayerEntity player, String key, SoundCategory category, float volume, float pitch) {
        if (!key.equals("")) {
            player.playNotifySound(getSoundEvent(key), category, volume, pitch);
        }
    }


    static void playSoundToPlayer(PlayerEntity player, String key) {
        playSoundToPlayer(player, key, SoundCategory.MASTER, 1, 1);
    }

    static void playSoundToPlayer(PlayerEntity player, String key, float volume, float pitch) {
        playSoundToPlayer(player, key, SoundCategory.MASTER, volume, pitch);
    }

}
