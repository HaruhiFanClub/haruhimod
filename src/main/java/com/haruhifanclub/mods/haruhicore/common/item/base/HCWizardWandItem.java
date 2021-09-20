package com.haruhifanclub.mods.haruhicore.common.item.base;

import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.item.Item;

public class HCWizardWandItem extends Item {

    public HCWizardWandItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(1)
        );
    }

}
