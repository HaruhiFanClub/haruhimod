package com.haruhifanclub.mods.haruhicore.common.item.base;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.common.advancement.criterion.ItemReinforcedTrigger;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.server.event.impl.PlayerReinforceItemEvent;
import org.auioc.mods.ahutils.utils.game.I18nUtils;
import org.auioc.mods.ahutils.utils.game.MessageUtils;
import org.auioc.mods.ahutils.utils.game.SoundUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.ForgeRegistries;

public interface IReinforcementStoneItem {
    static String messageKey = "item.haruhicore.reinforcement_stone.";


    default boolean isEnabled(Boolean isEpic) {
        return isEpic ? CommonConfig.EnableEpicReinforcementStone.get()
            : CommonConfig.EnableCommonReinforcementStone.get();
    }

    default boolean checkTargetBlock(ItemUseContext context) {
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


    default ItemStack processEnchantment(ItemStack stack, PlayerEntity player) {
        return stack;
    };

    default ActionResultType reinforce(ItemUseContext context, boolean isEpic) {
        if (!isEnabled(isEpic)) {
            return ActionResultType.PASS;
        }

        if (context.getLevel().isClientSide()) {
            return ActionResultType.CONSUME;
        }

        ServerPlayerEntity player = (ServerPlayerEntity) context.getPlayer();


        Item stoneItem = player.getItemInHand(Hand.MAIN_HAND).getItem();
        CooldownTracker cooldownTracker = player.getCooldowns();
        if (cooldownTracker.isOnCooldown(stoneItem)) {
            return ActionResultType.PASS;
        }

        if (!player.isSteppingCarefully()) {
            return ActionResultType.PASS;
        }

        if (!checkTargetBlock(context)) {
            return ActionResultType.PASS;
        }

        ItemStack targetItemStack = player.getItemInHand(Hand.OFF_HAND);

        int itemStackCheckResult = checkTargetItemStack(targetItemStack);
        if (itemStackCheckResult > 0) {
            switch (itemStackCheckResult) {
                case 1: {
                    MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + "empty_item"));
                    break;
                }
                case 2: {
                    MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + "blacklist"));
                    break;
                }
                case 3: {
                    MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + "empty_enchantments"));
                    break;
                }
            }
            return ActionResultType.FAIL;
        }

        int experienceCost = getExperienceCost(isEpic);
        if ((!player.isCreative()) && (player.totalExperience < experienceCost)) {
            MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + "xp_not_enough"));
            return ActionResultType.FAIL;
        }


        if (MinecraftForge.EVENT_BUS.post(new PlayerReinforceItemEvent.Pre(player, targetItemStack))) {
            return ActionResultType.FAIL;
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

        player.setItemInHand(Hand.OFF_HAND, reinforcedItemStack);
        if (!player.isCreative()) {
            player.getMainHandItem().shrink(1);
        }

        return ActionResultType.SUCCESS;
    }

}
