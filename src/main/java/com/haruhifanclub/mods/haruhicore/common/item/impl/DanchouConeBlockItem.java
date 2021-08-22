package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.block.BlockManager;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class DanchouConeBlockItem extends BlockItem {

    public DanchouConeBlockItem() {
        super(
            BlockManager.DANCHOU_CONE_BLOCK.get(),
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
        );
    }

}
