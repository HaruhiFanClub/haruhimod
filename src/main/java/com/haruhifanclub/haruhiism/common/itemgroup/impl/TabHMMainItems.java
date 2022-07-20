package com.haruhifanclub.haruhiism.common.itemgroup.impl;

import com.haruhifanclub.haruhiism.common.item.HMItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabHMMainItems extends CreativeModeTab {

    public TabHMMainItems() {
        super("haruhiismMainItems");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(HMItems.ICON_ITEM.get());
    }

}
