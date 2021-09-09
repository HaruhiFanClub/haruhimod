package com.haruhifanclub.mods.haruhicore.common.advancement.criterion;

import com.google.gson.JsonObject;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class SosBadgeSlabTrigger extends AbstractCriterionTrigger<SosBadgeSlabTrigger.Instance> {

    public static final SosBadgeSlabTrigger INSTANCE = new SosBadgeSlabTrigger();

    private static final ResourceLocation ID = new ResourceLocation(HaruhiCore.MOD_ID, "sos_badge_slab_looted");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected SosBadgeSlabTrigger.Instance createInstance(JsonObject json, EntityPredicate.AndPredicate player, ConditionArrayParser parser) {
        return null;
    }

    public void trigger(ServerPlayerEntity player) {
        this.trigger(player, (instance) -> {
            return instance.test(player);
        });
    }


    public static class Instance extends CriterionInstance {

        public Instance(EntityPredicate.AndPredicate player) {
            super(ID, player);
        }

        public boolean test(ServerPlayerEntity player) {
            return true;
        }

    }

}
