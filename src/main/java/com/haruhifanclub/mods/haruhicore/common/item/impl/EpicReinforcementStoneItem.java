package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResultType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EpicReinforcementStoneItem extends Item implements IReinforcementStoneItem, IHCBlessedItem {

    public EpicReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .rarity(Rarity.EPIC)
                .stacksTo(16)
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack, PlayerEntity player) {
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
