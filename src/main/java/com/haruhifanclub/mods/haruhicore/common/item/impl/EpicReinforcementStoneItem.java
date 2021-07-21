package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.utils.EnchUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResultType;

public class EpicReinforcementStoneItem extends Item implements IReinforcementStoneItem {

    public EpicReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
                .rarity(Rarity.EPIC)
                .stacksTo(64)
        );
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack) {
        ListNBT enchantments = stack.getEnchantmentTags();

        EnchUtils.enchantAll(enchantments);

        stack.getTag().remove("Enchantments");
        stack.getTag().put("Enchantments", enchantments);

        return stack;
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        return reinforce(context, true);
    }
}
