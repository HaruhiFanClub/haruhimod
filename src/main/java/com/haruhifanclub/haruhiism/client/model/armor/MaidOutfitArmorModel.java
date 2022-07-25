package com.haruhifanclub.haruhiism.client.model.armor;

import com.haruhifanclub.haruhiism.client.model.base.HMBaseModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MaidOutfitArmorModel extends HumanoidModel<LivingEntity> implements HMBaseModel {

    public static final ModelLayerLocation LAYER_LOCATION = HMBaseModel.register("maid_outfit_armor");
    private final ModelPart body;

    public MaidOutfitArmorModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
    }

    public static LayerDefinition create() {
        var mesh = HumanoidModel.createMesh(CD_NONE, 0.0F);

        var body = mesh.getRoot().addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);

        body.addOrReplaceChild(
            "bb", CubeListBuilder.create().texOffs(22, 0).addBox(-3.0F, -11.0F, -8.0F, 8.0F, 13.0F, 1.0F, CD_NONE)
                .texOffs(0, 0).addBox(-3.0F, -11.0F, 7.0F, 8.0F, 13.0F, 1.0F, CD_NONE)
                .texOffs(36, 39).addBox(-3.0F, -11.0F, -7.0F, 1.0F, 13.0F, 14.0F, CD_NONE)
                .texOffs(0, 20).addBox(3.0F, -10.0F, -7.0F, 2.0F, 12.0F, 14.0F, CD_NONE)
                .texOffs(0, 53).addBox(3.0F, 2.0F, -8.0F, 2.0F, 1.0F, 16.0F, CD_NONE)
                .texOffs(22, 2).addBox(7.0F, 7.0F, -9.0F, 1.0F, 1.0F, 18.0F, CD_NONE)
                .texOffs(34, 21).addBox(4.0F, 3.0F, -8.0F, 2.0F, 2.0F, 16.0F, CD_NONE)
                .texOffs(42, 0).addBox(5.0F, 5.0F, -8.0F, 2.0F, 3.0F, 16.0F, CD_NONE)
                .texOffs(16, 30).addBox(-4.0F, -16.0F, -8.0F, 1.0F, 7.0F, 16.0F, CD_NONE)
                .texOffs(50, 50).addBox(-5.0F, -15.0F, -8.0F, 1.0F, 5.0F, 16.0F, CD_NONE)
                .texOffs(54, 23).addBox(-6.0F, -14.0F, -8.0F, 1.0F, 3.0F, 16.0F, CD_NONE)
                .texOffs(38, 71).addBox(-7.0F, -13.0F, -8.0F, 1.0F, 1.0F, 16.0F, CD_NONE)
                .texOffs(0, 70).addBox(-5.0F, 2.0F, -8.0F, 1.0F, 1.0F, 16.0F, CD_NONE)
                .texOffs(68, 59).addBox(-7.0F, 5.0F, -8.0F, 1.0F, 1.0F, 16.0F, CD_NONE)
                .texOffs(58, 76).addBox(-7.0F, 4.0F, -7.0F, 1.0F, 1.0F, 14.0F, CD_NONE)
                .texOffs(72, 21).addBox(-8.0F, 5.0F, -7.0F, 1.0F, 1.0F, 14.0F, CD_NONE)
                .texOffs(68, 42).addBox(-9.0F, 7.0F, -8.0F, 1.0F, 1.0F, 16.0F, CD_NONE)
                .texOffs(0, 0).addBox(-8.0F, 6.0F, -9.0F, 2.0F, 2.0F, 18.0F, CD_NONE)
                .texOffs(20, 66).addBox(-4.0F, 0.0F, -8.0F, 1.0F, 2.0F, 16.0F, CD_NONE)
                .texOffs(62, 3).addBox(-6.0F, 3.0F, -8.0F, 1.0F, 2.0F, 16.0F, CD_NONE)
                .texOffs(74, 76).addBox(-3.0F, -16.0F, -6.0F, 1.0F, 1.0F, 12.0F, CD_NONE)
                .texOffs(6, 20).addBox(-3.0F, -20.0F, -8.0F, 1.0F, 9.0F, 2.0F, CD_NONE)
                .texOffs(0, 20).addBox(-3.0F, -20.0F, 6.0F, 1.0F, 9.0F, 2.0F, CD_NONE)
                .texOffs(44, 26).addBox(4.0F, -19.0F, 6.0F, 1.0F, 8.0F, 2.0F, CD_NONE)
                .texOffs(42, 0).addBox(4.0F, -19.0F, -8.0F, 1.0F, 8.0F, 2.0F, CD_NONE)
                .texOffs(22, 14).addBox(-2.0F, -20.0F, -8.0F, 7.0F, 1.0F, 2.0F, CD_NONE)
                .texOffs(0, 14).addBox(-2.0F, -20.0F, 6.0F, 7.0F, 1.0F, 2.0F, CD_NONE)
                .texOffs(22, 30).addBox(4.0F, -11.0F, -7.0F, 1.0F, 1.0F, 1.0F, CD_NONE)
                .texOffs(18, 30).addBox(4.0F, -11.0F, 6.0F, 1.0F, 1.0F, 1.0F, CD_NONE)
                .texOffs(56, 71).addBox(-4.0F, 2.0F, 8.0F, 9.0F, 1.0F, 1.0F, CD_NONE)
                .texOffs(10, 20).addBox(-7.0F, 7.0F, 9.0F, 1.0F, 1.0F, 1.0F, CD_NONE)
                .texOffs(18, 28).addBox(-6.0F, 7.0F, 10.0F, 12.0F, 1.0F, 1.0F, CD_NONE)
                .texOffs(62, 0).addBox(-5.0F, 3.0F, 8.0F, 11.0F, 2.0F, 1.0F, CD_NONE)
                .texOffs(52, 42).addBox(-6.0F, 5.0F, 8.0F, 13.0F, 3.0F, 2.0F, CD_NONE)
                .texOffs(54, 21).addBox(-4.0F, 2.0F, -9.0F, 9.0F, 1.0F, 1.0F, CD_NONE)
                .texOffs(52, 47).addBox(-5.0F, 3.0F, -9.0F, 11.0F, 2.0F, 1.0F, CD_NONE)
                .texOffs(18, 21).addBox(-6.0F, 5.0F, -10.0F, 13.0F, 3.0F, 2.0F, CD_NONE)
                .texOffs(18, 26).addBox(-6.0F, 7.0F, -11.0F, 12.0F, 1.0F, 1.0F, CD_NONE)
                .texOffs(4, 20).addBox(-7.0F, 7.0F, -10.0F, 1.0F, 1.0F, 1.0F, CD_NONE),
            PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, -1.5708F, 0.0F)
        );

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.15D, 0.0D);
        poseStack.scale(0.7F, 0.7F, 0.7F);
        this.body.render(poseStack, buffer, packedLight, packedOverlay);
        poseStack.popPose();
    }

}
