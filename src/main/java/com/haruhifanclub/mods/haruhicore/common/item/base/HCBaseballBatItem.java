package com.haruhifanclub.mods.haruhicore.common.item.base;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;

public class HCBaseballBatItem extends SwordItem {

    protected static final List<? extends String> compatibleEnchantments = CommonConfig.BaseballBatCompatibleEnchantments.get();

    public HCBaseballBatItem(Tier tier, int basicAttackDamage, float attackSpeed) {
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
