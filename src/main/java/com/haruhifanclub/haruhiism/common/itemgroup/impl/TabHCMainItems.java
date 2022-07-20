package com.haruhifanclub.haruhiism.common.itemgroup.impl;

import com.haruhifanclub.haruhiism.common.item.HCItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabHCMainItems extends CreativeModeTab {

    public TabHCMainItems() {
        super("haruhiismMainItems");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(HCItems.ICON_ITEM.get());
    }

}
