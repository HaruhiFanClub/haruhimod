package com.haruhifanclub.haruhimod.haruhicore.common.item.impl;

import java.util.function.Consumer;
import org.auioc.mcmod.arnicalib.api.game.item.HArmorMaterial;
import com.haruhifanclub.haruhimod.haruhicore.client.render.armor.MaidOutfitArmorRender;
import com.haruhifanclub.haruhimod.haruhicore.common.item.HCItems;
import com.haruhifanclub.haruhimod.haruhicore.common.item.base.HCArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class MaidOutfitItem extends HCArmorItem {

    public MaidOutfitItem() {
        super(
            new HArmorMaterial("maid_outfit")
                .setDurability(1096)
                .setDefense(3)
                .setEnchantmentValue(15)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HCItems.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(MaidOutfitArmorRender.INSTANCE);
    }

}
