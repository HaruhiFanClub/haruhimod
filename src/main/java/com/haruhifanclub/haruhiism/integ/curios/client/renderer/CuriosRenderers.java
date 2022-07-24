package com.haruhifanclub.haruhiism.integ.curios.client.renderer;

import java.util.function.Supplier;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.integ.curios.client.renderer.impl.CuriosOnHeadRenderer;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public final class CuriosRenderers {

    public static void register() {
        register(HMItems.MIKURUS_CONTACT_ITEM.get(), CuriosOnHeadRenderer::new);
    }

    private static void register(Item item, Supplier<ICurioRenderer> renderer) {
        CuriosRendererRegistry.register(item, renderer);
    }

}
