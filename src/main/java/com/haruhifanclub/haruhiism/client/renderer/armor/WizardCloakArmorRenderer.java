package com.haruhifanclub.haruhiism.client.renderer.armor;

import com.haruhifanclub.haruhiism.client.model.armor.WizardCloakArmorModel;
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
public class WizardCloakArmorRenderer implements IItemRenderProperties {

    public static final WizardCloakArmorRenderer INSTANCE = new WizardCloakArmorRenderer();

    @Override
    @OnlyIn(Dist.CLIENT)
    public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
        EntityModelSet models = Minecraft.getInstance().getEntityModels();
        ModelPart root = models.bakeLayer(WizardCloakArmorModel.LAYER_LOCATION);
        return new WizardCloakArmorModel(root);
    }

}
