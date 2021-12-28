package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.apache.commons.lang3.RandomUtils;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
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
    public ItemStack processEnchantment(ItemStack stack, Player player) {
        ListTag enchantments = stack.getEnchantmentTags();

        int P = RandomUtils.nextInt(1, 101);
        if (P <= 33) {
            EnchUtils.enchantAll(enchantments, 1);
        } else if (P > 33 && P <= 66) {
            EnchUtils.enchantRandom(enchantments, 1);
        } else if (P > 66 && P <= 99) {
            EnchUtils.enchantOne(EnchUtils.getHighestEnchantment(enchantments), 1);
        } else {
            EnchUtils.enchantAll(enchantments, 3);
        }

        stack.getTag().remove("Enchantments");
        stack.getTag().put("Enchantments", enchantments);

        return stack;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return reinforce(context, true);
    }

}
