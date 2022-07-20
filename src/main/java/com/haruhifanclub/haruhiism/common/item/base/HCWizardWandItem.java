package com.haruhifanclub.haruhiism.common.item.base;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.haruhifanclub.haruhiism.api.item.IHCItem;
import com.haruhifanclub.haruhiism.common.itemgroup.HCCreativeModeTabs;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class HCWizardWandItem extends Item implements IHCItem {

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public HCWizardWandItem() {
        super(
            new Item.Properties()
                .tab(HCCreativeModeTabs.TAB_MAIN)
                .stacksTo(1)
        );
        ImmutableMultimap.Builder<Attribute, AttributeModifier> modifiers = ImmutableMultimap.builder();
        modifiers.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", 0.618D - 4.0D, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = modifiers.build();
    }

    @Override
    @SuppressWarnings("deprecation")
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack wand, Player player, Entity entity) {
        if (player.getCooldowns().isOnCooldown(this)) return true;

        float damage = getBaseAttackDamage(player, wand);
        float scale = player.getAttackStrengthScale(0.5F);
        damage *= 0.2F + scale * scale * 0.8F;

        entity.hurt(DamageSource.indirectMagic(entity, player), damage);
        return true;
    }

    protected abstract float getBaseAttackDamage(Player player, ItemStack wand);

}
