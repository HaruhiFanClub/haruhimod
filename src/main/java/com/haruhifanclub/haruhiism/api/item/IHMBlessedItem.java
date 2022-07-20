package com.haruhifanclub.haruhiism.api.item;

public interface IHMBlessedItem extends IHMItem {

    @Override
    default HMTier getHMTier() {
        return HMTier.BLESSED;
    }

}
