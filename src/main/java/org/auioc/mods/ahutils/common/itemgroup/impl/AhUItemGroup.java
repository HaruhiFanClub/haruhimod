package org.auioc.mods.ahutils.common.itemgroup.impl;

import org.auioc.mods.ahutils.common.item.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AhUItemGroup extends ItemGroup {
    public AhUItemGroup() {
        super("ahutils_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.PHYSICS_EXCALIBUR_ITEM.get());
    }
}
