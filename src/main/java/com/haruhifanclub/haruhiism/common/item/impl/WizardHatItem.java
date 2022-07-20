package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.function.Consumer;
import org.auioc.mcmod.arnicalib.api.game.item.HArmorMaterial;
import com.haruhifanclub.haruhiism.client.render.armor.WizardHatArmorRender;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class WizardHatItem extends HMArmorItem {

    public WizardHatItem() {
        super(
            new HArmorMaterial("wizard_hat")
                .setDurability(77)
                .setDefense(2)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HMItems.DANCHOU_ARMBAND_ITEM.get());
                }),
            EquipmentSlot.HEAD
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(WizardHatArmorRender.INSTANCE);
    }

}
