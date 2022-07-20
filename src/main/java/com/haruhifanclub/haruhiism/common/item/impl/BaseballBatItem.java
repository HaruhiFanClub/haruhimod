package com.haruhifanclub.haruhiism.common.item.impl;

import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMBaseballBatItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class BaseballBatItem extends HMBaseballBatItem {

    public BaseballBatItem() {
        super(
            new ForgeTier(
                0, 59, 4.0F, 0.0F, 15,
                Tags.Blocks.NEEDS_WOOD_TOOL,
                () -> Ingredient.of(HMItems.REINFORCEMENT_STONE_ITEM.get())
            ),
            3,
            1.0F
        );
    }

}
