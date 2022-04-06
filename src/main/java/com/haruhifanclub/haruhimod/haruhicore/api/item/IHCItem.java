package com.haruhifanclub.haruhimod.haruhicore.api.item;

public interface IHCItem {

    default HCTier getHCTier() {
        return HCTier.NONE;
    }

}
