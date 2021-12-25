package com.haruhifanclub.mods.haruhicore.server.event.impl;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public abstract class PlayerReinforceItemEvent extends PlayerEvent {

    private final ItemStack itemStack;

    public PlayerReinforceItemEvent(ServerPlayer player, ItemStack itemStack) {
        super(player);
        this.itemStack = itemStack;
    }

    @Override
    public ServerPlayer getPlayer() {
        return (ServerPlayer) super.getPlayer();
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Cancelable
    public static class Pre extends PlayerReinforceItemEvent {

        public Pre(ServerPlayer player, ItemStack itemStack) {
            super(player, itemStack);
        }

    }

    public static class Post extends PlayerReinforceItemEvent {

        private final ItemStack reinforcedItemStack;

        public Post(ServerPlayer player, ItemStack itemStack, ItemStack reinforcedItemStack) {
            super(player, itemStack);
            this.reinforcedItemStack = reinforcedItemStack;
        }

        public ItemStack getReinforcedItemStack() {
            return reinforcedItemStack;
        }

    }

}
