package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.item.ItemManager;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCArmorItem;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class MikurusMaidOutfitItem extends HCArmorItem {

    public MikurusMaidOutfitItem() {
        super(
            new HArmorMaterial("mikurus_maid_outfit")
                .setDurability(1096)
                .setDefense(8)
                .setToughness(2)
                .setEnchantmentValue(15)
                .setRepairIngredient(() -> {
                    return Ingredient.of(ItemManager.REINFORCEMENT_STONE_ITEM.get());
                }),
            EquipmentSlotType.CHEST,
            null
        );
    }

    // TODO Custom armor model

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int index, boolean selected) {
        if (world.isClientSide) {
            return;
        }

        PlayerEntity player = ((PlayerEntity) entity);

        ItemStack headItemStack = player.getItemBySlot(EquipmentSlotType.CHEST);
        if (!(headItemStack.getItem()).equals(this)) {
            return;
        }

        EffectUtils.addEffect(player, 10, 4, 1); // regeneration

        int effectRange = CommonConfig.MikurusMaidOutfitEffectRange.get();

        AxisAlignedBB aabb = (new AxisAlignedBB(player.blockPosition())).inflate(effectRange).expandTowards(0.0D, effectRange, 0.0D);

        List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity entity2 : list) {
            if (entity2.equals(player)) {
                continue;
            }

            if (entity2 instanceof PlayerEntity) {
                if (CommonConfig.MikurusMaidOutfitForOtherPlayers.get()) {
                    EffectUtils.addEffect(entity2, 10, 4, 1);
                }
            } else if ((CommonConfig.MikurusMaidOutfitForFriendlyEntities.get()) && (entity2.getType().getCategory().isFriendly())) {
                EffectUtils.addEffect(entity2, 10, 4, 1);
            }
        }
    }

}
