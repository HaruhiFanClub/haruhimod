package org.auioc.mods.ahutils.common.item.impl;

import org.auioc.mods.ahutils.common.block.BlockManager;
import org.auioc.mods.ahutils.common.itemgroup.ItemGroupManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class LightBlockItem extends BlockItem {
    public LightBlockItem() {
        super(
            BlockManager.LIGHT_BLOCK.get(),
            new Item.Properties()
                .tab(ItemGroupManager.itemGroup)
                .rarity(Rarity.UNCOMMON)
                .stacksTo(1)
        );
    }

    @Override
    public ITextComponent getName(ItemStack itemStack) {
        TextComponent text = new TranslationTextComponent(this.getDescriptionId());

        CompoundNBT tag = itemStack.getTag();
        int level = (itemStack.getTag() != null && tag.contains("BlockStateTag") && tag.getCompound("BlockStateTag").contains("level"))
            ? tag.getCompound("BlockStateTag").getInt("level")
            : 0;

        text.append(new TranslationTextComponent("ahutils.light.item.name.level", level));

        return text;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!player.isSteppingCarefully()) {
            return ActionResult.pass(itemStack);
        }

        CompoundNBT nbt = itemStack.getOrCreateTagElement("BlockStateTag");
        if (nbt.contains("level")) {
            int level = nbt.getInt("level");
            if (level < 15) {
                nbt.putInt("level", level + 1);
            } else if (level == 15) {
                nbt.putInt("level", 0);
            }
        } else {
            nbt.putInt("level", 0);
        }

        if (!world.isClientSide) {
            ((ServerPlayerEntity) player).sendMessage(getName(itemStack), ChatType.GAME_INFO, Util.NIL_UUID);
        }

        return ActionResult.consume(itemStack);
    }
}
