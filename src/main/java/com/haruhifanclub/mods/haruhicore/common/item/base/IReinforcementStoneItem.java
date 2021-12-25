package com.haruhifanclub.mods.haruhicore.common.item.base;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.common.advancement.criterion.ItemReinforcedTrigger;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.server.event.impl.PlayerReinforceItemEvent;
import org.auioc.mods.ahutils.utils.game.SoundUtils;
import org.auioc.mods.ahutils.utils.game.TextUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.ForgeRegistries;

public interface IReinforcementStoneItem {
    static String messageKey = "item.haruhicore.reinforcement_stone.";


    default boolean isEnabled(Boolean isEpic) {
        return isEpic ? CommonConfig.EnableEpicReinforcementStone.get()
            : CommonConfig.EnableCommonReinforcementStone.get();
    }

    default boolean checkTargetBlock(UseOnContext context) {
        List<? extends String> blocks = CommonConfig.ReinforcementStoneUseOnBlock.get();
        ResourceLocation key =
            ForgeRegistries.BLOCKS.getKey(context.getLevel().getBlockState(context.getClickedPos()).getBlock());
        if (blocks.contains(key.toString())) {
            return true;
        }
        return false;
    }

    default int checkTargetItemStack(ItemStack targetItemStack) {
        if (targetItemStack.equals(ItemStack.EMPTY)) {
            return 1; // Empty ItemStack
        }

        List<? extends String> items = CommonConfig.ReinforcementStoneItemBlacklist.get();
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(targetItemStack.getItem());
        if (items.contains(key.toString())) {
            return 2; // Item is in the blacklist
        }

        if (targetItemStack.getEnchantmentTags().size() == 0) {
            return 3; // ItemStack does not have enchantments
        }

        return 0;
    }


    default int getExperienceCost(boolean isEpic) {
        return isEpic ? CommonConfig.EpicReinforcingExperienceCost.get()
            : CommonConfig.CommonReinforcingExperienceCost.get();
    }


    default ItemStack processEnchantment(ItemStack stack, Player player) {
        return stack;
    };

    default InteractionResult reinforce(UseOnContext context, boolean isEpic) {
        if (!isEnabled(isEpic)) {
            return InteractionResult.PASS;
        }

        if (context.getLevel().isClientSide()) {
            return InteractionResult.CONSUME;
        }

        ServerPlayer player = (ServerPlayer) context.getPlayer();


        Item stoneItem = player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
        ItemCooldowns cooldownTracker = player.getCooldowns();
        if (cooldownTracker.isOnCooldown(stoneItem)) {
            return InteractionResult.PASS;
        }

        if (!player.isSteppingCarefully()) {
            return InteractionResult.PASS;
        }

        if (!checkTargetBlock(context)) {
            return InteractionResult.PASS;
        }

        ItemStack targetItemStack = player.getItemInHand(InteractionHand.OFF_HAND);

        int itemStackCheckResult = checkTargetItemStack(targetItemStack);
        if (itemStackCheckResult > 0) {
            switch (itemStackCheckResult) {
                case 1: {
                    TextUtils.chat(player, TextUtils.getI18nText(messageKey + "empty_item"));
                    break;
                }
                case 2: {
                    TextUtils.chat(player, TextUtils.getI18nText(messageKey + "blacklist"));
                    break;
                }
                case 3: {
                    TextUtils.chat(player, TextUtils.getI18nText(messageKey + "empty_enchantments"));
                    break;
                }
            }
            return InteractionResult.FAIL;
        }

        int experienceCost = getExperienceCost(isEpic);
        if ((!player.isCreative()) && (player.totalExperience < experienceCost)) {
            TextUtils.chat(player, TextUtils.getI18nText(messageKey + "xp_not_enough"));
            return InteractionResult.FAIL;
        }


        if (MinecraftForge.EVENT_BUS.post(new PlayerReinforceItemEvent.Pre(player, targetItemStack))) {
            return InteractionResult.FAIL;
        }

        cooldownTracker.addCooldown(stoneItem, 40);

        player.giveExperiencePoints(-1 * experienceCost);

        ItemStack reinforcedItemStack = processEnchantment(targetItemStack.copy(), player);

        MinecraftForge.EVENT_BUS.post(new PlayerReinforceItemEvent.Post(player, targetItemStack, reinforcedItemStack));

        if (reinforcedItemStack.equals(ItemStack.EMPTY)) { // Reinforcement failed
            SoundUtils.playSoundToPlayer(player, CommonConfig.ReinforcingFailedSound.get());
            ItemReinforcedTrigger.INSTANCE.trigger(player, false, false, targetItemStack, reinforcedItemStack);
        } else {
            SoundUtils.playSoundToPlayer(player, CommonConfig.ReinforcingSuccessSound.get());
            ItemReinforcedTrigger.INSTANCE.trigger(player, isEpic, true, targetItemStack, reinforcedItemStack);
        }

        player.setItemInHand(InteractionHand.OFF_HAND, reinforcedItemStack);
        if (!player.isCreative()) {
            player.getMainHandItem().shrink(1);
        }

        return InteractionResult.SUCCESS;
    }

}
