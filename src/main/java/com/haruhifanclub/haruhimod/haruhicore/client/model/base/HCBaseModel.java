package com.haruhifanclub.haruhimod.haruhicore.client.model.base;

import com.haruhifanclub.haruhimod.haruhicore.HaruhiCore;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.resources.ResourceLocation;

public interface HCBaseModel {

    CubeDeformation cubeDeformationZero = new CubeDeformation(0.0F);

    static ModelLayerLocation register(String model) {
        return register(model, "main");
    }

    static ModelLayerLocation register(String model, String layer) {
        return new ModelLayerLocation(new ResourceLocation(HaruhiCore.MOD_ID, model), layer);
    }

}
