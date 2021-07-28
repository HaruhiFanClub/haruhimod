package org.auioc.mods.ahutils.common.itemgroup;

import org.auioc.mods.ahutils.common.item.ItemManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupManager {
    public static ItemGroup itemGroup = new MainItemGroup();

    public static class MainItemGroup extends ItemGroup {
        public MainItemGroup() {
            super("ahutils_group");
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemManager.PHYSICS_EXCALIBUR_ITEM.get());
        }
    }
}
