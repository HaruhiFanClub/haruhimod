package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.base.IBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MikurusContactItem extends Item implements IBlessedItem {

    public static final EquipmentSlotType equipmentSlotType = EquipmentSlotType.HEAD;

    public MikurusContactItem() {
        super(
            new Item.Properties()
                .tab(ItemGroupRegistry.itemGroup)
                .stacksTo(1)
        );
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        ItemStack headItemStack = player.getItemBySlot(equipmentSlotType);
        if (headItemStack.isEmpty()) {
            player.setItemSlot(equipmentSlotType, itemStack.copy());
            itemStack.setCount(0);
            return ActionResult.sidedSuccess(itemStack, world.isClientSide());
        } else {
            return ActionResult.fail(itemStack);
        }
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EquipmentSlotType armorType, Entity entity) {
        if (armorType.compareTo(equipmentSlotType) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (player.hasEffect(Effects.BLINDNESS)) {
            player.removeEffect(Effects.BLINDNESS);
        }

        if (isMaidOutfitEquipped(player)) {
            EffectUtils.addEffect(player, 32, 4, 0); // hero_of_the_village
        }
    }

    private static boolean isMaidOutfitEquipped(PlayerEntity player) {
        return (player.getItemBySlot(EquipmentSlotType.CHEST).getItem()).equals(ItemRegistry.MIKURUS_MAID_OUTFIT_ITEM.get());
    }

}
