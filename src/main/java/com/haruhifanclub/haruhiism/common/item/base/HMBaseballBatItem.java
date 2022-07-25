package com.haruhifanclub.haruhiism.common.item.base;

import com.haruhifanclub.haruhiism.api.item.IHMItem;
import com.haruhifanclub.haruhiism.common.config.CommonConfig;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;

public class HMBaseballBatItem extends SwordItem implements IHMItem {

    public HMBaseballBatItem(Tier tier, int basicAttackDamage, float attackSpeed) {
        super(tier, basicAttackDamage - 1, attackSpeed - 4.0F, new Item.Properties().tab(HMCreativeModeTabs.TAB_MAIN));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack itemStack, Enchantment enchantment) {
        if ((CommonConfig.BaseballBatCompatibleEnchantments.get()).contains(enchantment.getRegistryName().toString())) {
            return true;
        }
        return false;
    }

}
