package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.item.base.IReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.apache.commons.lang3.RandomUtils;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.EnchUtils;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EpicReinforcementStoneItem extends Item implements IReinforcementStoneItem, IHCBlessedItem {

    public EpicReinforcementStoneItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .rarity(Rarity.EPIC)
                .stacksTo(16)
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack stack) {
        return true;
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


    @SuppressWarnings("unused")
    private static void test() {
        /*@formatter:off*/
        int X=0,Y=0,Z=0,W=0;
        float A=33.0F,B=66.0F,C=99.0F;
        {int n=10;A-=0.6*n;B-=0.6*n;C-=0.6*n;} // Luck
        {float n=100-C;A-=n;B-=n;C-=n;} // ×2
        for(int i=0;i<10000;i++){
            float P=(float) RandomUtils.nextInt(1,101);
            if(P<=A){X++;}else if(P>A&&P<=B){Y++;}else if(P>B&&P<=C){Z++;}else{W++;}
        }
        System.out.println(X+","+Y+","+Z+","+W);
        /*@formatter:on*/
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        // if (!context.getLevel().isClientSide()) {test();}
        return reinforce(context, true);
    }

}
