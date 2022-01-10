package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.HashMap;
import com.haruhifanclub.mods.haruhicore.api.item.HCTier;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCWizardWandItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WizardWandItem extends HCWizardWandItem {

    private final HCTier tier;
    private static final HashMap<HCTier, Float> MAGIC_DAMAGE_MAP = new HashMap<HCTier, Float>();

    public WizardWandItem(HCTier tier) {
        this.tier = tier;
    }

    @Override
    public HCTier getHCTier() {
        return this.tier;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        entity.hurt(DamageSource.indirectMagic(entity, player), MAGIC_DAMAGE_MAP.get(this.getHCTier()));
        return true;
    }


    static {
        {
            MAGIC_DAMAGE_MAP.put(HCTier.INFERIOR, 2.0F);
            MAGIC_DAMAGE_MAP.put(HCTier.ORDINARY, 3.0F);
            MAGIC_DAMAGE_MAP.put(HCTier.EXCELLENT, 5.F);
            MAGIC_DAMAGE_MAP.put(HCTier.RARE, 7.0F);
            MAGIC_DAMAGE_MAP.put(HCTier.EPIC, 11.0F);
        }
    };

}
