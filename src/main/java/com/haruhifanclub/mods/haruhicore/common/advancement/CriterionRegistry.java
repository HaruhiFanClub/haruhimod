package com.haruhifanclub.mods.haruhicore.common.advancement;

import com.haruhifanclub.mods.haruhicore.common.advancement.criterion.ItemReinforcedTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class CriterionRegistry {
    public static void register() {
        CriteriaTriggers.register(ItemReinforcedTrigger.INSTANCE);
    }
}
