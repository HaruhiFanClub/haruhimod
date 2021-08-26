package com.haruhifanclub.mods.haruhicore.common.item.base;

import java.util.function.Supplier;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvent;

public class HCMusicDiscItem extends MusicDiscItem {

    public HCMusicDiscItem(Supplier<SoundEvent> soundSupplier) {
        super(
            15,
            soundSupplier,
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
                .rarity(Rarity.RARE)
                .stacksTo(1)
        );
    }

}
