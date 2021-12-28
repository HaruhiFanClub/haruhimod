package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.api.item.HArmorMaterial;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

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
            EquipmentSlot.CHEST
        );
    }

    // TODO Custom armor model

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int index, boolean selected) {
        if (world.isClientSide()) {
            return;
        }

        Player player = ((Player) entity);

        ItemStack chestItemStack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(chestItemStack.getItem()).equals(this)) {
            return;
        }

        if (!player.hasEffect(MobEffects.ABSORPTION)) {
            EffectUtils.addEffect(player, 22, effectDuration, 2);
        }
    }

    public static boolean isEquipped(Player player) {
        return (player.getItemBySlot(EquipmentSlot.CHEST).getItem()).equals(ItemRegistry.YUKIS_WIZARD_CLOAK_ITEM.get());
    }

}
