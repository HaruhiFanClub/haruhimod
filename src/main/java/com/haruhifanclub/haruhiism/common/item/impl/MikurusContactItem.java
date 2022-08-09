package com.haruhifanclub.haruhiism.common.item.impl;

import org.auioc.mcmod.arnicalib.utils.game.EntityUtils;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.common.damagesource.MikuruBeamDamageSource;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class MikurusContactItem extends Item implements IHMBlessedItem, ICurioItem {

    public MikurusContactItem() {
        super(
            new Item.Properties()
                .tab(HMCreativeModeTabs.TAB_MAIN)
                .stacksTo(1)
        );
    }

    public static int getCooldown() {
        return Config.laserCooldown.get() * 20;
    }

    public static boolean isEquipped(Player player) {
        return CuriosApi.getCuriosHelper().findCurios(player, HMItems.MIKURUS_CONTACT_ITEM.get()).size() > 0;
    }

    /* ============================================================================================================== */
    // #region MikuruBeam

    public static boolean canEmitMikuruBeam(Player player) {
        if (isEquipped(player) && MikurusMaidOutfitItem.isEquipped(player)) {
            return true;
        }
        return false;
    }

    public static int emitMikuruBeam(Player player) {
        return EntityUtils.rayHitLivingEntityOrBlock(
            player, Config.laserLength.get(),
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

    // #endregion MikuruBeam

    /* ============================================================================================================== */
    // #region Curios

    @Override
    public void curioTick(SlotContext slotCtx, ItemStack stack) {
        if (slotCtx.entity() instanceof Player player) {
            if (player.hasEffect(MobEffects.BLINDNESS)) {
                player.removeEffect(MobEffects.BLINDNESS);
            }

            if (MikurusMaidOutfitItem.isEquipped(player)) {
                player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 4, 0, true, true));
            }
        }
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    // #endregion Curios

    /* ============================================================================================================== */
    // #region Config

    public static class Config {

        public static DoubleValue laserLength;
        public static IntValue laserCooldown;

        public static void build(final ForgeConfigSpec.Builder b) {
            laserLength = b.defineInRange("laser_length", 27.0D, 0.0D, Double.MAX_VALUE);
            laserCooldown = b.defineInRange("laser_cooldown", 1, 0, Integer.MAX_VALUE);
        }

    }

    // #endregion Config

}
