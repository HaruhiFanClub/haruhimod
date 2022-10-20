package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.function.Consumer;
import org.auioc.mcmod.hulsealib.game.item.HArmorMaterial;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.client.renderer.armor.WizardCloakArmorRenderer;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class YukisWizardCloakItem extends HMArmorItem implements IHMBlessedItem {

    public YukisWizardCloakItem() {
        super(
            new HArmorMaterial("yukis_wizard_cloak")
                .setDurability(708)
                .setDefense(10)
                .setToughness(4)
                .setEnchantmentValue(66)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HMItems.DANCHOU_ARMBAND_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int index, boolean selected) {
        if (world.isClientSide()) {
            return;
        }

        Player player = ((Player) entity);

        ItemStack chestItemStack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(chestItemStack.getItem()).equals(this)) {
            return;
        }

        if (!player.hasEffect(MobEffects.ABSORPTION)) {
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, (Config.effectDuration.get() * 20), 1));
        }
    }

    public static boolean isEquipped(Player player) {
        return player.getItemBySlot(EquipmentSlot.CHEST).is(HMItems.YUKIS_WIZARD_CLOAK_ITEM.get());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(WizardCloakArmorRenderer.INSTANCE);
    }


    public static class Config {
        public static IntValue effectDuration;

        public static void build(final ForgeConfigSpec.Builder b) {
            effectDuration = b.defineInRange("effect_duration", 42, 0, Integer.MAX_VALUE);
        }
    }

}
