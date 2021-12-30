package com.haruhifanclub.mods.haruhicore.client.model.base;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public interface HCBaseModel {

    static ModelLayerLocation register(String model) {
        return register(model, "main");
    }

    static ModelLayerLocation register(String model, String layer) {
        return new ModelLayerLocation(new ResourceLocation(HaruhiCore.MOD_ID, model), layer);
    }

}
