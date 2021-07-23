package com.haruhifanclub.mods.haruhicore.common.item.impl;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import com.haruhifanclub.mods.haruhicore.common.block.BlockManager;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import org.auioc.mods.utils.EffectUtils;

public class DanchouConeBlockItem extends BlockItem {
    public DanchouConeBlockItem() {
        super(
            BlockManager.DANCHOU_CONE_BLOCK.get(),
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
        );
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        if (world.isClientSide) {
            return;
        }

        if (!(entity instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity player = ((PlayerEntity) entity);

        ItemStack headItemStack = player.inventory.armor.get(3);
        if ((headItemStack.getItem()).equals(this)) {
            EffectUtils.addEffect(player, 11, 4, 0); // resistance
            EffectUtils.addEffect(player, 23, 4, 0); // saturation
            EffectUtils.addEffect(player, 24, 4, 0); // glowing
            EffectUtils.addEffect(player, 26, 4, 0); // luck
        }


    }

}
