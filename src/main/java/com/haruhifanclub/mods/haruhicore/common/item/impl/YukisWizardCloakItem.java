package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.api.item.HArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class YukisWizardCloakItem extends HCArmorItem implements IHCBlessedItem {

    private static final int effectDuration = CommonConfig.YukisWizardCloakEffectDuration.get() * 20;

    public YukisWizardCloakItem() {
        super(
            new HArmorMaterial("yukis_wizard_cloak")
                .setDurability(708)
                .setDefense(10)
                .setToughness(4)
                .setEnchantmentValue(66)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlotType.CHEST
        );
    }

    // TODO Custom armor model

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int index, boolean selected) {
        if (world.isClientSide()) {
            return;
        }

        PlayerEntity player = ((PlayerEntity) entity);

        ItemStack chestItemStack = player.getItemBySlot(EquipmentSlotType.CHEST);
        if (!(chestItemStack.getItem()).equals(this)) {
            return;
        }

        if (!player.hasEffect(Effects.ABSORPTION)) {
            EffectUtils.addEffect(player, 22, effectDuration, 2);
        }
    }

    public static boolean isYukisWizardCloakEquipped(PlayerEntity player) {
        return (player.getItemBySlot(EquipmentSlotType.CHEST).getItem()).equals(ItemRegistry.YUKIS_WIZARD_CLOAK_ITEM.get());
    }

}
