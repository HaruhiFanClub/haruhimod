package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.Collection;
import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCWizardWandItem;
import org.auioc.mods.ahutils.utils.game.EntityUtils;
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
    private static final int depriveEffectCooldown = 2 * 20;

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack wand = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.pass(wand);
        }

        if (player.isSteppingCarefully()) {
            return depriveEffect(wand, player);
        } else {
            return magicAttack(wand, player);
        }
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

    private static InteractionResultHolder<ItemStack> magicAttack(ItemStack wand, Player player) {
        // TODO Magic attack
        return InteractionResultHolder.pass(wand);
    }

}
