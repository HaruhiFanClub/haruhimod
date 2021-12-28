package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.regex.Pattern;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class ReinforcementStoneItem extends Item implements IReinforcementStoneItem {

    private static final int luckMultiplier = CommonConfig.CommonReinforcingLuckEffectMultiplier.get();
    private static final int unluckMultiplier = CommonConfig.CommonReinforcingUnluckEffectMultiplier.get();
    private static final int danchouConeMultiplier = CommonConfig.CommonReinforcingDanchouConeMultiplier.get();

    private static final Pattern vanillaEnchId = Pattern.compile("^minecraft:\\w+$");

    public ReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(16)
        );
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack, Player player) {
        ListTag enchantments = stack.getEnchantmentTags();

        int enchCount = enchantments.size();
        int vanillaEnchCount = 0;

        int highestIndex = 0;
        int highestLevel = 0;
        boolean overlimit = false;

        for (int i = 0; i < enchCount; i++) {
            short lvl = enchantments.getCompound(i).getShort("lvl");
            String id = enchantments.getCompound(i).getString("id");

            if (!overlimit) {
                if (lvl > (EnchUtils.getEnchantment(id)).getMaxLevel()) {
                    overlimit = true;
                }
            }

            if (lvl > highestLevel) {
                highestIndex = i;
                highestLevel = lvl;
            }

            if (vanillaEnchId.matcher(id).matches()) {
                vanillaEnchCount++;
            }
        }

        if (!overlimit) {
            EnchUtils.enchantAll(enchantments);
        } else {
            int X = highestLevel;
            int N = vanillaEnchCount;

            MobEffectInstance luckEffect = player.getEffect(MobEffects.LUCK);
            if (luckEffect != null) {
                N += (luckEffect.getAmplifier() + 1) * luckMultiplier;
            }

            MobEffectInstance unluckEffect = player.getEffect(MobEffects.UNLUCK);
            if (unluckEffect != null) {
                N += (-1) * (unluckEffect.getAmplifier() + 1) * unluckMultiplier;
            }

            if ((player.getItemBySlot(EquipmentSlot.HEAD).getItem()).equals(ItemRegistry.DANCHOU_CONE_BLOCK.get())) {
                N += 1 * danchouConeMultiplier;
            }

            if (N >= X) {
                if (Math.random() < (1.0 / X)) {
                    // all+1
                    EnchUtils.enchantAll(enchantments);
                } else {
                    // max+1
                    EnchUtils.enchantOne(enchantments, highestIndex);
                }
            } else if (N < X) {
                if (Math.random() < (1.0 / X)) {
                    // all+1
                    EnchUtils.enchantAll(enchantments);
                } else if (Math.random() < (N / X)) {
                    // max+1
                    EnchUtils.enchantOne(enchantments, highestIndex);
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

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return reinforce(context, false);
    }

}
