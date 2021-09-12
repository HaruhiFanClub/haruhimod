package com.haruhifanclub.mods.haruhicore.common.advancement;

import com.haruhifanclub.mods.haruhicore.common.advancement.criterion.ItemReinforcedTrigger;
import com.haruhifanclub.mods.haruhicore.common.advancement.criterion.SosBadgeSlabTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;

public class CriterionRegistry {

    public static void register() {
        register(ItemReinforcedTrigger.INSTANCE);
        register(SosBadgeSlabTrigger.INSTANCE);
    }

    private static void register(AbstractCriterionTrigger<?> instance) {
        CriteriaTriggers.register(instance);
    }

}
