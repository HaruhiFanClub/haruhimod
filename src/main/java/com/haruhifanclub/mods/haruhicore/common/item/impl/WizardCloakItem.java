package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.function.Consumer;
import com.haruhifanclub.mods.haruhicore.client.render.armor.WizardCloakArmorRender;
import com.haruhifanclub.mods.haruhicore.common.item.HCItems;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.arnicalib.api.game.item.HArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class WizardCloakItem extends HCArmorItem {

    public WizardCloakItem() {
        super(
            new HArmorMaterial("wizard_cloak")
                .setDurability(112)
                .setDefense(5)
                .setEnchantmentValue(25)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HCItems.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(WizardCloakArmorRender.INSTANCE);
    }

}
