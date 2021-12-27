package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.api.item.HArmorMaterial;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class MikurusMaidOutfitItem extends HCArmorItem implements IHCBlessedItem {

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
                    return Ingredient.of(ItemRegistry.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlot.CHEST
        );
    }

    // TODO Custom armor model

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int index, boolean selected) {
        if (world.isClientSide) {
            return;
        }

        Player player = ((Player) entity);

        ItemStack headItemStack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(headItemStack.getItem()).equals(this)) {
            return;
        }

        EffectUtils.addEffect(player, 10, 4, 1); // regeneration

        AABB aabb = (new AABB(player.blockPosition())).inflate(effectRange).expandTowards(0.0D, effectRange, 0.0D);

        List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity entity2 : list) {
            if (entity2.equals(player)) {
                continue;
            }

            if (entity2 instanceof Player) {
                if (forOtherPlayers) {
                    EffectUtils.addEffect(entity2, 10, 4, 1);
                }
            } else if ((forFriendlyEntities) && (entity2.getType().getCategory().isFriendly())) {
                EffectUtils.addEffect(entity2, 10, 4, 1);
            }
        }
    }

    public static boolean isEquipped(Player player) {
        return (player.getItemBySlot(EquipmentSlot.CHEST).getItem()).equals(ItemRegistry.MIKURUS_MAID_OUTFIT_ITEM.get());
    }

}
