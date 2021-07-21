package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.utils.EnchUtils;
import org.auioc.mods.utils.Loggers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResultType;

public class ReinforcementStoneItem extends Item implements IReinforcementStoneItem {

    public ReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
                .rarity(Rarity.UNCOMMON)
                .stacksTo(16)
        );
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack) {
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
                Loggers.debug("2 - 1"); // all+1
                EnchUtils.enchantAll(enchantments);
            } else {
                Loggers.debug("2 - 2"); // random+1
                EnchUtils.enchantRandom(enchantments);
            }
        } else if (N < X) {
            if (Math.random() < (1.0 / X)) {
                if (Math.random() < 0.5) {
                    Loggers.debug("1 - 1"); // all+1
                    EnchUtils.enchantAll(enchantments);
                } else {
                    Loggers.debug("1 - 2");// max+1
                    EnchUtils.enchantOne(enchantments, highestIndex);
                }
            } else if (Math.random() < (N / X)) {
                Loggers.debug("1 - 3");// random+1
                EnchUtils.enchantRandom(enchantments);
            } else {
                Loggers.debug("1 - 4");// break
                return ItemStack.EMPTY;
            }
        }

        stack.getTag().remove("Enchantments");
        stack.getTag().put("Enchantments", enchantments);

        return stack;
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        return reinforce(context, false);
    }
}
