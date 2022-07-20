package com.haruhifanclub.haruhiism.common.advancement;

import com.haruhifanclub.haruhiism.common.advancement.criterion.ItemReinforcedTrigger;
import com.haruhifanclub.haruhiism.common.advancement.criterion.SosBadgeSlabTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;

public class CriterionRegistry {

    public static void register() {
        register(ItemReinforcedTrigger.INSTANCE);
        register(SosBadgeSlabTrigger.INSTANCE);
    }

    private static <T extends CriterionTrigger<?>> void register(T instance) {
        CriteriaTriggers.register(instance);
    }

}
