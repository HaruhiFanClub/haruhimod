package com.haruhifanclub.haruhiism.server.event;

import com.haruhifanclub.haruhiism.common.item.impl.MaidOutfitItem;
import com.haruhifanclub.haruhiism.server.command.HMServerCommands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class HMServerEventHandler {

    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        HMServerCommands.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onLivingDamage(final LivingDamageEvent event) {
        if (event.getEntityLiving() instanceof ServerPlayer player) {
            MaidOutfitItem.applyEffect(player);
        }
    }

}
