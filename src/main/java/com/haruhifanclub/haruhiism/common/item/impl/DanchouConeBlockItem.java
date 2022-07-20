package com.haruhifanclub.haruhiism.common.item.impl;

import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.common.block.HMBlocks;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class DanchouConeBlockItem extends BlockItem implements IHMBlessedItem {

    public DanchouConeBlockItem() {
        super(
            HMBlocks.DANCHOU_CONE_BLOCK.get(),
            new Item.Properties()
                .tab(HMCreativeModeTabs.TAB_MAIN)
        );
    }

    public static boolean isEquipped(Player player) {
        return (player.getItemBySlot(EquipmentSlot.HEAD).getItem()).equals(HMItems.DANCHOU_CONE_BLOCK.get());

    }

}
