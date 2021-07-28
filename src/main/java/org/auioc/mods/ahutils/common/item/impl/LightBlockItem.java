package org.auioc.mods.ahutils.common.item.impl;

import org.auioc.mods.ahutils.common.block.BlockManager;
import org.auioc.mods.ahutils.common.itemgroup.ItemGroupManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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

        return ActionResult.consume(itemStack);
    }
}
