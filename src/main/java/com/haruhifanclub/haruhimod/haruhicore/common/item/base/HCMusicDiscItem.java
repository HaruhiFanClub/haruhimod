package com.haruhifanclub.haruhimod.haruhicore.common.item.base;

import java.util.function.Supplier;
import com.haruhifanclub.haruhimod.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.haruhimod.haruhicore.common.itemgroup.HCCreativeModeTabs;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class HCMusicDiscItem extends RecordItem implements IHCBlessedItem {

    public HCMusicDiscItem(Supplier<SoundEvent> soundSupplier) {
        super(
            15,
            soundSupplier,
            new Item.Properties()
                .tab(HCCreativeModeTabs.TAB_MAIN)
                .rarity(Rarity.RARE)
                .stacksTo(1)
        );
    }

}
