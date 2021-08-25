package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.crafting.Ingredient;

public class WizardHatItem extends HCArmorItem {

    public WizardHatItem() {
        super(
            new HArmorMaterial("wizard_hat")
                .setDurability(77)
                .setDefense(2)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemManager.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlotType.HEAD,
            null
        );
    }

    // TODO Custom armor model
}
