package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.List;
import java.util.function.Consumer;
import org.auioc.mcmod.arnicalib.api.game.item.HArmorMaterial;
import org.auioc.mcmod.arnicalib.utils.game.EffectUtils;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.client.render.armor.MaidOutfitArmorRender;
import com.haruhifanclub.haruhiism.common.config.CommonConfig;
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

public class MikurusMaidOutfitItem extends HMArmorItem implements IHMBlessedItem {

    private static final int effectRange = CommonConfig.MikurusMaidOutfitEffectRange.get();
    private static final boolean forOtherPlayers = CommonConfig.MikurusMaidOutfitForOtherPlayers.get();
    private static final boolean forFriendlyEntities = CommonConfig.MikurusMaidOutfitForFriendlyEntities.get();

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

        AABB aabb = (new AABB(player.blockPosition())).inflate(effectRange).expandTowards(0.0D, effectRange, 0.0D);
        List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class, aabb);
        for (var entity2 : list) {
            if (entity2.equals(player)) continue;

            if (entity2 instanceof Player) {
                if (forOtherPlayers) {
                    addEffect(entity2, 0);
                }
            } else if ((forFriendlyEntities) && (entity2.getType().getCategory().isFriendly())) {
                addEffect(entity2, 0);
            }
        }
    }

    private static void addEffect(LivingEntity living, int amplifier) {
        if (EffectUtils.getEffectLevel(living, MobEffects.REGENERATION) == 0) {
            living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, amplifier, true, true));
        }
    }

    public static boolean isEquipped(Player player) {
        return player.getItemBySlot(EquipmentSlot.CHEST).is(HMItems.MIKURUS_MAID_OUTFIT_ITEM.get());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(MaidOutfitArmorRender.INSTANCE);
    }

}
