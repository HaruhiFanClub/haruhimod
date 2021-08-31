package com.haruhifanclub.mods.haruhicore.common.advancement.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class ItemReinforcedTrigger extends AbstractCriterionTrigger<ItemReinforcedTrigger.Instance> {

    public static final ItemReinforcedTrigger INSTANCE = new ItemReinforcedTrigger();

    private static final ResourceLocation ID = new ResourceLocation("haruhicore", "item_reinforced");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected Instance createInstance(JsonObject json, EntityPredicate.AndPredicate player, ConditionArrayParser parser) {
        BooleanPredicate isSuccessful = BooleanPredicate.fromJson(json, "successful");
        BooleanPredicate isEpic = BooleanPredicate.fromJson(json, "epic");
        return new Instance(player, isEpic, isSuccessful);
    }

    public void trigger(ServerPlayerEntity player, boolean isEpic, boolean isSuccessful) {
        this.trigger(player, (instance) -> {
            return instance.test(player, isEpic, isSuccessful);
        });
    }


    public static class Instance extends CriterionInstance {
        private final BooleanPredicate isEpic;
        private final BooleanPredicate isSuccessful;

        public Instance(EntityPredicate.AndPredicate player, BooleanPredicate isEpic, BooleanPredicate isSuccessful) {
            super(ID, player);
            this.isEpic = isEpic;
            this.isSuccessful = isSuccessful;
        }

        public boolean test(ServerPlayerEntity player, boolean isEpic, boolean isSuccessful) {
            return this.isEpic.test(isEpic) && this.isSuccessful.test(isSuccessful);
        }

        // @Override
        // public JsonObject serializeToJson(ConditionArraySerializer serializer) {
        //     JsonObject jsonObject = super.serializeToJson(serializer);
        //     jsonObject.addProperty("isSuccessful", this.isSuccessful.serializeToJson());
        //     return jsonObject;
        // }

    }

}
