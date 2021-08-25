package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.crafting.Ingredient;

public class WizardCloakItem extends HCArmorItem {

    public WizardCloakItem() {
        super(
            new HArmorMaterial("wizard_cloak")
                .setDurability(112)
                .setDefense(5)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemManager.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlotType.CHEST,
            null
        );
    }

    // TODO Custom armor model
}
