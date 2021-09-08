package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.base.HCHourglassItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class HourglassItem extends HCHourglassItem {

    public HourglassItem() {}

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!player.isSteppingCarefully()) {
            return ActionResult.pass(itemStack);
        }

        CooldownTracker cooldownTracker = player.getCooldowns();
        if (cooldownTracker.isOnCooldown(this)) {
            return ActionResult.pass(itemStack);
        }
        cooldownTracker.addCooldown(this, 1200);

        if (!level.isClientSide()) {
            super.broadcastTime(level, player);
        }

        return ActionResult.sidedSuccess(itemStack, level.isClientSide());
    }

}
