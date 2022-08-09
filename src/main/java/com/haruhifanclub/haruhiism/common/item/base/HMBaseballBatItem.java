package com.haruhifanclub.haruhiism.common.item.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.haruhifanclub.haruhiism.api.item.IHMItem;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class HMBaseballBatItem extends SwordItem implements IHMItem {

    public HMBaseballBatItem(Tier tier, int basicAttackDamage, float attackSpeed) {
        super(tier, basicAttackDamage - 1, attackSpeed - 4.0F, new Item.Properties().tab(HMCreativeModeTabs.TAB_MAIN));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack itemStack, Enchantment enchantment) {
        if ((Config.compatibleEnchantments.get()).contains(enchantment.getRegistryName().toString())) {
            return true;
        }
        return false;
    }


    public static class Config {
        public static ConfigValue<List<? extends String>> compatibleEnchantments;

        public static void build(final ForgeConfigSpec.Builder b) {
            compatibleEnchantments = b.define(
                "compatible_enchantments", new ArrayList<String>(
                    Arrays.asList(
                        "minecraft:knockback",
                        "minecraft:unbreaking",
                        "minecraft:mending",
                        "minecraft:vanishing_curse"
                    )
                )
            );
        }
    }

}
