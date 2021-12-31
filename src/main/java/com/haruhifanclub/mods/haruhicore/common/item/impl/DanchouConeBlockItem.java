package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.block.BlockRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class DanchouConeBlockItem extends BlockItem implements IHCBlessedItem {

    public DanchouConeBlockItem() {
        super(
            BlockRegistry.DANCHOU_CONE_BLOCK.get(),
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
        );
    }

    public static boolean isEquipped(Player player) {
        return (player.getItemBySlot(EquipmentSlot.HEAD).getItem()).equals(ItemRegistry.DANCHOU_CONE_BLOCK.get());

    }

}
