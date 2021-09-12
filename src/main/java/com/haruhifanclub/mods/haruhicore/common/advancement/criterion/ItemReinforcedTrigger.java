package com.haruhifanclub.mods.haruhicore.common.advancement.criterion;

import com.google.gson.JsonObject;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class ItemReinforcedTrigger extends AbstractCriterionTrigger<ItemReinforcedTrigger.Instance> {

    public static final ItemReinforcedTrigger INSTANCE = new ItemReinforcedTrigger();

    private static final ResourceLocation ID = new ResourceLocation(HaruhiCore.MOD_ID, "item_reinforced");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected ItemReinforcedTrigger.Instance createInstance(JsonObject json, EntityPredicate.AndPredicate player, ConditionArrayParser parser) {
        BooleanPredicate isSuccessful = BooleanPredicate.fromJson(json, "successful");
        BooleanPredicate isEpic = BooleanPredicate.fromJson(json, "epic");
        ItemPredicate oldItem = ItemPredicate.fromJson(json.get("item"));
        ItemPredicate newItem = ItemPredicate.fromJson(json.get("reinforced_item"));
        return new Instance(player, isEpic, isSuccessful, oldItem, newItem);
    }

    public void trigger(ServerPlayerEntity player, boolean isEpic, boolean isSuccessful, ItemStack oldItem, ItemStack newItem) {
        this.trigger(player, (instance) -> {
            return instance.test(player, isEpic, isSuccessful, oldItem, newItem);
        });
    }


    public static class Instance extends CriterionInstance {
        private final BooleanPredicate isEpic;
        private final BooleanPredicate isSuccessful;
        private final ItemPredicate oldItem;
        private final ItemPredicate newItem;

        public Instance(EntityPredicate.AndPredicate player, BooleanPredicate isEpic, BooleanPredicate isSuccessful, ItemPredicate oldItem, ItemPredicate newItem) {
            super(ID, player);
            this.isEpic = isEpic;
            this.isSuccessful = isSuccessful;
            this.oldItem = oldItem;
            this.newItem = newItem;
        }

        public boolean test(ServerPlayerEntity player, boolean isEpic, boolean isSuccessful, ItemStack oldItem, ItemStack newItem) {
            return this.isEpic.test(isEpic)
                && this.isSuccessful.test(isSuccessful)
                && this.oldItem.matches(oldItem)
                && this.newItem.matches(newItem);
        }

        // @Override
        // public JsonObject serializeToJson(ConditionArraySerializer serializer) {
        //     JsonObject jsonObject = super.serializeToJson(serializer);
        //     jsonObject.addProperty("isSuccessful", this.isSuccessful.serializeToJson());
        //     return jsonObject;
        // }

    }

}
