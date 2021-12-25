package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCBaseballBatItem;
import org.auioc.mods.ahutils.api.item.HItemTier;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.EntityUtils;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.phys.EntityHitResult;

public class GuidedBaseballBatItem extends HCBaseballBatItem implements IHCBlessedItem {

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
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack itemStack) {
        Multimap<Attribute, AttributeModifier> oldModifiers = super.getAttributeModifiers(slot, itemStack);

        if (slot.compareTo(EquipmentSlot.MAINHAND) != 0) {
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
        if (!(entity instanceof Player)) {
            return false;
        }
        Player player = (Player) entity;
        if (player.level.isClientSide()) {
            return false;
        }

        if (player.getAttackStrengthScale(0) < 1.0F) {
            return false;
        }

        if (hitProjectile(player, getKnockbackLevel(itemStack))) {
            itemStack.hurtAndBreak(1, player, (e) -> {
                e.broadcastBreakEvent(player.getUsedItemHand());
            });
        }

        return false;
    }

    private static boolean hitProjectile(Player player, int knockbackBonus) {
        int luckBonus = 0;
        MobEffectInstance luckEffect = player.getEffect(EffectUtils.getEffect(26));
        if (luckEffect != null) {
            luckBonus = luckEffect.getAmplifier() + 1;
        }

        ProjectileEntity target;
        EntityHitResult rayHitEntity = EntityUtils.getEntityRayTraceResult(player, hitProjectileRayLength, (float) (0.45 - 0.2 * Math.pow(0.5, luckBonus)), false);
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
