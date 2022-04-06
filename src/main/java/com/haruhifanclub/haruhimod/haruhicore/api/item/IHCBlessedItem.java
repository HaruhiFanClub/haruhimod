package com.haruhifanclub.haruhimod.haruhicore.api.item;

public interface IHCBlessedItem extends IHCItem {

    @Override
    default HCTier getHCTier() {
        return HCTier.BLESSED;
    }

}
