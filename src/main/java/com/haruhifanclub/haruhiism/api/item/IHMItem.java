package com.haruhifanclub.haruhiism.api.item;

public interface IHMItem {

    default HMTier getHMTier() {
        return HMTier.NONE;
    }

}
