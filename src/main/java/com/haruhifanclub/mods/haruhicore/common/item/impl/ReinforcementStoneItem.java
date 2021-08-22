package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResultType;

public class ReinforcementStoneItem extends Item implements IReinforcementStoneItem {

    public ReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
                .stacksTo(16)
        );
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack, PlayerEntity player) {
        ListNBT enchantments = stack.getEnchantmentTags();

        int enchCount = enchantments.size();

        int highestIndex = 0;
        int highestLevel = 0;
        for (int i = 0; i < enchCount; i++) {
            short lvl = enchantments.getCompound(i).getShort("lvl");
            if (lvl > highestLevel) {
                highestIndex = i;
                highestLevel = lvl;
            }
        }

        int X = highestLevel;
        int N = enchCount;
        if (N > 7) {
            N = 7;
        }

        if (N >= X) {
            if (Math.random() < (1.0 / X)) {
                // all+1
                EnchUtils.enchantAll(enchantments);
            } else {
                // random+1
                EnchUtils.enchantRandom(enchantments);
            }
        } else if (N < X) {
            if (Math.random() < (1.0 / X)) {
                if (Math.random() < 0.5) {
                    // all+1
                    EnchUtils.enchantAll(enchantments);
                } else {
                    // max+1
                    EnchUtils.enchantOne(enchantments, highestIndex);
                }
            } else if (Math.random() < (N / X)) {
                // random+1
                EnchUtils.enchantRandom(enchantments);
            } else {
                // break
                return ItemStack.EMPTY;
            }
        }

        stack.getTag().remove("Enchantments");
        stack.getTag().put("Enchantments", enchantments);

        return stack;
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        return reinforce(this, context, false);
    }
}
