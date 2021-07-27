package org.auioc.mods.ahutils.utils;

import javax.annotation.Nullable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public interface ItemUtils {
    static ItemStack createItemStack(Item item, @Nullable CompoundNBT nbt, int count) {
        ItemStack itemStack = new ItemStack(item, count);
        if (nbt != null) {
            itemStack.setTag(nbt);
        }
        return itemStack;
    }
}
