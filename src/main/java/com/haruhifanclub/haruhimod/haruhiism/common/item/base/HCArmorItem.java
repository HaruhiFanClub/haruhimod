package com.haruhifanclub.haruhimod.haruhiism.common.item.base;

import com.haruhifanclub.haruhimod.haruhiism.api.item.IHCItem;
import com.haruhifanclub.haruhimod.haruhiism.common.itemgroup.HCCreativeModeTabs;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HCArmorItem extends ArmorItem implements IHCItem {

    public HCArmorItem(ArmorMaterial material, EquipmentSlot slotType) {
        super(
            material,
            slotType,
            new Item.Properties().tab(HCCreativeModeTabs.TAB_MAIN)
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "haruhicore:textures/models/armor/" + this.material.getName() + ".png";
    }

}
