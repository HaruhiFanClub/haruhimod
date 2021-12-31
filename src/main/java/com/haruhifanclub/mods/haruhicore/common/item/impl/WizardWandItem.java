package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.HCTier;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCWizardWandItem;

public class WizardWandItem extends HCWizardWandItem {

    private final HCTier tier;

    public WizardWandItem(HCTier tier) {
        this.tier = tier;
    }

    @Override
    public HCTier getHCTier() {
        return this.tier;
    }

}
