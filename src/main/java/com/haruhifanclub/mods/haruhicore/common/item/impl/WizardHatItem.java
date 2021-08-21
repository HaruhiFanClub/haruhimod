package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class WizardHatItem extends ArmorItem {

    public WizardHatItem() {
        super(
            new HArmorMaterial("wizard_hat")
                .setDurability(77)
                .setDefense(2)
                .setEnchantmentValue(25),
            EquipmentSlotType.HEAD,
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
        );
    }

    // TODO Custom armor model
}
