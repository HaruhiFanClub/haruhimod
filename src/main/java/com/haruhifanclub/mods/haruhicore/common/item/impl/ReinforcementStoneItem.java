package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResultType;

public class ReinforcementStoneItem extends Item implements IReinforcementStoneItem {

    private static final int luckMultiplier = CommonConfig.CommonReinforcingLuckEffectMultiplier.get();
    private static final int danchouConeMultiplier = CommonConfig.CommonReinforcingDanchouConeMultiplier.get();

    public ReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(16)
        );
    }

    @Override
    public ItemStack processEnchantment(ItemStack stack, PlayerEntity player) {
        ListNBT enchantments = stack.getEnchantmentTags();

        int enchCount = enchantments.size();

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
        }

        if (!overlimit) {
            EnchUtils.enchantAll(enchantments);
        } else {
            int X = highestLevel;
            int N = enchCount;

            EffectInstance luckEffect = player.getEffect(EffectUtils.getEffect(26));
            if (luckEffect != null) {
                N += (luckEffect.getAmplifier() + 1) * luckMultiplier;
            }

            if ((player.getItemBySlot(EquipmentSlotType.HEAD).getItem()).equals(ItemRegistry.DANCHOU_CONE_BLOCK.get())) {
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
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        return reinforce(context, false);
    }
}
