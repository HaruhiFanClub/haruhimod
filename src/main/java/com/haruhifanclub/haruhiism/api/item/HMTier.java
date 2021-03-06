package com.haruhifanclub.haruhiism.api.item;

public enum HMTier {

    NONE(0), INFERIOR(1), ORDINARY(2), EXCELLENT(3), RARE(4), EPIC(5), BLESSED(6);

    public final int tier;

    private HMTier(int tier) {
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

}
