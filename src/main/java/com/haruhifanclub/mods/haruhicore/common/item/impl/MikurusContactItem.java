package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.damagesource.MikuruBeamDamageSource;
import com.haruhifanclub.mods.haruhicore.common.item.HCItems;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.HCCreativeModeTabs;
import org.auioc.mods.arnicalib.utils.game.EntityUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MikurusContactItem extends Item implements IHCBlessedItem {

    private static final EquipmentSlot equipmentSlotType = EquipmentSlot.HEAD;
    private static final double rayLength = CommonConfig.MikurusContactLaserLength.get();
    private static final int cooldown = CommonConfig.MikurusContactLaserCooldown.get() * 20;

    public MikurusContactItem() {
        super(
            new Item.Properties()
                .tab(HCCreativeModeTabs.TAB_MAIN)
                .stacksTo(1)
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        ItemStack headItemStack = player.getItemBySlot(equipmentSlotType);
        if (headItemStack.isEmpty()) {
            player.setItemSlot(equipmentSlotType, itemStack.copy());
            itemStack.setCount(0);
            return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
        } else {
            return InteractionResultHolder.fail(itemStack);
        }
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EquipmentSlot armorType, Entity entity) {
        if (armorType.compareTo(equipmentSlotType) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (player.hasEffect(MobEffects.BLINDNESS)) {
            player.removeEffect(MobEffects.BLINDNESS);
        }

        if (MikurusMaidOutfitItem.isEquipped(player)) {
            player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 4, 0, true, true));
        }
    }

    public static int emitMikuruBeam(Player player) {
        return EntityUtils.rayHitLivingEntityOrBlock(
            player, rayLength,
            (e) -> {
                LivingEntity target = (LivingEntity) e.getEntity();
                if (target.hurt(MikuruBeamDamageSource.build(target, player), player.getHealth() * 0.3F)) {
                    return 1;
                }
                return 0;
            },
            (b) -> {
                Level world = player.level;
                BlockPos targetBlockPos = b.getBlockPos().relative(b.getDirection());
                if (BaseFireBlock.canBePlacedAt(world, targetBlockPos, player.getDirection())) {
                    world.setBlock(targetBlockPos, BaseFireBlock.getState(world, targetBlockPos), 11);
                    return 1;
                }
                return 0;
            }
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static void renderMikuruBeam() {}

    public static boolean isEquipped(Player player) {
        return (player.getItemBySlot(EquipmentSlot.HEAD).getItem()).equals(HCItems.MIKURUS_CONTACT_ITEM.get());
    }

    public static boolean canEmitMikuruBeam(Player player) {
        if (isEquipped(player) && MikurusMaidOutfitItem.isEquipped(player)) {
            return true;
        }
        return false;
    }

    public static int getCooldown() {
        return cooldown;
    }

}
