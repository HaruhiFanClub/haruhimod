package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

public class YukisWizardHatItem extends ArmorItem {

    public YukisWizardHatItem() {
        super(
            new HArmorMaterial("yukis_wizard_hat")
                .setDurability(708)
                .setDefense(4)
                .setToughness(4)
                .setEnchantmentValue(65)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemManager.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlotType.HEAD,
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
        );
    }

    // TODO Custom armor model

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int index, boolean selected) {
        if (world.isClientSide) {
            return;
        }

        LivingEntity livingEntity = ((LivingEntity) entity);

        ItemStack headItemStack = livingEntity.getItemBySlot(EquipmentSlotType.HEAD);
        if ((headItemStack.getItem()).equals(this)) {
            EffectUtils.addEffect(livingEntity, 11, 4, 0); // resistance
            EffectUtils.addEffect(livingEntity, 23, 4, 0); // saturation
            EffectUtils.addEffect(livingEntity, 24, 4, 0); // glowing
            EffectUtils.addEffect(livingEntity, 26, 4, 0); // luck
        }
    }

}
