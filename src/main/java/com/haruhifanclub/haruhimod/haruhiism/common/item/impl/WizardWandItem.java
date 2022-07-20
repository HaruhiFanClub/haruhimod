package com.haruhifanclub.haruhimod.haruhiism.common.item.impl;

import java.util.HashMap;
import com.haruhifanclub.haruhimod.haruhiism.api.item.HCTier;
import com.haruhifanclub.haruhimod.haruhiism.common.item.base.HCWizardWandItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WizardWandItem extends HCWizardWandItem {

    private final HCTier tier;
    private static final HashMap<HCTier, Float> MAGIC_DAMAGE_MAP = new HashMap<HCTier, Float>() {
        {
            put(HCTier.INFERIOR, 2.0F);
            put(HCTier.ORDINARY, 3.0F);
            put(HCTier.EXCELLENT, 5.F);
            put(HCTier.RARE, 7.0F);
            put(HCTier.EPIC, 11.0F);
        }
    };

    public WizardWandItem(HCTier tier) {
        this.tier = tier;
    }

    @Override
    public HCTier getHCTier() {
        return this.tier;
    }

    @Override
    protected float getBaseAttackDamage(Player player, ItemStack wand) {
        return MAGIC_DAMAGE_MAP.get(this.getHCTier());
    }

}
