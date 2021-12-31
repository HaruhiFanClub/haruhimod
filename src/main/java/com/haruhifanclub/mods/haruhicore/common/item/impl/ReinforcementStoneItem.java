package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.regex.Pattern;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCReinforcementStoneItem;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ReinforcementStoneItem extends HCReinforcementStoneItem {

    private static final boolean enabled = CommonConfig.EnableCommonReinforcementStone.get();
    private static final int experienceCost = CommonConfig.CommonReinforcingExperienceCost.get();
    private static final int luckMultiplier = CommonConfig.CommonReinforcingLuckEffectMultiplier.get();
    private static final int unluckMultiplier = CommonConfig.CommonReinforcingUnluckEffectMultiplier.get();
    private static final int danchouConeMultiplier = CommonConfig.CommonReinforcingDanchouConeMultiplier.get();

    private static final Pattern vanillaEnchId = Pattern.compile("^minecraft:\\w+$");

    public ReinforcementStoneItem() {
        super(Rarity.COMMON);
    }

    @Override
    protected boolean isEnabled() {
        return enabled;
    }

    @Override
    protected int getExperienceCost() {
        return experienceCost;
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack, Player player) {
        ListTag enchantments = stack.getEnchantmentTags();

        if (!EnchUtils.isOverLimit(enchantments)) {
            EnchUtils.enchantAll(enchantments, 1);
        } else {
            CompoundTag highestEnchantment = EnchUtils.getHighestEnchantment(enchantments);
            int X = (int) highestEnchantment.getShort("lvl");

            int N = 0; // Vanilla enchantments count
            for (int i = 0, l = enchantments.size(); i < l; i++) {
                if (vanillaEnchId.matcher(enchantments.getCompound(i).getString("id")).matches()) {
                    N++;
                }
            }


            N += EffectUtils.getEffectLevel(player, MobEffects.LUCK) * luckMultiplier;

            N += (-1) * EffectUtils.getEffectLevel(player, MobEffects.UNLUCK) * unluckMultiplier;

            if (DanchouConeBlockItem.isEquipped(player)) {
                N += 1 * danchouConeMultiplier;
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

}
