package org.auioc.mods.ahutils.common.itemgroup.impl;

import org.auioc.mods.ahutils.common.item.ItemManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AhUItemGroup extends ItemGroup {
    public AhUItemGroup() {
        super("ahutils_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemManager.PHYSICS_EXCALIBUR_ITEM.get());
    }
}
