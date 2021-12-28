package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.regex.Pattern;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.nbt.CompoundTag;
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

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return reinforce(context, false);
    }

}
