package com.haruhifanclub.haruhiism.client.renderer.armor;

import com.haruhifanclub.haruhiism.client.model.armor.WizardHatArmorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

@OnlyIn(Dist.CLIENT)
public class WizardHatArmorRenderer implements IItemRenderProperties {

    public static final WizardHatArmorRenderer INSTANCE = new WizardHatArmorRenderer();

    @Override
    @OnlyIn(Dist.CLIENT)
    public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
        EntityModelSet models = Minecraft.getInstance().getEntityModels();
        ModelPart root = models.bakeLayer(WizardHatArmorModel.LAYER_LOCATION);
        return new WizardHatArmorModel(root);
    }

}
