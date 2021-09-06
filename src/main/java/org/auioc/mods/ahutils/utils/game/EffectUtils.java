package org.auioc.mods.ahutils.utils.game;

import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public interface EffectUtils {

    @Nullable
    static Effect getEffect(int id) {
        return Effect.byId(id);
    }

    @Nullable
    static Effect getEffect(String id) {
        return ForgeRegistries.POTIONS.getValue(new ResourceLocation(id));
    }

    @Nullable
    static EffectInstance getEffectInstance(CompoundNBT effect_nbt) {
        if (effect_nbt.contains("id", 8) && effect_nbt.contains("duration", 3) && effect_nbt.contains("amplifier", 3)) {
            return new EffectInstance(getEffect(effect_nbt.getString("id")), effect_nbt.getInt("duration"), effect_nbt.getInt("amplifier"), true, true);
        }
        return null;
    }

    static void addEffect(LivingEntity entity, int id, int duration, int amplifier) {
        entity.addEffect(new EffectInstance(getEffect(id), duration, amplifier, true, true));
    }

}
