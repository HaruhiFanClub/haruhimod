package com.haruhifanclub.mods.haruhicore.common.itemgroup.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MainItemGroup extends CreativeModeTab {

    public MainItemGroup() {
        super("haruhicore_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.ICON_ITEM.get());
    }

}
