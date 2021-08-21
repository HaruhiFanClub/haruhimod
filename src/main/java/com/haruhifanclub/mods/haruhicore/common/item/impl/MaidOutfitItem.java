package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class MaidOutfitItem extends ArmorItem {

    public MaidOutfitItem() {
        super(
            new HArmorMaterial("maid_outfit")
                .setDurability(1096)
                .setDefense(3)
                .setEnchantmentValue(15),
            EquipmentSlotType.CHEST,
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
        );
    }

    // TODO Custom armor model
}
