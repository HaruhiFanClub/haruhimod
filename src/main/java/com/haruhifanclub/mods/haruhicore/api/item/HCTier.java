package com.haruhifanclub.mods.haruhicore.api.item;

public enum HCTier {

    NONE(0), INFERIOR(1), ORDINARY(2), EXCELLENT(3), RARE(4), EPIC(5), BLESSED(6);

    public final int tier;

    private HCTier(int tier) {
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

}
