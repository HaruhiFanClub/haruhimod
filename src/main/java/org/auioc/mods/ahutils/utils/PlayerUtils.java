package org.auioc.mods.ahutils.utils;

import javax.annotation.Nullable;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public interface PlayerUtils {
    @SuppressWarnings("deprecatedJava")
    static void giveItem(ServerPlayerEntity player, Item item, @Nullable CompoundNBT nbt, int count) {
        int i = count;
        while (i > 0) {
            int j = Math.min(item.getMaxStackSize(), i);
            i -= j;
            ItemStack itemStack = ItemUtils.createItemStack(item, nbt, j);
            boolean flag = player.inventory.add(itemStack);
            ItemEntity itementity = player.drop(itemStack, false);
            if (flag && itemStack.isEmpty()) {
                itemStack.setCount(1);
                if (itementity != null) {
                    itementity.makeFakeItem();
                }
                player.inventoryMenu.broadcastChanges();
            } else {
                if (itementity != null) {
                    itementity.setNoPickUpDelay();
                    itementity.setOwner(player.getUUID());
                }
            }
        }
    }

}
