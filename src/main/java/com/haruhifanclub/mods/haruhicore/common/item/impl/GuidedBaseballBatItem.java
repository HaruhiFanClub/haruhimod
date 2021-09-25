package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.haruhifanclub.mods.haruhicore.api.item.IBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCBaseballBatItem;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.EntityUtils;
import org.auioc.mods.ahutils.api.item.HItemTier;
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
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.EntityRayTraceResult;

public class GuidedBaseballBatItem extends HCBaseballBatItem implements IBlessedItem {

    private static final double knockbackDamageMultiplier = CommonConfig.GuidedBaseballBatKnockbackDamageMultiplier.get();
    private static final double hitProjectileRayLength = CommonConfig.GuidedBaseballBatHitProjectileRayTraceLength.get();
    private static final double hitProjectileKnockbackSpeedMultiplier = CommonConfig.GuidedBaseballBatHitProjectileKnockbackSpeedMultiplier.get();

    public GuidedBaseballBatItem() {
        super(
            new HItemTier()
                .setDurability(708)
                .setEnchantmentValue(66)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            3,
            1.0F
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

        int bonus = getKnockbackLevel(itemStack);
        if (bonus == 0) {
            return oldModifiers;
        }

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
                        (double) (super.getDamage() + bonus * knockbackDamageMultiplier),
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

        hitProjectile(player, getKnockbackLevel(itemStack));

        return false;
    }

    private static boolean hitProjectile(PlayerEntity player, int knockbackBonus) {
        int luckBonus = 0;
        EffectInstance luckEffect = player.getEffect(EffectUtils.getEffect(26));
        if (luckEffect != null) {
            luckBonus = luckEffect.getAmplifier() + 1;
        }

        ProjectileEntity target;
        EntityRayTraceResult rayHitEntity = EntityUtils.getEntityRayTraceResult(player, hitProjectileRayLength, (float) (0.45 - 0.2 * Math.pow(0.5, luckBonus)));
        if (rayHitEntity == null || !(rayHitEntity.getEntity() instanceof ProjectileEntity) || (rayHitEntity.getEntity() instanceof FireballEntity)) {
            return false;
        }
        target = (ProjectileEntity) rayHitEntity.getEntity();

        target.setDeltaMovement(
            player.getViewVector(0)
                .scale(target.getDeltaMovement().length())
                .scale(0.4D + knockbackBonus * hitProjectileKnockbackSpeedMultiplier)
        );

        return true;
    }

    private static int getKnockbackLevel(ItemStack itemStack) {
        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(itemStack);
        if (!ench.containsKey(Enchantments.KNOCKBACK)) {
            return 0;
        }
        return ench.get(Enchantments.KNOCKBACK);
    }

}
