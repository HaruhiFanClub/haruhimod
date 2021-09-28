package com.haruhifanclub.mods.haruhicore.common.item.impl;

import com.haruhifanclub.mods.haruhicore.api.item.IHCBlessedItem;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.damagesource.MikuruBeamDamageSource;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupRegistry;
import org.auioc.mods.ahutils.utils.game.EffectUtils;
import org.auioc.mods.ahutils.utils.game.EntityUtils;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MikurusContactItem extends Item implements IHCBlessedItem {

    private static final EquipmentSlotType equipmentSlotType = EquipmentSlotType.HEAD;
    private static final double rayLength = CommonConfig.MikurusContactLaserLength.get();
    private static final int cooldown = CommonConfig.MikurusContactLaserCooldown.get() * 20;

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

        if (MikurusMaidOutfitItem.isEquipped(player)) {
            EffectUtils.addEffect(player, 32, 4, 0); // hero_of_the_village
        }
    }

    public static int emitMikuruBeam(PlayerEntity player) {
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
                World world = player.level;
                BlockPos targetBlockPos = b.getBlockPos().relative(b.getDirection());
                if (AbstractFireBlock.canBePlacedAt(world, targetBlockPos, player.getDirection())) {
                    world.setBlock(targetBlockPos, AbstractFireBlock.getState(world, targetBlockPos), 11);
                    return 1;
                }
                return 0;
            }
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static void renderMikuruBeam() {}

    public static boolean isEquipped(PlayerEntity player) {
        return (player.getItemBySlot(EquipmentSlotType.HEAD).getItem()).equals(ItemRegistry.MIKURUS_CONTACT_ITEM.get());
    }

    public static boolean canEmitMikuruBeam(PlayerEntity player) {
        if (isEquipped(player) && MikurusMaidOutfitItem.isEquipped(player)) {
            return true;
        }
        return false;
    }

    public static int getCooldown() {
        return cooldown;
    }

}
