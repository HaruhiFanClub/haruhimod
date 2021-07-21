package com.haruhifanclub.mods.haruhicore.common.itemgroup.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MainItemGroup extends ItemGroup {
    public MainItemGroup() {
        super("haruhicore_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemManager.ICON_ITEM.get());
    }
}
