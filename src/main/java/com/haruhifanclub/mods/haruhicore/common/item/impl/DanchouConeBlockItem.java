package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.block.BlockRegistry;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class DanchouConeBlockItem extends BlockItem {

    public DanchouConeBlockItem() {
        super(
            BlockRegistry.DANCHOU_CONE_BLOCK.get(),
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
        );
    }

}
