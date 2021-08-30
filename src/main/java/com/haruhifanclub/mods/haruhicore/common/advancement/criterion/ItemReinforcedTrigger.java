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
        BooleanPredicate isSucceed = BooleanPredicate.fromJson(json, "isSucceed");
        BooleanPredicate isEpic = BooleanPredicate.fromJson(json, "isEpic");
        return new Instance(player, isEpic, isSucceed);
    }

    public void trigger(ServerPlayerEntity player, boolean isEpic, boolean isSucceed) {
        this.trigger(player, (instance) -> {
            return instance.test(player, isEpic, isSucceed);
        });
    }


    public static class Instance extends CriterionInstance {
        private final BooleanPredicate isEpic;
        private final BooleanPredicate isSucceed;

        public Instance(EntityPredicate.AndPredicate player, BooleanPredicate isEpic, BooleanPredicate isSucceed) {
            super(ID, player);
            this.isEpic = isEpic;
            this.isSucceed = isSucceed;
        }

        public boolean test(ServerPlayerEntity player, boolean isEpic, boolean isSucceed) {
            return this.isEpic.test(isEpic) && this.isSucceed.test(isSucceed);
        }

        // @Override
        // public JsonObject serializeToJson(ConditionArraySerializer serializer) {
        //     JsonObject jsonObject = super.serializeToJson(serializer);
        //     jsonObject.addProperty("isSucceed", this.isSucceed.serializeToJson());
        //     return jsonObject;
        // }

    }

}
