package com.haruhifanclub.mods.haruhicore.common.item.impl;

// import com.haruhifanclub.mods.haruhicore.client.model.WizardHatArmorModel;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.api.item.HArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;

public class WizardHatItem extends HCArmorItem {

    public WizardHatItem() {
        super(
            new HArmorMaterial("wizard_hat")
                .setDurability(77)
                .setDefense(2)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlot.HEAD
        );
    }

    // @Override
    // @OnlyIn(Dist.CLIENT)
    // @SuppressWarnings("unchecked")
    // public <A extends HumanoidModel<?>> A getArmorModel() {
    //     return (A) new WizardHatArmorModel();
    // }
}
