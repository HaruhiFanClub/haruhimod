package com.haruhifanclub.haruhimod.haruhicore.common.item.impl;

import org.auioc.mcmod.arnicalib.utils.game.EffectUtils;
import org.auioc.mcmod.arnicalib.utils.game.EnchUtils;
import org.auioc.mcmod.arnicalib.utils.game.VanillaPredicates;
import com.haruhifanclub.haruhimod.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.haruhimod.haruhicore.common.item.base.HCReinforcementStoneItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ReinforcementStoneItem extends HCReinforcementStoneItem {

    public ReinforcementStoneItem() {
        super(Rarity.COMMON);
    }

    @Override
    protected boolean isEnabled() {
        return CommonConfig.EnableCommonReinforcementStone.get();
    }

    @Override
    protected boolean isEpic() {
        return false;
    }

    @Override
    protected int getExperienceCost() {
        return CommonConfig.CommonReinforcingExperienceCost.get();
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


            N += EffectUtils.getEffectLevel(player, MobEffects.LUCK) * CommonConfig.CommonReinforcingLuckEffectMultiplier.get();

            N += (-1) * EffectUtils.getEffectLevel(player, MobEffects.UNLUCK) * CommonConfig.CommonReinforcingUnluckEffectMultiplier.get();

            if (DanchouConeBlockItem.isEquipped(player)) {
                N += 1 * CommonConfig.CommonReinforcingDanchouConeMultiplier.get();
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
