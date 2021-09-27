package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.client.model.WizardHatArmorModel;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.api.item.HArmorMaterial;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class YukisWizardHatItem extends HCArmorItem implements IHCBlessedItem {

    public YukisWizardHatItem() {
        super(
            new HArmorMaterial("yukis_wizard_hat")
                .setDurability(708)
                .setDefense(4)
                .setToughness(4)
                .setEnchantmentValue(66)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlotType.HEAD
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel() {
        return (A) new WizardHatArmorModel();
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int index, boolean selected) {
        if (world.isClientSide()) {
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

    public static boolean isYukisWizardHatEquipped(PlayerEntity player) {
        return (player.getItemBySlot(EquipmentSlotType.HEAD).getItem()).equals(ItemRegistry.YUKIS_WIZARD_HAT_ITEM.get());
    }

}
