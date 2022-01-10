package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.arnicalib.api.game.item.HArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;

public class MaidOutfitItem extends HCArmorItem {

    public MaidOutfitItem() {
        super(
            new HArmorMaterial("maid_outfit")
                .setDurability(1096)
                .setDefense(3)
                .setEnchantmentValue(15)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    // TODO Custom armor model
}
