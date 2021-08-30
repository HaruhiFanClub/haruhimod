package com.haruhifanclub.mods.haruhicore.common.advancement.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.EntityPredicate.AndPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

public class ItemReinforcedTrigger extends AbstractCriterionTrigger<ItemReinforcedTrigger.Instance> {

    public static final ItemReinforcedTrigger INSTANCE = new ItemReinforcedTrigger();

    private static final ResourceLocation ID = new ResourceLocation("haruhicore", "item_reinforced");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected Instance createInstance(JsonObject json, AndPredicate player, ConditionArrayParser parser) {
        boolean isSucceed = JSONUtils.getAsBoolean(json, "isSucceed");
        return new Instance(player, isSucceed);
    }

    public void trigger(ServerPlayerEntity player, boolean isSucceed) {
        this.trigger(player, (instance) -> {
            return instance.test(player, isSucceed);
        });
    }


    public static class Instance extends CriterionInstance {
        private final boolean isSucceed;

        public Instance(EntityPredicate.AndPredicate player, boolean isSucceed) {
            super(ID, player);
            this.isSucceed = isSucceed;
        }

        public boolean test(ServerPlayerEntity player, boolean isSucceed) {
            return isSucceed == this.isSucceed;
        }

        @Override
        public JsonObject serializeToJson(ConditionArraySerializer serializer) {
            JsonObject jsonObject = super.serializeToJson(serializer);
            jsonObject.addProperty("isSucceed", this.isSucceed);
            return jsonObject;
        }

    }

}
