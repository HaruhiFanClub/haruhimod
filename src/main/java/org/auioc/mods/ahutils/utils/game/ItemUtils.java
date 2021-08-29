package org.auioc.mods.ahutils.utils.game;

import javax.annotation.Nullable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public interface ItemUtils {

    static String getRegistryName(Item item) {
        return item.getRegistryName().toString();
    }

    static String getRegistryName(ItemStack itemStack) {
        return getRegistryName(itemStack.getItem());
    }

    static String toString(ItemStack itemStack) {
        return String.format("%s%s * %d", getRegistryName(itemStack), (itemStack.hasTag()) ? itemStack.getTag() : "{}", itemStack.getCount());
    }

    static ItemStack createItemStack(Item item, @Nullable CompoundNBT nbt, int count) {
        ItemStack itemStack = new ItemStack(item, count);
        if (nbt != null) {
            itemStack.setTag(nbt);
        }
        return itemStack;
    }

}
