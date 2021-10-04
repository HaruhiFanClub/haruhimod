package com.haruhifanclub.mods.haruhicore.common.item.base;

import javax.annotation.Nullable;
import com.haruhifanclub.mods.haruhicore.api.item.IHCArmorItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HCArmorItem extends ArmorItem implements IHCArmorItem {

    public HCArmorItem(IArmorMaterial material, EquipmentSlotType slotType) {
        super(
            material,
            slotType,
            new Item.Properties().tab(ItemGroupRegistry.itemGroup)
        );
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel() {
        return null;
    }

    @Override
    @Nullable
    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) getArmorModel();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "haruhicore:textures/models/armor/" + this.material.getName() + ".png";
    }
}
