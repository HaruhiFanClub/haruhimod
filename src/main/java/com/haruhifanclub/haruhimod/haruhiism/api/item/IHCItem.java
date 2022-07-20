package com.haruhifanclub.haruhimod.haruhiism.api.item;

public interface IHCItem {

    default HCTier getHCTier() {
        return HCTier.NONE;
    }

}
