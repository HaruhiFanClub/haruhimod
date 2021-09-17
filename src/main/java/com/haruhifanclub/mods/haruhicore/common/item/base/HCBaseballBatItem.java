package com.haruhifanclub.mods.haruhicore.common.item.base;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class HCBaseballBatItem extends SwordItem {

    public HCBaseballBatItem(IItemTier tier, int basicAttackDamage, float attackSpeed) {
        super(tier, basicAttackDamage - 1, attackSpeed - 4.0F, new Item.Properties().tab(ItemGroupRegistry.itemGroup));
    }

}
