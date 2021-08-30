package org.auioc.mods.ahutils.utils.game;

import java.util.function.Supplier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HArmorMaterial implements IArmorMaterial {

    private final String name;
    private int durability = 1;
    private int defense = 1;
    private int enchantmentValue = 1;
    private float toughness = 0.0F;
    private float knockbackResistance = 0.0F;
    private SoundEvent sound = null;
    private LazyValue<Ingredient> repairIngredient = new LazyValue<>(null);

    public HArmorMaterial(String name) {
        this.name = name;
    }


    public HArmorMaterial setDurability(int durability) {
        this.durability = durability;
        return this;
    }

    public HArmorMaterial setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public HArmorMaterial setEnchantmentValue(int enchantmentValue) {
        this.enchantmentValue = enchantmentValue;
        return this;
    }

    public HArmorMaterial setToughness(float toughness) {
        this.toughness = toughness;
        return this;
    }

    public HArmorMaterial setKnockbackResistance(float knockbackResistance) {
        this.knockbackResistance = knockbackResistance;
        return this;
    }

    public HArmorMaterial setEquipSound(SoundEvent sound) {
        this.sound = sound;
        return this;
    }

    public HArmorMaterial setRepairIngredient(Supplier<Ingredient> repairIngredient) {
        this.repairIngredient = new LazyValue<>(repairIngredient);
        return this;
    }



    @Override
    public int getDurabilityForSlot(EquipmentSlotType slotType) {
        return this.durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slotType) {
        return this.defense;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
