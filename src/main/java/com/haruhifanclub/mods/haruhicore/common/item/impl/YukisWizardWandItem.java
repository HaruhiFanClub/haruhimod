package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.Collection;
import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCWizardWandItem;
import org.auioc.mods.arnicalib.utils.game.EntityUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class YukisWizardWandItem extends HCWizardWandItem implements IHCBlessedItem {

    private static final double depriveEffectLength = 6.0D;
    private static final int depriveEffectCooldown = 2 * 20;
    private static final float baseMagicAttackDamage = 13.0F;

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack wand = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.pass(wand);
        }

        if (player.isSteppingCarefully()) {
            return depriveEffect(wand, player);
        }

        return InteractionResultHolder.pass(wand);
    }

    private static InteractionResultHolder<ItemStack> depriveEffect(ItemStack wand, Player player) {
        EntityHitResult rayHitEntity = EntityUtils.getEntityHitResult(player, depriveEffectLength);
        if ((rayHitEntity == null) || !(rayHitEntity.getEntity() instanceof LivingEntity)) {
            return InteractionResultHolder.pass(wand);
        }

        if (!player.level.isClientSide()) {
            LivingEntity target = (LivingEntity) rayHitEntity.getEntity();
            Collection<MobEffectInstance> effects = target.getActiveEffects();
            for (MobEffectInstance effect : effects) {
                player.addEffect(effect);
            }
            target.removeAllEffects();
        }

        player.getCooldowns().addCooldown(wand.getItem(), depriveEffectCooldown);

        return InteractionResultHolder.sidedSuccess(wand, player.level.isClientSide());
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (player.getCooldowns().isOnCooldown(this)) {
            return true;
        }
        entity.hurt(DamageSource.indirectMagic(entity, player), getMagicAttackDamage(player));
        return true;
    }

    private static float getMagicAttackDamage(Player player) {
        float bonus = 2.718F;
        if (YukisWizardHatItem.isEquipped(player) && YukisWizardCloakItem.isEquipped(player)) {
            bonus = 3.142F;
        }
        float damage = baseMagicAttackDamage + bonus * (float) player.getActiveEffects().size();
        return damage >= 32.0F ? 42.0F : damage;
    }

}
