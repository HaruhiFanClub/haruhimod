package com.haruhifanclub.mods.haruhicore.common.advancement.criterion;

import com.google.gson.JsonObject;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;

public class SosBadgeSlabTrigger extends SimpleCriterionTrigger<SosBadgeSlabTrigger.Instance> {

    public static final SosBadgeSlabTrigger INSTANCE = new SosBadgeSlabTrigger();

    private static final ResourceLocation ID = new ResourceLocation(HaruhiCore.MOD_ID, "sos_badge_slab_looted");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected SosBadgeSlabTrigger.Instance createInstance(JsonObject json, EntityPredicate.Composite player, DeserializationContext parser) {
        boolean isDouble = GsonHelper.getAsBoolean(json, "double", false);
        return new Instance(player, isDouble);
    }

    public void trigger(ServerPlayer player, boolean isDouble) {
        this.trigger(player, (instance) -> {
            return instance.test(player, isDouble);
        });
    }


    public static class Instance extends AbstractCriterionTriggerInstance {
        private final boolean isDouble;

        public Instance(EntityPredicate.Composite player, boolean isDouble) {
            super(ID, player);
            this.isDouble = isDouble;
        }

        public boolean test(ServerPlayer player, boolean isDouble) {
            return (this.isDouble == isDouble);
        }

    }

}
