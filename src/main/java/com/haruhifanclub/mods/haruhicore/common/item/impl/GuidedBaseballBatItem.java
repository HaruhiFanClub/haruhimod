package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCBaseballBatItem;
import org.auioc.mods.ahutils.utils.game.HItemTier;
import org.auioc.mods.ahutils.utils.game.PlayerUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.EntityRayTraceResult;

public class GuidedBaseballBatItem extends HCBaseballBatItem {

    public GuidedBaseballBatItem() {
        super(
            new HItemTier()
                .setDurability(708)
                .setEnchantmentValue(66)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            3,
            1.6F
        );
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack itemStack) {
        Multimap<Attribute, AttributeModifier> oldModifiers = super.getAttributeModifiers(slot, itemStack);

        if (slot.compareTo(EquipmentSlotType.MAINHAND) != 0) {
            return oldModifiers;
        }
        if (!itemStack.isEnchanted()) {
            return oldModifiers;
        }

        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(itemStack);
        if (!ench.containsKey(Enchantments.KNOCKBACK)) {
            return oldModifiers;
        }
        int bonus = ench.get(Enchantments.KNOCKBACK);

        Multimap<Attribute, AttributeModifier> newModifiers = HashMultimap.<Attribute, AttributeModifier>create();

        Iterator<Entry<Attribute, AttributeModifier>> i = oldModifiers.entries().iterator();
        while (i.hasNext()) {
            Entry<Attribute, AttributeModifier> e = i.next();
            if (e.getKey() != Attributes.ATTACK_DAMAGE) {
                newModifiers.put(e.getKey(), e.getValue());
            } else {
                newModifiers.put(
                    Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(
                        BASE_ATTACK_DAMAGE_UUID,
                        "Weapon modifier",
                        (double) (super.getDamage() + bonus * CommonConfig.GuidedBaseballBatKnockbackDamageMultiplier.get()),
                        AttributeModifier.Operation.ADDITION
                    )
                );
            }
        }

        return newModifiers;
    }

    @Override
    public boolean onEntitySwing(ItemStack itemStack, LivingEntity entity) {
        if (!(entity instanceof PlayerEntity)) {
            return false;
        }
        PlayerEntity player = (PlayerEntity) entity;
        if (player.level.isClientSide()) {
            return false;
        }

        if (player.getAttackStrengthScale(0) < 1.0F) {
            return false;
        }

        hitProjectile(player);

        return false;
    }

    private static boolean hitProjectile(PlayerEntity player) {
        Double rayLength = CommonConfig.GuidedBaseballBatHitProjectileRayTraceLength.get();

        ProjectileEntity target;
        EntityRayTraceResult rayHitEntity = PlayerUtils.getEntityRayTraceResult(player, rayLength);
        if (rayHitEntity == null || !(rayHitEntity.getEntity() instanceof ProjectileEntity) || (rayHitEntity.getEntity() instanceof FireballEntity)) {
            return false;
        }
        target = (ProjectileEntity) rayHitEntity.getEntity();

        target.setDeltaMovement(player.getViewVector(0).scale(target.getDeltaMovement().length()));

        return true;
    }

}
