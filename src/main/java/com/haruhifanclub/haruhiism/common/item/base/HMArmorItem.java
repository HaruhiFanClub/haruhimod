package com.haruhifanclub.haruhiism.common.item.base;

import com.haruhifanclub.haruhiism.api.item.IHMItem;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HMArmorItem extends ArmorItem implements IHMItem {

    public HMArmorItem(ArmorMaterial material, EquipmentSlot slotType) {
        super(
            material,
            slotType,
            new Item.Properties().tab(HMCreativeModeTabs.TAB_MAIN)
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "haruhiism:textures/models/armor/" + this.material.getName() + ".png";
    }

}
