package com.haruhifanclub.mods.haruhicore.common.item.base;

import java.util.List;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import org.auioc.mods.ahutils.utils.game.I18nUtils;
import org.auioc.mods.ahutils.utils.game.MessageUtils;
import org.auioc.mods.ahutils.utils.game.SoundUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

public interface IReinforcementStoneItem {
    static String messageKey = "item.haruhicore.reinforcement_stone";


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

    default boolean checkTargetItem(ItemUseContext context) {
        List<? extends String> items = CommonConfig.ReinforcementStoneItemBlacklist.get();
        ResourceLocation key = ForgeRegistries.ITEMS.getKey(context.getPlayer().getItemInHand(Hand.OFF_HAND).getItem());
        if (items.contains(key.toString())) {
            return false;
        }
        return true;
    }

    default boolean hasEnchantment(ListNBT enchantments) {
        if (enchantments.size() == 0) {
            return false;
        }
        return true;
    }

    default int getExperienceCost(boolean isEpic) {
        return isEpic ? CommonConfig.EpicReinforcingExperienceCost.get()
            : CommonConfig.CommonReinforcingExperienceCost.get();
    }


    public ItemStack processEnchantment(ItemStack stack);

    default ActionResultType reinforce(ItemUseContext context, boolean isEpic) {
        if (!isEnabled(isEpic)) {
            return ActionResultType.PASS;
        }

        World world = context.getLevel();
        if (world.isClientSide) {
            return ActionResultType.PASS;
        }

        PlayerEntity player = context.getPlayer();

        if (!player.isSteppingCarefully()) {
            return ActionResultType.PASS;
        }

        if (!checkTargetBlock(context)) {
            return ActionResultType.PASS;
        }

        if (!checkTargetItem(context)) {
            MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + ".blacklist"));
            return ActionResultType.FAIL;
        }

        ItemStack targetItem = player.getItemInHand(Hand.OFF_HAND);

        if (targetItem.equals(ItemStack.EMPTY)) {
            MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + ".empty_item"));
            return ActionResultType.FAIL;
        }

        if (!hasEnchantment(targetItem.getEnchantmentTags())) {
            MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + ".empty_enchantments"));
            return ActionResultType.FAIL;
        }

        int experienceCost = getExperienceCost(isEpic);
        if ((!player.isCreative()) && (player.totalExperience < experienceCost)) {
            MessageUtils.chat(player, I18nUtils.getTranslatedText(messageKey + ".xp_not_enough"));
            return ActionResultType.FAIL;
        }
        player.giveExperiencePoints(-1 * experienceCost);

        ItemStack reinforcedItem = processEnchantment(targetItem);
        if (reinforcedItem.equals(ItemStack.EMPTY)) {
            SoundUtils.playSoundToPlayer(player, CommonConfig.ReinforcingFailedSound.get());
        } else {
            SoundUtils.playSoundToPlayer(player, CommonConfig.ReinforcingSuccessSound.get());
        }

        // player.setItemInHand(Hand.MAIN_HAND, reinforcedItem);
        // player.setItemInHand(Hand.OFF_HAND, ItemStack.EMPTY);
        player.setItemInHand(Hand.OFF_HAND, reinforcedItem);
        player.getMainHandItem().shrink(1);

        return ActionResultType.SUCCESS;
    }

}
