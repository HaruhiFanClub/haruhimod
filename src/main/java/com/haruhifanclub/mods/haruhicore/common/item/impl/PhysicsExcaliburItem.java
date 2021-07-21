package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class PhysicsExcaliburItem extends Item {

    public PhysicsExcaliburItem() {
        super(
            new Item.Properties()
                .rarity(Rarity.EPIC)
                .fireResistant()
                .stacksTo(1) // maxStackSize
        );
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    // return True to cancel the rest of the interaction.
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (!CommonConfig.EnablePhysicsExcalibur.get()) {
            return false;
        }

        if (player.level.isClientSide) {
            return true;
        }

        if (player.isSteppingCarefully()) {
            target.kill();
            return true;
        }

        ITextComponent text = (ITextComponent) new StringTextComponent("")
            .append(new TranslationTextComponent(getKey("attack", 1)))
            .append(
                attackedEntityInfoText(2, target.getName().getString())
            )
            .append(
                attackedEntityInfoText(3, target.getType().toString())
            )
            .append(
                attackedEntityInfoText(4, target.getStringUUID())
            )
            .append(
                attackedEntityInfoText(
                    5,
                    String.format(
                        "(%f,%f,%f) @ %s", target.getX(), target.getY(), target.getZ(),
                        target.level.dimension().location().toString()
                    )
                )
            );
        player.sendMessage(text, player.getUUID());

        return true;
    }


    private static String getKey(String type, int number) {
        return String.format("haruhicore.physics_excalibur.%s.%d", type, number);
    }

    private static ITextComponent attackedEntityInfoText(int keyNumber, String info) {
        return new TranslationTextComponent(getKey("attack", keyNumber))
            .append(new StringTextComponent(info));
    }
}
