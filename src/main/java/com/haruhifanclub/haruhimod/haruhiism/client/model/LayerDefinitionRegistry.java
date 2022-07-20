package com.haruhifanclub.haruhimod.haruhiism.client.model;

import com.haruhifanclub.haruhimod.haruhiism.client.model.armor.MaidOutfitArmorModel;
import com.haruhifanclub.haruhimod.haruhiism.client.model.armor.WizardCloakArmorModel;
import com.haruhifanclub.haruhimod.haruhiism.client.model.armor.WizardHatArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class LayerDefinitionRegistry {

    public static void register(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WizardHatArmorModel.LAYER_LOCATION, WizardHatArmorModel::create);
        event.registerLayerDefinition(WizardCloakArmorModel.LAYER_LOCATION, WizardCloakArmorModel::create);
        event.registerLayerDefinition(MaidOutfitArmorModel.LAYER_LOCATION, MaidOutfitArmorModel::create);
    }

}
