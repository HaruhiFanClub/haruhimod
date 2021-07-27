package org.auioc.mods.ahutils.common.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ItemGroupManager {
    public static ItemGroup itemGroup = new MainItemGroup();

    public static class MainItemGroup extends ItemGroup {
        public MainItemGroup() {
            super("ahutils_group");
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DEBUG_STICK);
        }
    }
}
