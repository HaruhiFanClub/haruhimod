package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.base.HCWizardWandItem;

public class WizardWandItem extends HCWizardWandItem {

    private final int tier;

    public WizardWandItem(int tier) {
        this.tier = tier;
    }

    public int getLevel() {
        return this.tier;
    }

}
