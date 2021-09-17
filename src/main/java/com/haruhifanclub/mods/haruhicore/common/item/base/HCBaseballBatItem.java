package com.haruhifanclub.mods.haruhicore.common.item.base;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class HCBaseballBatItem extends SwordItem {

    protected static final List<? extends String> compatibleEnchantments = CommonConfig.BaseballBatCompatibleEnchantments.get();

    public HCBaseballBatItem(IItemTier tier, int basicAttackDamage, float attackSpeed) {
        super(tier, basicAttackDamage - 1, attackSpeed - 4.0F, new Item.Properties().tab(ItemGroupRegistry.itemGroup));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack itemStack, Enchantment enchantment) {
        if (compatibleEnchantments.contains(enchantment.getRegistryName().toString())) {
            return true;
        }
        return false;
    }

}
