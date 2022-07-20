package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.HashMap;
import com.haruhifanclub.haruhiism.api.item.HMTier;
import com.haruhifanclub.haruhiism.common.item.base.HMWizardWandItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WizardWandItem extends HMWizardWandItem {

    private final HMTier tier;
    private static final HashMap<HMTier, Float> MAGIC_DAMAGE_MAP = new HashMap<HMTier, Float>() {
        {
            put(HMTier.INFERIOR, 2.0F);
            put(HMTier.ORDINARY, 3.0F);
            put(HMTier.EXCELLENT, 5.F);
            put(HMTier.RARE, 7.0F);
            put(HMTier.EPIC, 11.0F);
        }
    };

    public WizardWandItem(HMTier tier) {
        this.tier = tier;
    }

    @Override
    public HMTier getHMTier() {
        return this.tier;
    }

    @Override
    protected float getBaseAttackDamage(Player player, ItemStack wand) {
        return MAGIC_DAMAGE_MAP.get(this.getHMTier());
    }

}
