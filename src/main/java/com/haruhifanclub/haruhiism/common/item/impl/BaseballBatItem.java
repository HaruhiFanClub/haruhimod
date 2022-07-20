package com.haruhifanclub.haruhiism.common.item.impl;

import com.haruhifanclub.haruhiism.common.item.HCItems;
import com.haruhifanclub.haruhiism.common.item.base.HCBaseballBatItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class BaseballBatItem extends HCBaseballBatItem {

    public BaseballBatItem() {
        super(
            new ForgeTier(
                0, 59, 4.0F, 0.0F, 15,
                Tags.Blocks.NEEDS_WOOD_TOOL,
                () -> Ingredient.of(HCItems.REINFORCEMENT_STONE_ITEM.get())
            ),
            3,
            1.0F
        );
    }

}
