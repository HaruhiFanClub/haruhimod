package com.haruhifanclub.mods.haruhicore.common.itemgroup.impl;

import com.haruhifanclub.mods.haruhicore.common.item.HCItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabHCMainItems extends CreativeModeTab {

    public TabHCMainItems() {
        super("haruhiCoreMainItems");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(HCItems.ICON_ITEM.get());
    }

}
