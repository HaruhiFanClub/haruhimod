package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.List;
import java.util.function.Consumer;
import org.auioc.mcmod.arnicalib.game.effect.MobEffectUtils;
import org.auioc.mcmod.hulsealib.game.item.HArmorMaterial;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.client.renderer.armor.MaidOutfitArmorRenderer;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class MikurusMaidOutfitItem extends HMArmorItem implements IHMBlessedItem {

    public MikurusMaidOutfitItem() {
        super(
            new HArmorMaterial("mikurus_maid_outfit")
                .setDurability(1096)
                .setDefense(8)
                .setToughness(2)
                .setEnchantmentValue(15)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HMItems.DANCHOU_ARMBAND_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int index, boolean selected) {
        if (world.isClientSide) return;

        Player player = ((Player) entity);

        if (!isEquipped(player)) return;

        addEffect(player, MikurusContactItem.isEquipped(player) ? 1 : 0);

        final int range = Config.effectRange.get();
        AABB aabb = (new AABB(player.blockPosition())).inflate(range).expandTowards(0.0D, range, 0.0D);
        List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class, aabb);
        for (var entity2 : list) {
            if (entity2.equals(player)) continue;

            if (entity2 instanceof Player) {
                if (Config.forOtherPlayers.get()) {
                    addEffect(entity2, 0);
                }
            } else if ((Config.forFriendlyEntities.get()) && (entity2.getType().getCategory().isFriendly())) {
                addEffect(entity2, 0);
            }
        }
    }

    private static void addEffect(LivingEntity living, int amplifier) {
        if (MobEffectUtils.getLevel(living, MobEffects.REGENERATION) == 0) {
            living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, amplifier, true, true));
        }
    }

    public static boolean isEquipped(Player player) {
        return player.getItemBySlot(EquipmentSlot.CHEST).is(HMItems.MIKURUS_MAID_OUTFIT_ITEM.get());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(MaidOutfitArmorRenderer.INSTANCE);
    }


    public static class Config {
        public static IntValue effectRange;
        public static BooleanValue forOtherPlayers;
        public static BooleanValue forFriendlyEntities;

        public static void build(final ForgeConfigSpec.Builder b) {
            effectRange = b.defineInRange("effect_range", 10, 1, 64);
            forOtherPlayers = b.define("effective_for_other_players", true);
            forFriendlyEntities = b.define("effective_for_friendly_entities", true);
        }
    }

}
