package com.haruhifanclub.mods.haruhicore.api.item;

public interface IHCItem {

    default HCTier getHCTier() {
        return HCTier.NONE;
    }

}
