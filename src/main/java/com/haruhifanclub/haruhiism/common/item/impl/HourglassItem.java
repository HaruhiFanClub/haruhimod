package com.haruhifanclub.haruhiism.common.item.impl;

import com.haruhifanclub.haruhiism.common.item.base.HCHourglassItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HourglassItem extends HCHourglassItem {

    public HourglassItem() {}

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!player.isSteppingCarefully()) {
            return InteractionResultHolder.pass(itemStack);
        }

        ItemCooldowns cooldownTracker = player.getCooldowns();
        if (cooldownTracker.isOnCooldown(this)) {
            return InteractionResultHolder.pass(itemStack);
        }
        cooldownTracker.addCooldown(this, 1200);

        if (!level.isClientSide()) {
            super.broadcastTime(level, player);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

}
