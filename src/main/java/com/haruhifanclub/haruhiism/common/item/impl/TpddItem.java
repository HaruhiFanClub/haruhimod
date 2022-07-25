package com.haruhifanclub.haruhiism.common.item.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.auioc.mcmod.arnicalib.utils.game.EffectUtils;
import org.auioc.mcmod.arnicalib.utils.game.MCTimeUtils;
import com.haruhifanclub.haruhiism.api.item.IHMBlessedItem;
import com.haruhifanclub.haruhiism.common.config.CommonConfig;
import com.haruhifanclub.haruhiism.common.item.base.HMHourglassItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongArrayTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TpddItem extends HMHourglassItem implements IHMBlessedItem {

    public TpddItem() {}

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return CommonConfig.TpddReadDuration.get() * 20;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.SPEAR;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack itemStack) {
        return checkNBT(itemStack);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getCount() != 1) {
            return InteractionResultHolder.fail(ItemStack.EMPTY);
        }

        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.pass(itemStack);
        }

        if (player.isSteppingCarefully()) {
            return write(level, player, itemStack);
        } else {
            if (!checkNBT(itemStack)) {
                return InteractionResultHolder.pass(itemStack);
            }
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemStack);
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity player) {
        if (!(player instanceof Player)) {
            return itemStack;
        }

        return read(level, (Player) player, itemStack);
    }

    private static boolean checkNBT(ItemStack itemStack) {
        return itemStack.hasTag() && itemStack.getTag().contains("tpdd");
    }

    private InteractionResultHolder<ItemStack> write(Level level, Player player, ItemStack itemStack) {
        { // Process NBT
            if (checkNBT(itemStack)) {
                itemStack.removeTagKey("tpdd");
            }

            { // Write NBT
                CompoundTag nbt = new CompoundTag();

                nbt.putUUID("player", player.getUUID());

                nbt.putFloat("health", player.getHealth());

                { // Food
                    CompoundTag food_nbt = new CompoundTag();
                    player.getFoodData().addAdditionalSaveData(food_nbt);
                    nbt.put("food", food_nbt);
                }

                { // Effects
                    ListTag effects_nbt = new ListTag();

                    Collection<MobEffectInstance> effects = player.getActiveEffects();
                    for (MobEffectInstance effect : effects) {
                        CompoundTag effect_nbt = new CompoundTag();
                        effect_nbt.putString("id", effect.getEffect().getRegistryName().toString());
                        effect_nbt.putInt("duration", effect.getDuration());
                        effect_nbt.putInt("amplifier", effect.getAmplifier());
                        effects_nbt.add(effect_nbt);
                    }

                    nbt.put("effects", effects_nbt);
                }

                { // Time
                    long[] time = MCTimeUtils.getTime(level);
                    LongArrayTag time_nbt = new LongArrayTag(time);
                    nbt.put("time", time_nbt);
                }



                itemStack.addTagElement("tpdd", nbt);
            }
        }

        if ((CommonConfig.TpddBroadcastOnWrite.get()) && !level.isClientSide()) {
            super.broadcastTime(level, player);
        }

        player.getCooldowns().addCooldown(this, CommonConfig.TpddWriteCooldown.get() * 20);

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    private ItemStack read(Level level, Player player, ItemStack itemStack) {
        CompoundTag nbt = itemStack.getTag().getCompound("tpdd");

        {
            {
                player.setHealth(nbt.getFloat("health"));
                player.getFoodData().readAdditionalSaveData(nbt.getCompound("food"));
            }

            {
                player.removeAllEffects();
                ListTag effects_nbt = nbt.getList("effects", 10);
                if (!effects_nbt.isEmpty()) {
                    for (int i = 0; i < effects_nbt.size(); i++) {
                        CompoundTag effect_nbt = effects_nbt.getCompound(i);
                        player.addEffect(EffectUtils.createInstance(effect_nbt));
                    }
                }
            }

            itemStack.removeTagKey("tpdd");
        }

        if ((CommonConfig.TpddBroadcastOnRead.get()) && !level.isClientSide()) {
            super.broadcast(
                level,
                new TranslatableComponent(
                    "item.haruhiism.tpdd.read.message",
                    player.getDisplayName(),
                    super.getTimeMessage(nbt.getLongArray("time"))
                )
            );
        }

        player.getCooldowns().addCooldown(this, CommonConfig.TpddReadCooldown.get() * 20);

        return itemStack;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemStack, level, list, flag);

        if (checkNBT(itemStack)) {
            CompoundTag nbt = itemStack.getTag().getCompound("tpdd");

            String code = String.valueOf(Math.abs(nbt.hashCode()) + nbt.getLongArray("time")[1])
                + String.valueOf(nbt.getLongArray("time")[2] + nbt.getIntArray("player")[0]);
            if (code.length() % 2 != 0) {
                code += "0";
            }
            char[] code2 = code.toCharArray();

            String code3 = "";
            int blockSize = 2;
            int blockCount = (code2.length + blockSize - 1) / blockSize;
            for (int i = 0; i < blockCount; i++) {
                int idx = i * blockSize;
                char[] b = Arrays.copyOfRange(code2, idx, idx + blockSize);
                int u = ((Integer.parseInt(String.valueOf(b[0])) + Integer.parseInt(String.valueOf(b[1]))) * 2) % 52;
                code3 += (char) (u + ((u <= 25) ? 97 : (65 - 26)));
            }

            list.add(
                new TextComponent(code3)
                    .withStyle(
                        Style.EMPTY
                            .withFont(new ResourceLocation("minecraft", "alt"))
                            .withColor(ChatFormatting.DARK_PURPLE)
                    )
            );
        }
    }

}
