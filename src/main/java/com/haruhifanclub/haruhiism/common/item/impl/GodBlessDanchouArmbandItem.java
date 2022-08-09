package com.haruhifanclub.haruhiism.common.item.impl;

import org.apache.commons.lang3.RandomUtils;
import org.auioc.mcmod.arnicalib.utils.game.EffectUtils;
import org.auioc.mcmod.arnicalib.utils.game.EnchUtils;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.common.item.base.HMReinforcementStoneItem;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class GodBlessDanchouArmbandItem extends HMReinforcementStoneItem implements IHMBlessedItem {

    public GodBlessDanchouArmbandItem() {
        super(true);
    }

    @Override
    protected boolean isEnabled() {
        return Config.enable.get();
    }

    @Override
    protected int getExperienceCost() {
        return Config.experienceCost.get();
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack, Player player) {
        float A = 33.0F, B = 66.0F, C = 99.0F;

        int unluckLevel = EffectUtils.getEffectLevel(player, MobEffects.UNLUCK);
        if (unluckLevel > 0) {
            A -= 0.6 * unluckLevel;
            B -= 0.6 * unluckLevel;
            C -= 0.6 * unluckLevel;
        } else {
            int luckLevel = EffectUtils.getEffectLevel(player, MobEffects.LUCK);
            A -= 0.6 * luckLevel;
            B -= 0.6 * luckLevel;
            C -= 0.6 * luckLevel;

            if (DanchouConeBlockItem.isEquipped(player)) {
                float n = 100 - C;
                A -= n;
                B -= n;
                C -= n;
            }
        }

        ListTag enchantments = stack.getEnchantmentTags();

        float P = (float) RandomUtils.nextInt(1, 101);
        if (P <= A) {
            EnchUtils.enchantAll(enchantments, 1);
        } else if (P > A && P <= B) {
            EnchUtils.enchantRandom(enchantments, 1);
        } else if (P > B && P <= C) {
            EnchUtils.enchantOne(EnchUtils.getHighestEnchantment(enchantments), 1);
        } else {
            if (unluckLevel > 0) {
                return ItemStack.EMPTY;
            }
            EnchUtils.enchantAll(enchantments, 3);
        }

        stack.getTag().remove("Enchantments");
        stack.getTag().put("Enchantments", enchantments);

        return stack;
    }


    public static class Config {
        public static BooleanValue enable;
        public static IntValue experienceCost;

        public static void build(final ForgeConfigSpec.Builder b) {
            enable = b.define("enable", true);
            experienceCost = b.defineInRange("experience_cost", 512, 0, Integer.MAX_VALUE);
        }
    }

}
