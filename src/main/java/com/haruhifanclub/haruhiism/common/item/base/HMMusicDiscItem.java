package com.haruhifanclub.haruhiism.common.item.base;

import java.util.function.Supplier;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class HMMusicDiscItem extends RecordItem implements IHMBlessedItem {

    public HMMusicDiscItem(Supplier<SoundEvent> soundSupplier) {
        super(
            15,
            soundSupplier,
            new Item.Properties()
                .tab(HMCreativeModeTabs.TAB_MAIN)
                .rarity(Rarity.RARE)
                .stacksTo(1)
        );
    }

}
