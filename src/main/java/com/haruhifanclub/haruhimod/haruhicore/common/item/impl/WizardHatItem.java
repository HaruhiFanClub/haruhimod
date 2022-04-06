package com.haruhifanclub.haruhimod.haruhicore.common.item.impl;

import java.util.function.Consumer;
import com.haruhifanclub.haruhimod.haruhicore.client.render.armor.WizardHatArmorRender;
import com.haruhifanclub.haruhimod.haruhicore.common.item.HCItems;
import com.haruhifanclub.haruhimod.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mcmod.arnicalib.api.game.item.HArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class WizardHatItem extends HCArmorItem {

    public WizardHatItem() {
        super(
            new HArmorMaterial("wizard_hat")
                .setDurability(77)
                .setDefense(2)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HCItems.REINFORCEMENT_STONE_ITEM.get());
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
