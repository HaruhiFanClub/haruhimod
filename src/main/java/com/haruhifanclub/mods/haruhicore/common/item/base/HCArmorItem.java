package com.haruhifanclub.mods.haruhicore.common.item.base;

import com.haruhifanclub.mods.haruhicore.api.item.IHCArmorItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HCArmorItem extends ArmorItem implements IHCArmorItem {

    public HCArmorItem(ArmorMaterial material, EquipmentSlot slotType) {
        super(
            material,
            slotType,
            new Item.Properties().tab(ItemGroupRegistry.itemGroup)
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "haruhicore:textures/models/armor/" + this.material.getName() + ".png";
    }

}
