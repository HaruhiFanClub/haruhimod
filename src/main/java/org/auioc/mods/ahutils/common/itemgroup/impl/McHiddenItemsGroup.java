package org.auioc.mods.ahutils.common.itemgroup.impl;

import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraftforge.registries.ForgeRegistries;

public class McHiddenItemsGroup extends ItemGroup {
    List<String> hiddenItems = List.of(
        "debug_stick",
        "barrier",
        "command_block",
        "repeating_command_block",
        "chain_command_block",
        "command_block_minecart",
        "spawner",
        "structure_block",
        "structure_void",
        "jigsaw",
        "dragon_egg"
    );

    public McHiddenItemsGroup() {
        super("mc_hidden_items_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.COMMAND_BLOCK);
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> itemsToShowInGroup) {
        for (Item item : ForgeRegistries.ITEMS) {

            if (item != null && hiddenItems.contains(item.getRegistryName().getPath())) {
                itemsToShowInGroup.add(new ItemStack(item));
                // item.fillItemCategory(ItemGroup.TAB_SEARCH, itemsToShowInGroup);
                // item.fillItemCategory(this, itemsToShowInGroup);
            }

        }
    }
}
