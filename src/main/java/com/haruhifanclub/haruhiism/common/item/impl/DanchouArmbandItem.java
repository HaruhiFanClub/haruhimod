package com.haruhifanclub.haruhiism.common.item.impl;

import org.auioc.mcmod.arnicalib.game.effect.MobEffectUtils;
import org.auioc.mcmod.arnicalib.game.enchantment.EnchUtils;
import org.auioc.mcmod.arnicalib.game.registry.VanillaPredicates;
import com.haruhifanclub.haruhiism.common.item.base.HMReinforcementStoneItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

@SuppressWarnings("removal")
public class DanchouArmbandItem extends HMReinforcementStoneItem {

    public DanchouArmbandItem() {
        super(false);
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
    protected ItemStack processEnchantment(ItemStack stack, Player player) {
        ListTag enchantments = stack.getEnchantmentTags();

        if (!EnchUtils.isOverLimit(enchantments)) {
            EnchUtils.enchantAll(enchantments, 1);
        } else {
            CompoundTag highestEnchantment = EnchUtils.getHighestEnchantment(enchantments);
            int X = (int) highestEnchantment.getShort("lvl");

            int N = 0; // Vanilla enchantments count
            for (int i = 0, l = enchantments.size(); i < l; i++) {
                if (VanillaPredicates.STRING_ID.test(enchantments.getCompound(i).getString("id"))) {
                    N++;
                }
            }


            N += MobEffectUtils.getLevel(player, MobEffects.LUCK) * Config.luckEffectMultiplier.get();

            N += (-1) * MobEffectUtils.getLevel(player, MobEffects.UNLUCK) * Config.unluckEffectMultiplier.get();

            if (DanchouConeBlockItem.isEquipped(player)) {
                N += 1 * Config.danchouConeMultiplier.get();
            }


            if (N >= X) {
                if (Math.random() < (1.0 / X)) {
                    // all+1
                    EnchUtils.enchantAll(enchantments, 1);
                } else {
                    // max+1
                    EnchUtils.enchantOne(highestEnchantment, 1);
                }
            } else if (N < X) {
                if (Math.random() < (1.0 / X)) {
                    // all+1
                    EnchUtils.enchantAll(enchantments, 1);
                } else if (Math.random() < (N / X)) {
                    // max+1
                    EnchUtils.enchantOne(highestEnchantment, 1);
                } else {
                    // break
                    return ItemStack.EMPTY;
                }
            }
        }

        stack.getTag().remove("Enchantments");
        stack.getTag().put("Enchantments", enchantments);

        return stack;
    }


    public static class Config {
        public static BooleanValue enable;
        public static IntValue experienceCost;
        public static IntValue luckEffectMultiplier;
        public static IntValue unluckEffectMultiplier;
        public static IntValue danchouConeMultiplier;

        public static void build(final ForgeConfigSpec.Builder b) {
            enable = b.define("enable", true);
            experienceCost = b.defineInRange("experience_cost", 256, 0, Integer.MAX_VALUE);
            luckEffectMultiplier = b.defineInRange("luck_effect_multiplier", 1, 0, Integer.MAX_VALUE);
            unluckEffectMultiplier = b.defineInRange("unluck_effect_multiplier", 1, 0, Integer.MAX_VALUE);
            danchouConeMultiplier = b.defineInRange("danchou_cone_multiplier", 2, 0, Integer.MAX_VALUE);
        }
    }

}
