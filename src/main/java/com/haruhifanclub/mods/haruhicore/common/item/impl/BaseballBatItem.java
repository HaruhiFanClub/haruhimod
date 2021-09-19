package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.base.HCBaseballBatItem;
import org.auioc.mods.ahutils.utils.game.HItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class BaseballBatItem extends HCBaseballBatItem {

    public BaseballBatItem() {
        super(
            new HItemTier()
                .setDurability(59)
                .setEnchantmentValue(15)
                .setRepairIngredient(() -> {
                    return Ingredient.of(Items.STICK);
                }),
            3,
            1.0F
        );
    }

}
