package com.haruhifanclub.haruhimod.haruhicore.common.item.impl;

import java.util.Collection;
import org.auioc.mcmod.arnicalib.utils.game.EntityUtils;
import com.haruhifanclub.haruhimod.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.base.HCWizardWandItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class YukisWizardWandItem extends HCWizardWandItem implements IHCBlessedItem {

    private static final double depriveEffectLength = 6.0D;
    private static final int DEPRIVE_EFFECT_COOLDOWN = 2 * 20;
    private static final float BASE_ATTACK_DAMAGE = 13.0F;
    private static final float BASIC_ATTACK_DAMAGE_BONUS = 2.718F;
    private static final float YUKIS_ATTACK_DAMAGE_BONUS = 3.142F;

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

        player.getCooldowns().addCooldown(wand.getItem(), DEPRIVE_EFFECT_COOLDOWN);

        return InteractionResultHolder.sidedSuccess(wand, player.level.isClientSide());
    }

    @Override
    protected float getBaseAttackDamage(Player player, ItemStack wand) {
        float bonus;
        if (YukisWizardHatItem.isEquipped(player) && YukisWizardCloakItem.isEquipped(player)) {
            bonus = YUKIS_ATTACK_DAMAGE_BONUS;
        } else {
            bonus = BASIC_ATTACK_DAMAGE_BONUS;
        }

        float damage = BASE_ATTACK_DAMAGE + bonus * (float) player.getActiveEffects().size();

        damage = damage >= 32.0F ? 42.0F : damage;

        return damage;
    }

}
