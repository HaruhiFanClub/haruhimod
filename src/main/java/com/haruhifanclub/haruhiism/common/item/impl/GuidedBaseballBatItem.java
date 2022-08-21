package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.auioc.mcmod.arnicalib.utils.game.RayTraceUtils;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMBaseballBatItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class GuidedBaseballBatItem extends HMBaseballBatItem implements IHMBlessedItem {

    public GuidedBaseballBatItem() {
        super(
            new ForgeTier(
                0, 708, 4.0F, 0.0F, 66,
                Tags.Blocks.NEEDS_WOOD_TOOL,
                () -> Ingredient.of(HMItems.DANCHOU_ARMBAND_ITEM.get())
            ),
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
                        (double) (super.getDamage() + bonus * Config.knockbackDamageMultiplier.get()),
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
        MobEffectInstance luckEffect = player.getEffect(MobEffects.LUCK);
        if (luckEffect != null) {
            luckBonus = luckEffect.getAmplifier() + 1;
        }

        Projectile target;
        EntityHitResult rayHitEntity = RayTraceUtils.getEntityHitResult(
            player,
            Config.hitProjectileRayTraceLength.get(),
            (float) (0.45 - 0.2 * Math.pow(0.5, luckBonus)),
            false
        );
        if (rayHitEntity == null || !(rayHitEntity.getEntity() instanceof Projectile) || (rayHitEntity.getEntity() instanceof Fireball)) {
            return false;
        }
        target = (Projectile) rayHitEntity.getEntity();

        target.setDeltaMovement(
            player.getViewVector(0)
                .scale(target.getDeltaMovement().length())
                .scale(0.4D + knockbackBonus * Config.hitProjectileKnockbackSpeedMultiplier.get())
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


    public static class Config {
        public static DoubleValue knockbackDamageMultiplier;
        public static DoubleValue hitProjectileRayTraceLength;
        public static DoubleValue hitProjectileKnockbackSpeedMultiplier;

        public static void build(final ForgeConfigSpec.Builder b) {
            knockbackDamageMultiplier = b.defineInRange("knockback_damage_multiplier", 1.5D, 0.0D, Double.MAX_VALUE);
            hitProjectileRayTraceLength = b.defineInRange("hit_projectile_max_distance", 7.5D, 0.0D, Double.MAX_VALUE);
            hitProjectileKnockbackSpeedMultiplier = b.defineInRange("hit_projectile_knockback_speed_multiplier", 0.05D, 0.0D, Double.MAX_VALUE);
        }
    }

}
