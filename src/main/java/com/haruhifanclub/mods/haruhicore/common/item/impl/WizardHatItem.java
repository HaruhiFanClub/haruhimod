package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.client.model.WizardHatArmorModel;
import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WizardHatItem extends HCArmorItem {

    public WizardHatItem() {
        super(
            new HArmorMaterial("wizard_hat")
                .setDurability(77)
                .setDefense(2)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemManager.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlotType.HEAD
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel() {
        return (A) new WizardHatArmorModel();
    }
}
