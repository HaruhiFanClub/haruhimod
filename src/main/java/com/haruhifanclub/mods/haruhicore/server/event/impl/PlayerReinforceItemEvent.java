package com.haruhifanclub.mods.haruhicore.server.event.impl;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public abstract class PlayerReinforceItemEvent extends PlayerEvent {

    private final ItemStack itemStack;

    public PlayerReinforceItemEvent(ServerPlayerEntity player, ItemStack itemStack) {
        super(player);
        this.itemStack = itemStack;
    }

    @Override
    public ServerPlayerEntity getPlayer() {
        return (ServerPlayerEntity) super.getPlayer();
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Cancelable
    public static class Pre extends PlayerReinforceItemEvent {

        public Pre(ServerPlayerEntity player, ItemStack itemStack) {
            super(player, itemStack);
        }

    }

    public static class Post extends PlayerReinforceItemEvent {

        private final ItemStack reinforcedItemStack;

        public Post(ServerPlayerEntity player, ItemStack itemStack, ItemStack reinforcedItemStack) {
            super(player, itemStack);
            this.reinforcedItemStack = reinforcedItemStack;
        }

        public ItemStack getReinforcedItemStack() {
            return reinforcedItemStack;
        }

    }

}
