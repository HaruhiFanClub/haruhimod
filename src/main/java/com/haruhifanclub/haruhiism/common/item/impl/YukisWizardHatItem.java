package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.function.Consumer;
import org.auioc.mcmod.arnicalib.api.game.item.HArmorMaterial;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.client.render.armor.WizardHatArmorRender;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class YukisWizardHatItem extends HMArmorItem implements IHMBlessedItem {

    public YukisWizardHatItem() {
        super(
            new HArmorMaterial("yukis_wizard_hat")
                .setDurability(708)
                .setDefense(4)
                .setToughness(4)
                .setEnchantmentValue(66)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HMItems.DANCHOU_ARMBAND_ITEM.get());
                }),
            EquipmentSlot.HEAD
        );
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int index, boolean selected) {
        if (world.isClientSide()) {
            return;
        }

        LivingEntity livingEntity = ((LivingEntity) entity);

        ItemStack headItemStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        if ((headItemStack.getItem()).equals(this)) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.LUCK, 60));
        }
    }

    public static boolean isEquipped(Player player) {
        return (player.getItemBySlot(EquipmentSlot.HEAD).getItem()).equals(HMItems.YUKIS_WIZARD_HAT_ITEM.get());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(WizardHatArmorRender.INSTANCE);
    }

}
