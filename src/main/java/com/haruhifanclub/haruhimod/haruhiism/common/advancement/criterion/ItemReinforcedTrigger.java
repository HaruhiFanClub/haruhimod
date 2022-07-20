package com.haruhifanclub.haruhimod.haruhiism.common.advancement.criterion;

import com.google.gson.JsonObject;
import com.haruhifanclub.haruhimod.haruhiism.HaruhiCore;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;

public class ItemReinforcedTrigger extends SimpleCriterionTrigger<ItemReinforcedTrigger.Instance> {

    public static final ItemReinforcedTrigger INSTANCE = new ItemReinforcedTrigger();

    private static final ResourceLocation ID = new ResourceLocation(HaruhiCore.MOD_ID, "item_reinforced");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    protected ItemReinforcedTrigger.Instance createInstance(JsonObject json, EntityPredicate.Composite player, DeserializationContext parser) {
        boolean isSuccessful = GsonHelper.getAsBoolean(json, "successful", false);
        boolean isEpic = GsonHelper.getAsBoolean(json, "epic", false);
        ItemPredicate oldItem = ItemPredicate.fromJson(json.get("item"));
        ItemPredicate newItem = ItemPredicate.fromJson(json.get("reinforced_item"));
        return new Instance(player, isEpic, isSuccessful, oldItem, newItem);
    }

    public void trigger(ServerPlayer player, boolean isEpic, boolean isSuccessful, ItemStack oldItem, ItemStack newItem) {
        this.trigger(player, (instance) -> {
            return instance.test(player, isEpic, isSuccessful, oldItem, newItem);
        });
    }


    public static class Instance extends AbstractCriterionTriggerInstance {
        private final boolean isEpic;
        private final boolean isSuccessful;
        private final ItemPredicate oldItem;
        private final ItemPredicate newItem;

        public Instance(EntityPredicate.Composite player, boolean isEpic, boolean isSuccessful, ItemPredicate oldItem, ItemPredicate newItem) {
            super(ID, player);
            this.isEpic = isEpic;
            this.isSuccessful = isSuccessful;
            this.oldItem = oldItem;
            this.newItem = newItem;
        }

        public boolean test(ServerPlayer player, boolean isEpic, boolean isSuccessful, ItemStack oldItem, ItemStack newItem) {
            return (this.isEpic == isEpic)
                && (this.isSuccessful == isSuccessful)
                && this.oldItem.matches(oldItem)
                && this.newItem.matches(newItem);
        }
    }

}
