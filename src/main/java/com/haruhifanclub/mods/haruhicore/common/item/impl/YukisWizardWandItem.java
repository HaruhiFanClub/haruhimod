package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.Collection;
import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCWizardWandItem;
import org.auioc.mods.ahutils.utils.game.EntityUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class YukisWizardWandItem extends HCWizardWandItem implements IHCBlessedItem {

    private static final double rightUseLength = 6.0D;
    private static final int rightUseCooldown = 496 * 20;

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack wand = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(this)) {
            return ActionResult.pass(wand);
        }

        EntityRayTraceResult rayHitEntity = EntityUtils.getEntityRayTraceResult(player, rightUseLength);
        if ((rayHitEntity == null) || !(rayHitEntity.getEntity() instanceof LivingEntity)) {
            return ActionResult.pass(wand);
        }

        if (!world.isClientSide()) {
            LivingEntity target = (LivingEntity) rayHitEntity.getEntity();
            Collection<EffectInstance> effects = target.getActiveEffects();
            for (EffectInstance effect : effects) {
                player.addEffect(effect);
            }
            target.removeAllEffects();
        }

        player.getCooldowns().addCooldown(this, rightUseCooldown);

        return ActionResult.sidedSuccess(wand, world.isClientSide());
    }

}
