package com.haruhifanclub.haruhiism.integ.curios.client.renderer.impl;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

@OnlyIn(Dist.CLIENT)
public class CuriosOnHeadRenderer implements ICurioRenderer {

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
        ItemStack itemStack, SlotContext slotContext, PoseStack poseStack,
        RenderLayerParent<T, M> renderLayerParent, MultiBufferSource bufferSource,
        int light, float limbSwing, float limbSwingAmount, float partialTicks,
        float ageInTicks, float netHeadYaw, float headPitch
    ) {
        if (!(renderLayerParent.getModel() instanceof HeadedModel headedModel)) return;
        poseStack.pushPose();
        ICurioRenderer.followHeadRotations(slotContext.entity(), headedModel.getHead());
        headedModel.getHead().translateAndRotate(poseStack);
        CustomHeadLayer.translateToHead(poseStack, false);
        Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, TransformType.HEAD, light, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, 0);
        poseStack.popPose();
    }

}
