package com.haruhifanclub.haruhimod.haruhiism.client.model.armor;

import com.google.common.collect.ImmutableList;
import com.haruhifanclub.haruhimod.haruhiism.client.model.base.HCBaseModel;
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
public class WizardCloakArmorModel extends HumanoidModel<LivingEntity> implements HCBaseModel {

    public static final ModelLayerLocation LAYER_LOCATION = HCBaseModel.register("wizard_cloak_armor");
    private final ModelPart cloak;

    public WizardCloakArmorModel(ModelPart root) {
        super(root);
        this.cloak = root.getChild("cloak");
    }

    public static LayerDefinition create() {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);

        PartDefinition cloak = mesh.getRoot().addOrReplaceChild("cloak", CubeListBuilder.create(), PartPose.offset(0.0F, 21.5F, 0.0F));

        {
            {
                PartDefinition bot = cloak.addOrReplaceChild("bot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

                bot.addOrReplaceChild(
                    "bot_r1", CubeListBuilder.create().texOffs(36, 11).addBox(-4.5F, -4.0F, 11.0F, 1.0F, 4.0F, 1.0F, cubeDeformationZero)
                        .texOffs(36, 27).addBox(-18.5F, -4.0F, 11.0F, 1.0F, 4.0F, 1.0F, cubeDeformationZero)
                        .texOffs(12, 35).addBox(-3.5F, -8.0F, 11.0F, 1.0F, 8.0F, 1.0F, cubeDeformationZero)
                        .texOffs(16, 35).addBox(-19.5F, -8.0F, 11.0F, 1.0F, 8.0F, 1.0F, cubeDeformationZero)
                        .texOffs(60, 55).addBox(-2.5F, -10.0F, 11.0F, 1.0F, 10.0F, 1.0F, cubeDeformationZero)
                        .texOffs(27, 62).addBox(-20.5F, -10.0F, 11.0F, 1.0F, 10.0F, 1.0F, cubeDeformationZero)
                        .texOffs(0, 34).addBox(-21.5F, -2.0F, 2.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(0, 21).addBox(-21.5F, -1.0F, 0.0F, 1.0F, 1.0F, 12.0F, cubeDeformationZero)
                        .texOffs(0, 19).addBox(-20.5F, -1.0F, 0.0F, 19.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(12, 35).addBox(-1.5F, -2.0F, 2.0F, 1.0F, 1.0F, 10.0F, cubeDeformationZero)
                        .texOffs(14, 22).addBox(-1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 12.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(-11.0F, 0.0F, 6.0F, -3.1416F, 0.0F, 3.1416F)
                );
            }

            {
                PartDefinition out1 = cloak.addOrReplaceChild("out1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

                out1.addOrReplaceChild(
                    "out1_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-19.5F, -6.0F, 1.0F, 17.0F, 6.0F, 1.0F, cubeDeformationZero)
                        .texOffs(32, 0).addBox(-20.5F, -7.0F, 1.0F, 1.0F, 7.0F, 1.0F, cubeDeformationZero)
                        .texOffs(24, 35).addBox(-2.5F, -7.0F, 1.0F, 1.0F, 7.0F, 1.0F, cubeDeformationZero)
                        .texOffs(0, 34).addBox(-20.5F, -8.0F, 2.0F, 1.0F, 8.0F, 2.0F, cubeDeformationZero)
                        .texOffs(58, 25).addBox(-2.5F, -8.0F, 2.0F, 1.0F, 8.0F, 2.0F, cubeDeformationZero)
                        .texOffs(14, 21).addBox(-20.5F, -9.0F, 4.0F, 1.0F, 9.0F, 2.0F, cubeDeformationZero)
                        .texOffs(20, 21).addBox(-2.5F, -9.0F, 4.0F, 1.0F, 9.0F, 2.0F, cubeDeformationZero)
                        .texOffs(0, 21).addBox(-20.5F, -10.0F, 6.0F, 1.0F, 10.0F, 2.0F, cubeDeformationZero)
                        .texOffs(6, 21).addBox(-2.5F, -10.0F, 6.0F, 1.0F, 10.0F, 2.0F, cubeDeformationZero)
                        .texOffs(36, 60).addBox(-20.5F, -11.0F, 8.0F, 1.0F, 11.0F, 1.0F, cubeDeformationZero)
                        .texOffs(40, 60).addBox(-2.5F, -11.0F, 8.0F, 1.0F, 11.0F, 1.0F, cubeDeformationZero)
                        .texOffs(56, 57).addBox(-20.5F, -12.0F, 9.0F, 1.0F, 12.0F, 1.0F, cubeDeformationZero)
                        .texOffs(60, 11).addBox(-2.5F, -12.0F, 9.0F, 1.0F, 12.0F, 1.0F, cubeDeformationZero)
                        .texOffs(28, 46).addBox(-20.5F, -15.0F, 10.0F, 1.0F, 15.0F, 1.0F, cubeDeformationZero)
                        .texOffs(32, 47).addBox(-2.5F, -15.0F, 10.0F, 1.0F, 15.0F, 1.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(-11.0F, 0.0F, 6.0F, -3.1416F, 0.0F, 3.1416F)
                );
            }

            {
                PartDefinition out2 = cloak.addOrReplaceChild("out2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

                out2.addOrReplaceChild(
                    "out2_r1", CubeListBuilder.create().texOffs(6, 34).addBox(-19.5F, -21.0F, 9.0F, 1.0F, 9.0F, 1.0F, cubeDeformationZero)
                        .texOffs(48, 62).addBox(-3.5F, -21.0F, 9.0F, 1.0F, 9.0F, 1.0F, cubeDeformationZero)
                        .texOffs(44, 60).addBox(-19.5F, -21.0F, 8.0F, 1.0F, 10.0F, 1.0F, cubeDeformationZero)
                        .texOffs(60, 44).addBox(-3.5F, -21.0F, 8.0F, 1.0F, 10.0F, 1.0F, cubeDeformationZero)
                        .texOffs(36, 47).addBox(-19.5F, -21.0F, 6.0F, 1.0F, 11.0F, 2.0F, cubeDeformationZero)
                        .texOffs(42, 47).addBox(-3.5F, -21.0F, 6.0F, 1.0F, 11.0F, 2.0F, cubeDeformationZero)
                        .texOffs(16, 56).addBox(-19.5F, -21.0F, 5.0F, 1.0F, 12.0F, 1.0F, cubeDeformationZero)
                        .texOffs(56, 44).addBox(-3.5F, -21.0F, 5.0F, 1.0F, 12.0F, 1.0F, cubeDeformationZero)
                        .texOffs(48, 47).addBox(-19.5F, -21.0F, 4.0F, 1.0F, 14.0F, 1.0F, cubeDeformationZero)
                        .texOffs(52, 47).addBox(-3.5F, -21.0F, 4.0F, 1.0F, 14.0F, 1.0F, cubeDeformationZero)
                        .texOffs(20, 46).addBox(-19.5F, -21.0F, 3.0F, 1.0F, 16.0F, 1.0F, cubeDeformationZero)
                        .texOffs(24, 46).addBox(-3.5F, -21.0F, 3.0F, 1.0F, 16.0F, 1.0F, cubeDeformationZero)
                        .texOffs(28, 21).addBox(-18.5F, -21.0F, 2.0F, 15.0F, 5.0F, 1.0F, cubeDeformationZero)
                        .texOffs(8, 56).addBox(-19.5F, -16.0F, 2.0F, 1.0F, 13.0F, 1.0F, cubeDeformationZero)
                        .texOffs(12, 56).addBox(-3.5F, -16.0F, 2.0F, 1.0F, 13.0F, 1.0F, cubeDeformationZero)
                        .texOffs(0, 0).addBox(-18.5F, -16.0F, 2.0F, 15.0F, 11.0F, 1.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(-11.0F, 0.0F, 6.0F, -3.1416F, 0.0F, 3.1416F)
                );
            }

            {
                PartDefinition top1 = cloak.addOrReplaceChild("top1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

                top1.addOrReplaceChild(
                    "top1_r1", CubeListBuilder.create().texOffs(24, 36).addBox(-15.5F, -23.0F, 3.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(39, 11).addBox(-7.5F, -23.0F, 3.0F, 1.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(45, 38).addBox(-16.5F, -22.0F, 2.0F, 11.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(32, 0).addBox(-19.5F, -22.0F, 3.0F, 5.0F, 1.0F, 8.0F, cubeDeformationZero)
                        .texOffs(32, 27).addBox(-7.5F, -22.0F, 3.0F, 5.0F, 1.0F, 8.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(-11.0F, 0.0F, 6.0F, -3.1416F, 0.0F, 3.1416F)
                );
            }

            {
                PartDefinition front = cloak.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

                front.addOrReplaceChild(
                    "front_r1", CubeListBuilder.create().texOffs(34, 40).addBox(-10.5F, -20.0F, 10.0F, 2.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(34, 42).addBox(-13.5F, -20.0F, 10.0F, 2.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(0, 45).addBox(-13.5F, -22.0F, 10.0F, 2.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(11, 46).addBox(-10.5F, -22.0F, 10.0F, 2.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(32, 9).addBox(-18.5F, -21.0F, 10.0F, 15.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(36, 5).addBox(-16.5F, -20.0F, 10.0F, 1.0F, 2.0F, 1.0F, cubeDeformationZero)
                        .texOffs(28, 40).addBox(-6.5F, -20.0F, 10.0F, 1.0F, 2.0F, 1.0F, cubeDeformationZero)
                        .texOffs(28, 35).addBox(-17.5F, -20.0F, 10.0F, 1.0F, 4.0F, 1.0F, cubeDeformationZero)
                        .texOffs(36, 0).addBox(-5.5F, -20.0F, 10.0F, 1.0F, 4.0F, 1.0F, cubeDeformationZero)
                        .texOffs(28, 27).addBox(-18.5F, -20.0F, 10.0F, 1.0F, 5.0F, 1.0F, cubeDeformationZero)
                        .texOffs(32, 27).addBox(-4.5F, -20.0F, 10.0F, 1.0F, 5.0F, 1.0F, cubeDeformationZero)
                        .texOffs(0, 56).addBox(-19.5F, -21.0F, 10.0F, 1.0F, 13.0F, 1.0F, cubeDeformationZero)
                        .texOffs(4, 56).addBox(-3.5F, -21.0F, 10.0F, 1.0F, 13.0F, 1.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(-11.0F, 0.0F, 6.0F, -3.1416F, 0.0F, 3.1416F)
                );
            }

            {
                PartDefinition top2 = cloak.addOrReplaceChild("top2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

                top2.addOrReplaceChild(
                    "top2_r1", CubeListBuilder.create().texOffs(4, 21).addBox(-16.5F, -25.0F, 11.0F, 1.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(18, 21).addBox(-6.5F, -25.0F, 11.0F, 1.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(34, 36).addBox(-16.5F, -25.0F, 2.0F, 1.0F, 2.0F, 9.0F, cubeDeformationZero)
                        .texOffs(0, 45).addBox(-6.5F, -25.0F, 2.0F, 1.0F, 2.0F, 9.0F, cubeDeformationZero)
                        .texOffs(45, 36).addBox(-16.5F, -25.0F, 1.0F, 11.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(45, 40).addBox(-15.5F, -24.0F, 2.0F, 9.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(45, 42).addBox(-15.5F, -23.0F, 2.0F, 9.0F, 1.0F, 1.0F, cubeDeformationZero)
                        .texOffs(34, 36).addBox(-7.5F, -25.0F, 11.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(38, 36).addBox(-15.5F, -25.0F, 11.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(39, 15).addBox(-14.5F, -24.0F, 11.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero)
                        .texOffs(40, 11).addBox(-8.5F, -24.0F, 11.0F, 1.0F, 3.0F, 1.0F, cubeDeformationZero),
                    PartPose.offsetAndRotation(-11.0F, 0.0F, 6.0F, -3.1416F, 0.0F, 3.1416F)
                );
            }
        }

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.cloak);
    }

}
