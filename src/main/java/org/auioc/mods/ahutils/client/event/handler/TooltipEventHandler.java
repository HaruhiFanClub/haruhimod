package org.auioc.mods.ahutils.client.event.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

@OnlyIn(Dist.CLIENT)
public class TooltipEventHandler {

    public static void handle(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();

        if (itemStack.isEmpty()) {
            return;
        }

        if (itemStack.hasTag()) {
            CompoundNBT nbt = itemStack.getTag();
            ITextComponent nbtTooltip = nbt.getPrettyDisplay();
            add(event, nbtTooltip);
        }

    }

    private static void add(ItemTooltipEvent event, ITextComponent tooltip) {
        event.getToolTip().add(tooltip);
    }

}
