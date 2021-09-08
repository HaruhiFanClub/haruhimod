package org.auioc.mods.ahutils.common.event;

import java.util.Set;
import org.auioc.mods.ahutils.common.event.impl.PistonCheckPushableEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommonEventHandler {

    @SubscribeEvent
    public static void onPistonCheckPushable(PistonCheckPushableEvent event) {
        Set<ResourceLocation> tags = event.getState().getBlock().getTags();
        for (ResourceLocation tag : tags) {
            if ((tag.getPath()).equals("unpushable_blocks")) {
                event.setCanceled(true);
            }
        }
    }

}
