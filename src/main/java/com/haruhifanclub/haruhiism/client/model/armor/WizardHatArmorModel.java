package com.haruhifanclub.haruhiism.client.model.armor;

import com.google.common.collect.ImmutableList;
import com.haruhifanclub.haruhiism.client.model.base.HMBaseModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WizardHatArmorModel extends HumanoidModel<LivingEntity> implements HMBaseModel {

    public static final ModelLayerLocation LAYER_LOCATION = HMBaseModel.register("wizard_hat_armor");

    public WizardHatArmorModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition create() {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);

        PartDefinition head = mesh.getRoot().addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);

        {
            PartPose f1_offset = PartPose.offset(0.0F, -5.62F - 0.0F, 0.0F);
            PartPose f2_offset = PartPose.offset(0.0F, -5.62F - 0.0F, 0.0F);
            PartPose f3_offset = PartPose.offset(0.0F, -5.62F - 1.0F, 0.0F);
            PartPose f4_offset = PartPose.offset(0.0F, -5.62F - 2.0F, 0.0F);
            PartPose f5_offset = PartPose.offset(0.0F, -5.62F - 2.0F, 0.0F);
            PartPose f6_offset = PartPose.offset(0.0F, -5.62F - 0.0F, 0.0F);
            PartPose f7_offset = PartPose.offset(0.0F, -5.62F - 0.0F, 0.0F);

            {
                PartDefinition f1 = head.addOrReplaceChild(
                    "f1", CubeListBuilder.create().texOffs(65, 18).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(99, 97).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(93, 43).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(26, 83).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(66, 14).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(65, 1).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(63, 82).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(93, 20).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(72, 94).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(65, 13).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(66, 33).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero),
                    f1_offset
                );


                f1.addOrReplaceChild(
                    "cube_r1", CubeListBuilder.create().texOffs(38, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero)
                        .texOffs(52, 6).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(0, 0).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(81, 49).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(69, 27).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(43, 48).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(40, 36).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(16, 38).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(69, 38).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(13, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(48, 30).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, -3.1416F)
                );

                f1.addOrReplaceChild(
                    "cube_r2", CubeListBuilder.create().texOffs(44, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero)
                        .texOffs(0, 53).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(0, 9).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(83, 59).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(71, 60).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(52, 0).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(19, 51).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(69, 49).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(75, 82).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(36, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(52, 19).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -3.1416F)
                );

                f1.addOrReplaceChild(
                    "cube_r3", CubeListBuilder.create().texOffs(16, 49).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero)
                        .texOffs(56, 49).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(0, 19).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(39, 85).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(72, 71).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(0, 53).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(52, 13).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(27, 72).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(84, 69).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(52, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(54, 31).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F)
                );

                f1.addOrReplaceChild(
                    "cube_r4", CubeListBuilder.create().texOffs(50, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero)
                        .texOffs(0, 58).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(0, 28).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(50, 86).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(51, 74).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(56, 37).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(53, 25).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(39, 73).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(13, 86).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(97, 77).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(56, 54).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, -3.1416F)
                );

                f1.addOrReplaceChild(
                    "cube_r5", CubeListBuilder.create().texOffs(32, 59).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero)
                        .texOffs(58, 61).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(62, 93).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(0, 88).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(0, 77).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(32, 60).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(56, 49).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(14, 75).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(86, 79).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(97, 89).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(45, 60).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F)
                );

                f1.addOrReplaceChild(
                    "cube_r6", CubeListBuilder.create().texOffs(13, 61).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero)
                        .texOffs(65, 0).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(25, 94).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(90, 0).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(79, 11).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(58, 62).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(45, 61).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(78, 0).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(86, 89).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(0, 98).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(0, 65).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
                );

                f1.addOrReplaceChild(
                    "cube_r7", CubeListBuilder.create().texOffs(50, 65).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, cubeDeformationZero)
                        .texOffs(13, 65).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(94, 53).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(92, 33).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(81, 22).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(0, 65).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(13, 63).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, cubeDeformationZero)
                        .texOffs(80, 38).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(91, 10).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, cubeDeformationZero)
                        .texOffs(83, 99).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(65, 5).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F)
                );
            }

            {
                PartDefinition f2 = head.addOrReplaceChild(
                    "f2", CubeListBuilder.create().texOffs(78, 0).addBox(-7.0F, -4.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(86, 82).addBox(-6.0F, -4.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(30, 86).addBox(-5.0F, -4.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    f2_offset
                );

                f2.addOrReplaceChild(
                    "cube_r8", CubeListBuilder.create().texOffs(80, 38).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(79, 13).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(71, 29).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, -3.1416F)
                );

                f2.addOrReplaceChild(
                    "cube_r9", CubeListBuilder.create().texOffs(81, 49).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(81, 26).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(71, 61).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, -3.1416F)
                );

                f2.addOrReplaceChild(
                    "cube_r10", CubeListBuilder.create().texOffs(83, 16).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(75, 82).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(39, 72).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -3.1416F)
                );

                f2.addOrReplaceChild(
                    "cube_r11", CubeListBuilder.create().texOffs(38, 84).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(83, 60).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(51, 73).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, -3.1416F)
                );

                f2.addOrReplaceChild(
                    "cube_r12", CubeListBuilder.create().texOffs(84, 71).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(84, 41).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(26, 75).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F)
                );

                f2.addOrReplaceChild(
                    "cube_r13", CubeListBuilder.create().texOffs(61, 85).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(50, 85).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(0, 77).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
                );

                f2.addOrReplaceChild(
                    "cube_r14", CubeListBuilder.create().texOffs(24, 86).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(67, 85).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(12, 77).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F)
                );
            }

            {
                PartDefinition f3 = head.addOrReplaceChild(
                    "f3", CubeListBuilder.create().texOffs(74, 74).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(0, 70).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(34, 38).addBox(-4.0F, -6.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero),
                    f3_offset
                );

                f3.addOrReplaceChild(
                    "cube_r15", CubeListBuilder.create().texOffs(38, 6).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(22, 53).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(0, 38).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, -3.1416F)
                );

                f3.addOrReplaceChild(
                    "cube_r16", CubeListBuilder.create().texOffs(16, 38).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(35, 63).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(8, 38).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, -3.1416F)
                );

                f3.addOrReplaceChild(
                    "cube_r17", CubeListBuilder.create().texOffs(38, 17).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(45, 65).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(32, 51).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -3.1416F)
                );

                f3.addOrReplaceChild(
                    "cube_r18", CubeListBuilder.create().texOffs(22, 38).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(66, 26).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(13, 53).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, -3.1416F)
                );

                f3.addOrReplaceChild(
                    "cube_r19", CubeListBuilder.create().texOffs(38, 23).addBox(-4.0F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(58, 66).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(53, 37).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F)
                );

                f3.addOrReplaceChild(
                    "cube_r20", CubeListBuilder.create().texOffs(28, 38).addBox(-4.0F, -6.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(69, 38).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(61, 37).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
                );

                f3.addOrReplaceChild(
                    "cube_r21", CubeListBuilder.create().texOffs(38, 30).addBox(-4.0F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(69, 49).addBox(-5.0F, -5.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(26, 63).addBox(-6.0F, -5.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F)
                );

            }

            {
                PartDefinition f4 = head.addOrReplaceChild(
                    "f4", CubeListBuilder.create().texOffs(29, 27).addBox(-5.0F, -8.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero)
                        .texOffs(10, 28).addBox(-4.0F, -8.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero),
                    f4_offset
                );

                f4.addOrReplaceChild(
                    "cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(20, 0).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, -3.1416F)
                );

                f4.addOrReplaceChild(
                    "cube_r23", CubeListBuilder.create().texOffs(0, 9).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(20, 8).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, -3.1416F)
                );

                f4.addOrReplaceChild(
                    "cube_r24", CubeListBuilder.create().texOffs(10, 0).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(20, 19).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -3.1416F)
                );

                f4.addOrReplaceChild(
                    "cube_r25", CubeListBuilder.create().texOffs(10, 9).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(20, 27).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, -3.1416F)
                );

                f4.addOrReplaceChild(
                    "cube_r26", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(29, 0).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F)
                );

                f4.addOrReplaceChild(
                    "cube_r27", CubeListBuilder.create().texOffs(10, 19).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(29, 8).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
                );

                f4.addOrReplaceChild(
                    "cube_r28", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, cubeDeformationZero)
                        .texOffs(29, 19).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F)
                );

            }

            {
                PartDefinition f5 = head.addOrReplaceChild(
                    "f5", CubeListBuilder.create().texOffs(52, 13).addBox(-4.0F, -10.0F, -2.0F, 1.0F, 2.0F, 4.0F, cubeDeformationZero)
                        .texOffs(71, 13).addBox(-3.0F, -10.0F, 1.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(13, 70).addBox(-3.0F, -10.0F, -3.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(69, 55).addBox(-2.0F, -10.0F, -4.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(58, 25).addBox(-2.0F, -10.0F, 2.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(45, 17).addBox(-1.0F, -10.0F, -4.0F, 1.0F, 2.0F, 1.0F, cubeDeformationZero)
                        .texOffs(45, 6).addBox(-1.0F, -10.0F, 3.0F, 1.0F, 2.0F, 1.0F, cubeDeformationZero),
                    f5_offset
                );

                f5.addOrReplaceChild(
                    "cube_r29", CubeListBuilder.create().texOffs(45, 0).addBox(-1.0F, -9.0F, 3.0F, 1.0F, 2.0F, 1.0F, cubeDeformationZero)
                        .texOffs(40, 36).addBox(-1.0F, -9.0F, -4.0F, 1.0F, 2.0F, 1.0F, cubeDeformationZero)
                        .texOffs(52, 25).addBox(-2.0F, -9.0F, 2.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(47, 51).addBox(-2.0F, -9.0F, -4.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(6, 48).addBox(-3.0F, -9.0F, -3.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(0, 48).addBox(-3.0F, -9.0F, 1.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(52, 0).addBox(-4.0F, -9.0F, -2.0F, 1.0F, 2.0F, 4.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
                );
            }

            {
                head.addOrReplaceChild(
                    "f6", CubeListBuilder.create().texOffs(38, 30).addBox(2.0F, -13.0F, -2.0F, 1.0F, 1.0F, 4.0F, cubeDeformationZero)
                        .texOffs(62, 102).addBox(1.0F, -14.0F, -3.0F, 1.0F, 2.0F, 6.0F, cubeDeformationZero)
                        .texOffs(101, 0).addBox(0.0F, -15.0F, -3.0F, 1.0F, 3.0F, 6.0F, cubeDeformationZero)
                        .texOffs(53, 37).addBox(-1.0F, -16.0F, -3.0F, 1.0F, 4.0F, 6.0F, cubeDeformationZero)
                        .texOffs(0, 38).addBox(-2.0F, -16.0F, -3.0F, 1.0F, 4.0F, 6.0F, cubeDeformationZero)
                        .texOffs(28, 38).addBox(-3.0F, -16.0F, -2.0F, 1.0F, 4.0F, 4.0F, cubeDeformationZero)
                        .texOffs(16, 38).addBox(-4.0F, -16.0F, -2.0F, 1.0F, 4.0F, 4.0F, cubeDeformationZero)
                        .texOffs(40, 36).addBox(-5.0F, -15.0F, -2.0F, 1.0F, 3.0F, 4.0F, cubeDeformationZero)
                        .texOffs(41, 51).addBox(-6.0F, -14.0F, -2.0F, 1.0F, 2.0F, 4.0F, cubeDeformationZero)
                        .texOffs(44, 30).addBox(-7.0F, -13.0F, -1.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(40, 43).addBox(-8.0F, -12.0F, -1.0F, 1.0F, 2.0F, 2.0F, cubeDeformationZero)
                        .texOffs(38, 0).addBox(-9.0F, -11.0F, -0.5F, 1.0F, 3.0F, 1.0F, cubeDeformationZero),
                    f6_offset
                );
            }

            {
                PartDefinition f7 = head.addOrReplaceChild(
                    "f7", CubeListBuilder.create().texOffs(104, 43).addBox(11.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, cubeDeformationZero)
                        .texOffs(38, 17).addBox(10.0F, -2.0F, -6.0F, 1.0F, 1.0F, 12.0F, cubeDeformationZero)
                        .texOffs(0, 38).addBox(9.0F, -2.0F, -7.0F, 1.0F, 1.0F, 14.0F, cubeDeformationZero)
                        .texOffs(20, 19).addBox(8.0F, -2.0F, -8.0F, 1.0F, 1.0F, 16.0F, cubeDeformationZero)
                        .texOffs(0, 19).addBox(7.0F, -2.0F, -9.0F, 1.0F, 1.0F, 18.0F, cubeDeformationZero)
                        .texOffs(95, 69).addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(26, 63).addBox(6.0F, -2.0F, -10.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(13, 53).addBox(5.0F, -2.0F, -11.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(32, 51).addBox(5.0F, -2.0F, 4.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(34, 104).addBox(4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 6.0F, cubeDeformationZero)
                        .texOffs(104, 20).addBox(4.0F, -2.0F, -11.0F, 1.0F, 1.0F, 6.0F, cubeDeformationZero)
                        .texOffs(38, 23).addBox(3.0F, -2.0F, -11.0F, 1.0F, 1.0F, 5.0F, cubeDeformationZero)
                        .texOffs(38, 17).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 5.0F, cubeDeformationZero)
                        .texOffs(24, 103).addBox(0.0F, -2.0F, 7.0F, 3.0F, 1.0F, 5.0F, cubeDeformationZero)
                        .texOffs(102, 10).addBox(0.0F, -2.0F, -12.0F, 3.0F, 1.0F, 5.0F, cubeDeformationZero),
                    f7_offset
                );

                f7.addOrReplaceChild(
                    "cube_r30", CubeListBuilder.create().texOffs(94, 62).addBox(0.0F, -2.0F, -12.0F, 3.0F, 1.0F, 5.0F, cubeDeformationZero)
                        .texOffs(63, 74).addBox(0.0F, -2.0F, 7.0F, 3.0F, 1.0F, 5.0F, cubeDeformationZero)
                        .texOffs(38, 6).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 5.0F, cubeDeformationZero)
                        .texOffs(38, 0).addBox(3.0F, -2.0F, -11.0F, 1.0F, 1.0F, 5.0F, cubeDeformationZero)
                        .texOffs(10, 104).addBox(4.0F, -2.0F, -11.0F, 1.0F, 1.0F, 6.0F, cubeDeformationZero)
                        .texOffs(103, 30).addBox(4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 6.0F, cubeDeformationZero)
                        .texOffs(20, 27).addBox(5.0F, -2.0F, 4.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(20, 19).addBox(5.0F, -2.0F, -11.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(20, 8).addBox(6.0F, -2.0F, -10.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(20, 0).addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 7.0F, cubeDeformationZero)
                        .texOffs(0, 0).addBox(7.0F, -2.0F, -9.0F, 1.0F, 1.0F, 18.0F, cubeDeformationZero)
                        .texOffs(20, 0).addBox(8.0F, -2.0F, -8.0F, 1.0F, 1.0F, 16.0F, cubeDeformationZero)
                        .texOffs(24, 36).addBox(9.0F, -2.0F, -7.0F, 1.0F, 1.0F, 14.0F, cubeDeformationZero)
                        .texOffs(38, 0).addBox(10.0F, -2.0F, -6.0F, 1.0F, 1.0F, 12.0F, cubeDeformationZero)
                        .texOffs(45, 96).addBox(11.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
                );
            }
        }

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of();
    }

}
