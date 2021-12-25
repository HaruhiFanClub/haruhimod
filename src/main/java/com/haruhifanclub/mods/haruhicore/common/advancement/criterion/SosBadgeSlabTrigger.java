package com.haruhifanclub.mods.haruhicore.common.advancement.criterion;

import com.google.gson.JsonObject;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.JSONUtils;
import net.minecraft.resources.ResourceLocation;

public class SosBadgeSlabTrigger extends AbstractCriterionTrigger<SosBadgeSlabTrigger.Instance> {

    public static final SosBadgeSlabTrigger INSTANCE = new SosBadgeSlabTrigger();

    private static final ResourceLocation ID = new ResourceLocation(HaruhiCore.MOD_ID, "sos_badge_slab_looted");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected SosBadgeSlabTrigger.Instance createInstance(JsonObject json, EntityPredicate.AndPredicate player, ConditionArrayParser parser) {
        boolean isDouble = JSONUtils.getAsBoolean(json, "double", false);
        return new Instance(player, isDouble);
    }

    public void trigger(ServerPlayer player, boolean isDouble) {
        this.trigger(player, (instance) -> {
            return instance.test(player, isDouble);
        });
    }


    public static class Instance extends CriterionInstance {
        private final boolean isDouble;

        public Instance(EntityPredicate.AndPredicate player, boolean isDouble) {
            super(ID, player);
            this.isDouble = isDouble;
        }

        public boolean test(ServerPlayer player, boolean isDouble) {
            return (this.isDouble == isDouble);
        }

    }

}
