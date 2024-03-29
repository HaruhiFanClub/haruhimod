package com.haruhifanclub.haruhiism.client.model.base;

import com.haruhifanclub.haruhiism.Haruhiism;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.resources.ResourceLocation;

public interface HMBaseModel {

    CubeDeformation CD_NONE = CubeDeformation.NONE;

    static ModelLayerLocation register(String model) {
        return register(model, "main");
    }

    static ModelLayerLocation register(String model, String layer) {
        return new ModelLayerLocation(new ResourceLocation(Haruhiism.MOD_ID, model), layer);
    }

}
