package org.auioc.mods.ahutils.utils.game;

import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public interface EnchUtils {
    static Enchantment getEnchantment(String id) {
        return ForgeRegistries.ENCHANTMENTS.getValue(new ResourceLocation(id));
    }

    static void enchantAll(ListNBT enchantments) {
        for (int i = 0; i < enchantments.size(); i++) {
            CompoundNBT nbt = enchantments.getCompound(i);
            nbt.putShort("lvl", (short) (nbt.getShort("lvl") + 1));
        }
    }

    static void enchantOne(ListNBT enchantments, int index) {
        CompoundNBT nbt = enchantments.getCompound(index);
        nbt.putShort("lvl", (short) (nbt.getShort("lvl") + 1));
    }

    static void enchantRandom(ListNBT enchantments) {
        int enchCount = enchantments.size();
        int index = (new Random()).nextInt((enchCount - 0) + 1) + 0;
        CompoundNBT nbt = enchantments.getCompound(index);
        nbt.putShort("lvl", (short) (nbt.getShort("lvl") + 1));
    }
}
