package com.haruhifanclub.mods.haruhicore.common.item.impl;

import java.util.Collection;
import com.haruhifanclub.mods.haruhicore.common.item.base.HCHourglassItem;
import org.auioc.mods.ahutils.utils.game.MCTimeUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TpddItem extends HCHourglassItem {

    public TpddItem() {}

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 16;
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getCount() != 1) {
            return ActionResult.fail(ItemStack.EMPTY);
        }

        if (player.isSteppingCarefully()) {
            return write(level, player, itemStack);
        } else {
            return read(level, player, itemStack);
        }
    }

    private ActionResult<ItemStack> write(World level, PlayerEntity player, ItemStack itemStack) {
        { // Cooldown
            CooldownTracker cooldownTracker = player.getCooldowns();
            if (cooldownTracker.isOnCooldown(this)) {
                return ActionResult.pass(itemStack);
            }
            cooldownTracker.addCooldown(this, 40);
        }

        { // Process NBT
            if (itemStack.hasTag() && itemStack.getTag().contains("tpdd")) {
                itemStack.removeTagKey("tpdd");
            }

            { // Write NBT
                CompoundNBT nbt = new CompoundNBT();

                nbt.put("player", NBTUtil.createUUID(player.getUUID()));

                { // Status
                    nbt.putFloat("health", player.getHealth());
                    nbt.putInt("food", player.getFoodData().getFoodLevel());
                    nbt.putFloat("saturation", player.getFoodData().getSaturationLevel());
                }

                { // Effects
                    ListNBT effects_nbt = new ListNBT();

                    Collection<EffectInstance> effects = player.getActiveEffects();
                    for (EffectInstance effect : effects) {
                        CompoundNBT effect_nbt = new CompoundNBT();
                        effect_nbt.putString("id", effect.getEffect().getRegistryName().toString());
                        effect_nbt.putInt("amplifier", effect.getAmplifier());
                        effect_nbt.putInt("duration", effect.getDuration());
                        effects_nbt.add(effect_nbt);
                    }

                    nbt.put("effects", effects_nbt);
                }

                { // Time
                    long[] time = MCTimeUtils.getTime(level);

                    CompoundNBT time_nbt = new CompoundNBT();
                    time_nbt.putLong("day", time[0]);
                    time_nbt.putLong("game", time[1]);
                    time_nbt.putLong("real", time[2]);

                    nbt.put("time", time_nbt);
                }

                itemStack.addTagElement("tpdd", nbt);
            }
        }

        if (!level.isClientSide()) {
            super.broadcastTime(level, player);
        }

        return ActionResult.sidedSuccess(itemStack, level.isClientSide());
    }

    private ActionResult<ItemStack> read(World level, PlayerEntity player, ItemStack itemStack) {
        return ActionResult.pass(itemStack);
    }

}
