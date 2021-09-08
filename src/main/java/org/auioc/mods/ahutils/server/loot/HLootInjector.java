package org.auioc.mods.ahutils.server.loot;

import java.util.HashMap;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class HLootInjector extends LootModifier {

    private HashMap<ResourceLocation, ResourceLocation> injectors = new HashMap<ResourceLocation, ResourceLocation>();

    protected HLootInjector(ILootCondition[] conditionsIn, HashMap<ResourceLocation, ResourceLocation> injectors) {
        super(conditionsIn);
        this.injectors = injectors;
    }

    private List<ItemStack> getItemStacks(LootContext context, ResourceLocation target) {
        ResourceLocation id = this.injectors.get(target);
        LootTable lootTable = context.getLootTable(id);
        LootContext context2 = new LootContext.Builder(context).create(LootParameterSets.CHEST);
        context2.setQueriedLootTableId(id); // coremod LootContext#setQueriedLootTableId
        List<ItemStack> list = lootTable.getRandomItems(context2);
        return list;
    }

    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        ResourceLocation id = context.getQueriedLootTableId();

        if (!this.injectors.containsKey(id)) {
            return generatedLoot;
        }

        generatedLoot.addAll(getItemStacks(context, id));
        return generatedLoot;
    }


    public static class Serializer extends GlobalLootModifierSerializer<HLootInjector> {

        @Override
        public HLootInjector read(ResourceLocation location, JsonObject json, ILootCondition[] conditions) {
            HashMap<ResourceLocation, ResourceLocation> injectors = new HashMap<ResourceLocation, ResourceLocation>();

            JsonArray injectorsJson = JSONUtils.getAsJsonArray(json, "injectors");
            for (JsonElement injectorJsonElement : injectorsJson) {
                JsonArray injectorJson = injectorJsonElement.getAsJsonArray();
                injectors.put(new ResourceLocation(injectorJson.get(0).getAsString()), new ResourceLocation(injectorJson.get(1).getAsString()));
            }

            return new HLootInjector(conditions, injectors);
        }

        @Override
        public JsonObject write(HLootInjector instance) {
            return null;
        }

    }

}
