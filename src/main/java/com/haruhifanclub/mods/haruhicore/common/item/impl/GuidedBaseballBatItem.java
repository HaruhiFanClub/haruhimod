package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCBaseballBatItem;
import org.auioc.mods.ahutils.utils.game.HItemTier;
import net.minecraft.item.crafting.Ingredient;

public class GuidedBaseballBatItem extends HCBaseballBatItem {

    public GuidedBaseballBatItem() {
        super(
            new HItemTier()
                .setDurability(708)
                .setEnchantmentValue(66)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            3,
            1.6F
        );

    }
}
