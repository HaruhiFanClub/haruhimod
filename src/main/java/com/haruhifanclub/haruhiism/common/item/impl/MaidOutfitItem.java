package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.List;
import java.util.function.Consumer;
import org.auioc.mcmod.arnicalib.api.game.item.HArmorMaterial;
import org.auioc.mcmod.arnicalib.utils.game.EffectUtils;
import org.auioc.mcmod.arnicalib.utils.game.EntityUtils;
import com.haruhifanclub.haruhiism.client.renderer.armor.MaidOutfitArmorRenderer;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.item.base.HMArmorItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class MaidOutfitItem extends HMArmorItem {

    public MaidOutfitItem() {
        super(
            new HArmorMaterial("maid_outfit")
                .setDurability(1096)
                .setDefense(3)
                .setEnchantmentValue(15)
                .setRepairIngredient(() -> {
                    return Ingredient.of(HMItems.DANCHOU_ARMBAND_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    public static void applyEffect(ServerPlayer player) {
        if (!isEquipped(player)) return;

        int effectLevel = EffectUtils.getEffectLevel(player, MobEffects.REGENERATION);
        if (effectLevel == 0) {
            var aabb = (new AABB(player.blockPosition())).inflate(5.0D);
            List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class, aabb);
            for (var living : list) {
                if (living instanceof Player || (EntityUtils.IS_FRIENDLY.test(living))) {
                    living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100));
                }
            }
        } else if (effectLevel == 1) {
            player.removeEffect(MobEffects.REGENERATION);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100));
        }
    }

    public static boolean isEquipped(Player player) {
        return player.getItemBySlot(EquipmentSlot.CHEST).is(HMItems.MAID_OUTFIT_ITEM.get());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(MaidOutfitArmorRenderer.INSTANCE);
    }

}
