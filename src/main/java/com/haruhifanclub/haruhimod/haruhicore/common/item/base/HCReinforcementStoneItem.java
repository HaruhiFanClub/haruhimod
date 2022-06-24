package com.haruhifanclub.haruhimod.haruhicore.common.item.base;

import java.util.List;
import org.auioc.mcmod.arnicalib.utils.game.SoundUtils;
import org.auioc.mcmod.arnicalib.utils.game.TextUtils;
import com.haruhifanclub.haruhimod.haruhicore.api.item.IHCItem;
import com.haruhifanclub.haruhimod.haruhicore.common.advancement.criterion.ItemReinforcedTrigger;
import com.haruhifanclub.haruhimod.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.haruhimod.haruhicore.common.itemgroup.HCCreativeModeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class HCReinforcementStoneItem extends Item implements IHCItem {

    private static final String messageKey = "item.haruhicore.reinforcement_stone.";

    public HCReinforcementStoneItem(Rarity rarity) {
        super(
            new Item.Properties()
                .tab(HCCreativeModeTabs.TAB_MAIN)
                .rarity(rarity)
                .stacksTo(16)
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack stack) {
        if (isEpic()) {
            return true;
        }
        return false;
    }


    private static boolean checkTargetBlock(UseOnContext context) {
        List<? extends String> blocks = CommonConfig.ReinforcementStoneUseOnBlock.get();
        ResourceLocation key =
            ForgeRegistries.BLOCKS.getKey(context.getLevel().getBlockState(context.getClickedPos()).getBlock());
        if (blocks.contains(key.toString())) {
            return true;
        }
        return false;
    }

    private static int checkTargetItemStack(ItemStack targetItemStack) {
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


    protected boolean isEnabled() {
        return false;
    }

    protected boolean isEpic() {
        return false;
    }

    protected int getExperienceCost() {
        return 0;
    }

    protected ItemStack processEnchantment(ItemStack stack, Player player) {
        return stack;
    };


    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        if (!isEnabled()) {
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

        int experienceCost = getExperienceCost();
        if ((!player.isCreative()) && (player.totalExperience < experienceCost)) {
            TextUtils.chat(player, TextUtils.getI18nText(messageKey + "xp_not_enough"));
            return InteractionResult.FAIL;
        }


        cooldownTracker.addCooldown(stoneItem, 40);

        player.giveExperiencePoints(-1 * experienceCost);

        ItemStack reinforcedItemStack = processEnchantment(targetItemStack.copy(), player);

        if (reinforcedItemStack.equals(ItemStack.EMPTY)) { // Reinforcement failed
            SoundUtils.play(player, CommonConfig.ReinforcingFailedSound.get()); // TODO auioc/arnicalib-mcmod/issues/4
            ItemReinforcedTrigger.INSTANCE.trigger(player, false, false, targetItemStack, reinforcedItemStack);
        } else {
            SoundUtils.play(player, CommonConfig.ReinforcingSuccessSound.get()); // TODO auioc/arnicalib-mcmod/issues/4
            ItemReinforcedTrigger.INSTANCE.trigger(player, isEpic(), true, targetItemStack, reinforcedItemStack);
        }

        player.setItemInHand(InteractionHand.OFF_HAND, reinforcedItemStack);
        if (!player.isCreative()) {
            player.getMainHandItem().shrink(1);
        }

        return InteractionResult.SUCCESS;
    }

}
