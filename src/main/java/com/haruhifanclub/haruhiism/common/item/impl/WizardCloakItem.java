package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.function.Consumer;
import org.auioc.mcmod.hulsealib.game.item.HArmorMaterial;
import com.haruhifanclub.haruhiism.client.renderer.armor.WizardCloakArmorRenderer;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class WizardCloakItem extends HMArmorItem {

    public WizardCloakItem() {
        super(
            new HArmorMaterial("wizard_cloak")
                .setDurability(112)
                .setDefense(5)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HMItems.DANCHOU_ARMBAND_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(WizardCloakArmorRenderer.INSTANCE);
    }

}
