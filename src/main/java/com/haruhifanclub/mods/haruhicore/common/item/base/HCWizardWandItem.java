package com.haruhifanclub.mods.haruhicore.common.item.base;

import com.haruhifanclub.mods.haruhicore.api.item.IHCItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.world.item.Item;

public class HCWizardWandItem extends Item implements IHCItem {

    public HCWizardWandItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(1)
        );
    }

}
