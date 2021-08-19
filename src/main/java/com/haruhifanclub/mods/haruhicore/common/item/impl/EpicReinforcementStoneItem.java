package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.CooldownTracker;

public class EpicReinforcementStoneItem extends Item implements IReinforcementStoneItem {

    public EpicReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
                .rarity(Rarity.EPIC)
                .stacksTo(16)
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
        CooldownTracker cooldownTracker = context.getPlayer().getCooldowns();

        if (cooldownTracker.isOnCooldown(this)) {
            return ActionResultType.PASS;
        }
        cooldownTracker.addCooldown(this, 40);

        return reinforce(context, true);
    }
}
