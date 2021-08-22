package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.HArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class MikurusMaidOutfitItem extends ArmorItem {

    public MikurusMaidOutfitItem() {
        super(
            new HArmorMaterial("mikurus_maid_outfit")
                .setDurability(1096)
                .setDefense(8)
                .setToughness(2)
                .setEnchantmentValue(15),
            EquipmentSlotType.CHEST,
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
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

        AxisAlignedBB aabb = (new AxisAlignedBB(player.blockPosition())).inflate(10).expandTowards(0.0D, 10, 0.0D);
        List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity entity2 : list) {
            if (entity2.equals(player)) {
                continue;
            }
            if ((entity2 instanceof PlayerEntity) || (entity2.getType().getCategory().isFriendly())) {
                EffectUtils.addEffect(entity2, 10, 4, 1);
            }
        }
    }

}
