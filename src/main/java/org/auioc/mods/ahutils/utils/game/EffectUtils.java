package org.auioc.mods.ahutils.utils.game;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;

public interface EffectUtils {
    static Effect getEffect(int id) {
        return Effect.byId(id);
    }

    static void addEffect(LivingEntity entity, int id, int duration, int amplifier) {
        entity.addEffect(new EffectInstance(getEffect(id), duration, amplifier, true, true));
    }
}
