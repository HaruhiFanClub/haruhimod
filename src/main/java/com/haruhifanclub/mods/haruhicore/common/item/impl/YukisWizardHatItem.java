package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class YukisWizardHatItem extends ArmorItem {

    public YukisWizardHatItem() {
        super(
            new HArmorMaterial("yukis_wizard_hat")
                .setDurability(708)
                .setDefense(4)
                .setToughness(4)
                .setEnchantmentValue(65),
            EquipmentSlotType.HEAD,
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
        );
    }

    // TODO Custom armor model
}
