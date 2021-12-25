package com.haruhifanclub.mods.haruhicore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WizardHatArmorModel extends HumanoidModel<LivingEntity> {
    private final ModelRenderer bb_hat;

    private final ModelRenderer f0;
    private final ModelRenderer f1;
    private final ModelRenderer f2;
    private final ModelRenderer f3;
    private final ModelRenderer f4;
    private final ModelRenderer f5;
    private final ModelRenderer f6;

    private final ModelRenderer cube_f0_r0;
    private final ModelRenderer cube_f0_r1;
    private final ModelRenderer cube_f0_r2;
    private final ModelRenderer cube_f0_r3;
    private final ModelRenderer cube_f0_r4;
    private final ModelRenderer cube_f0_r5;
    private final ModelRenderer cube_f0_r6;
    private final ModelRenderer cube_f0_r7;

    private final ModelRenderer cube_f1_r0;
    private final ModelRenderer cube_f1_r1;

    private final ModelRenderer cube_f2_r0;
    private final ModelRenderer cube_f2_r1;
    private final ModelRenderer cube_f2_r2;
    private final ModelRenderer cube_f2_r3;
    private final ModelRenderer cube_f2_r4;
    private final ModelRenderer cube_f2_r5;
    private final ModelRenderer cube_f2_r6;
    private final ModelRenderer cube_f2_r7;


    private final ModelRenderer cube_f3_r0;
    private final ModelRenderer cube_f3_r1;
    private final ModelRenderer cube_f3_r2;
    private final ModelRenderer cube_f3_r3;
    private final ModelRenderer cube_f3_r4;
    private final ModelRenderer cube_f3_r5;
    private final ModelRenderer cube_f3_r6;
    private final ModelRenderer cube_f3_r7;

    private final ModelRenderer cube_f4_r0;
    private final ModelRenderer cube_f4_r1;
    private final ModelRenderer cube_f4_r2;
    private final ModelRenderer cube_f4_r3;
    private final ModelRenderer cube_f4_r4;
    private final ModelRenderer cube_f4_r5;
    private final ModelRenderer cube_f4_r6;
    private final ModelRenderer cube_f4_r7;

    private final ModelRenderer cube_f5_r0;
    private final ModelRenderer cube_f5_r1;

    private final ModelRenderer cube_f6_r0;


    public WizardHatArmorModel() {
        super(1.0F);

        texWidth = 128;
        texHeight = 128;

        bb_hat = new ModelRenderer(this);
        bb_hat.setPos(0.0F, 0.0F, 0.0F);


        f0 = new ModelRenderer(this);
        f1 = new ModelRenderer(this);
        f2 = new ModelRenderer(this);
        f3 = new ModelRenderer(this);
        f4 = new ModelRenderer(this);
        f5 = new ModelRenderer(this);
        f6 = new ModelRenderer(this);

        f0.setPos(0.0F, -5.0F - 4.62F, 0.0F);
        f1.setPos(0.0F, -5.0F - 4.62F, 0.0F);
        f2.setPos(0.0F, -5.0F - 4.62F, 0.0F);
        f3.setPos(0.0F, -6.0F - 4.62F, 0.0F);
        f4.setPos(0.0F, -7.0F - 4.62F, 0.0F);
        f5.setPos(0.0F, -7.0F - 4.62F, 0.0F);
        f6.setPos(0.0F, -5.0F - 4.62F, 0.0F);

        bb_hat.addChild(f0);
        bb_hat.addChild(f1);
        bb_hat.addChild(f2);
        bb_hat.addChild(f3);
        bb_hat.addChild(f4);
        bb_hat.addChild(f5);
        bb_hat.addChild(f6);


        { // F0
            cube_f0_r0 = new ModelRenderer(this);
            cube_f0_r0.setPos(0.0F, 0.0F, 0.0F);
            cube_f0_r0.texOffs(65, 18).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r0.texOffs(99, 97).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r0.texOffs(93, 43).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r0.texOffs(26, 83).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r0.texOffs(66, 14).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r0.texOffs(65, 1).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r0.texOffs(63, 82).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r0.texOffs(93, 20).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r0.texOffs(72, 94).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r0.texOffs(65, 13).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r0.texOffs(66, 33).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            f0.addChild(cube_f0_r0);

            cube_f0_r1 = new ModelRenderer(this);
            cube_f0_r1.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f0_r1, 0.0F, 3.1416F, -3.1416F);
            cube_f0_r1.texOffs(38, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            cube_f0_r1.texOffs(52, 6).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r1.texOffs(0, 0).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r1.texOffs(81, 49).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r1.texOffs(69, 27).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r1.texOffs(43, 48).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r1.texOffs(40, 36).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r1.texOffs(16, 38).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r1.texOffs(69, 38).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r1.texOffs(13, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r1.texOffs(48, 30).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            f0.addChild(cube_f0_r1);

            cube_f0_r2 = new ModelRenderer(this);
            cube_f0_r2.setPos(0.0F, 0.0F, 0.0F);
            f0.addChild(cube_f0_r2);
            BaseModel.setRotationAngle(cube_f0_r2, 0.0F, -1.5708F, -3.1416F);
            cube_f0_r2.texOffs(44, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            cube_f0_r2.texOffs(0, 53).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r2.texOffs(0, 9).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r2.texOffs(83, 59).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r2.texOffs(71, 60).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r2.texOffs(52, 0).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r2.texOffs(19, 51).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r2.texOffs(69, 49).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r2.texOffs(75, 82).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r2.texOffs(36, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r2.texOffs(52, 19).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

            cube_f0_r3 = new ModelRenderer(this);
            cube_f0_r3.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f0_r3, 0.0F, 0.0F, -3.1416F);
            cube_f0_r3.texOffs(16, 49).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            cube_f0_r3.texOffs(56, 49).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r3.texOffs(0, 19).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r3.texOffs(39, 85).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r3.texOffs(72, 71).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r3.texOffs(0, 53).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r3.texOffs(52, 13).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r3.texOffs(27, 72).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r3.texOffs(84, 69).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r3.texOffs(52, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r3.texOffs(54, 31).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            f0.addChild(cube_f0_r3);

            cube_f0_r4 = new ModelRenderer(this);
            cube_f0_r4.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f0_r4, 0.0F, 1.5708F, -3.1416F);
            cube_f0_r4.texOffs(50, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            cube_f0_r4.texOffs(0, 58).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r4.texOffs(0, 28).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r4.texOffs(50, 86).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r4.texOffs(51, 74).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r4.texOffs(56, 37).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r4.texOffs(53, 25).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r4.texOffs(39, 73).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r4.texOffs(13, 86).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r4.texOffs(97, 77).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r4.texOffs(56, 54).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            f0.addChild(cube_f0_r4);

            cube_f0_r5 = new ModelRenderer(this);
            cube_f0_r5.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f0_r5, 0.0F, 1.5708F, 0.0F);
            cube_f0_r5.texOffs(32, 59).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            cube_f0_r5.texOffs(58, 61).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r5.texOffs(62, 93).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r5.texOffs(0, 88).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r5.texOffs(0, 77).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r5.texOffs(32, 60).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r5.texOffs(56, 49).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r5.texOffs(14, 75).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r5.texOffs(86, 79).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r5.texOffs(97, 89).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r5.texOffs(45, 60).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            f0.addChild(cube_f0_r5);

            cube_f0_r6 = new ModelRenderer(this);
            cube_f0_r6.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f0_r6, 0.0F, 3.1416F, 0.0F);
            cube_f0_r6.texOffs(13, 61).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            cube_f0_r6.texOffs(65, 0).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r6.texOffs(25, 94).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r6.texOffs(90, 0).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r6.texOffs(79, 11).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r6.texOffs(58, 62).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r6.texOffs(45, 61).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r6.texOffs(78, 0).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r6.texOffs(86, 89).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r6.texOffs(0, 98).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r6.texOffs(0, 65).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            f0.addChild(cube_f0_r6);

            cube_f0_r7 = new ModelRenderer(this);
            cube_f0_r7.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f0_r7, 0.0F, -1.5708F, 0.0F);
            cube_f0_r7.texOffs(50, 65).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
            cube_f0_r7.texOffs(13, 65).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f0_r7.texOffs(94, 53).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
            cube_f0_r7.texOffs(92, 33).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r7.texOffs(81, 22).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r7.texOffs(0, 65).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r7.texOffs(13, 63).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
            cube_f0_r7.texOffs(80, 38).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
            cube_f0_r7.texOffs(91, 10).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
            cube_f0_r7.texOffs(83, 99).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f0_r7.texOffs(65, 5).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            f0.addChild(cube_f0_r7);
        }

        { // F1
            cube_f1_r0 = new ModelRenderer(this);
            cube_f1_r0.setPos(0.0F, 0.0F, 0.0F);
            cube_f1_r0.texOffs(104, 43).addBox(11.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
            cube_f1_r0.texOffs(38, 17).addBox(10.0F, -2.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
            cube_f1_r0.texOffs(0, 38).addBox(9.0F, -2.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
            cube_f1_r0.texOffs(20, 19).addBox(8.0F, -2.0F, -8.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
            cube_f1_r0.texOffs(0, 19).addBox(7.0F, -2.0F, -9.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
            cube_f1_r0.texOffs(95, 69).addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r0.texOffs(26, 63).addBox(6.0F, -2.0F, -10.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r0.texOffs(13, 53).addBox(5.0F, -2.0F, -11.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r0.texOffs(32, 51).addBox(5.0F, -2.0F, 4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r0.texOffs(34, 104).addBox(4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
            cube_f1_r0.texOffs(104, 20).addBox(4.0F, -2.0F, -11.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
            cube_f1_r0.texOffs(38, 23).addBox(3.0F, -2.0F, -11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
            cube_f1_r0.texOffs(38, 17).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
            cube_f1_r0.texOffs(24, 103).addBox(0.0F, -2.0F, 7.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
            cube_f1_r0.texOffs(102, 10).addBox(0.0F, -2.0F, -12.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
            f1.addChild(cube_f1_r0);

            cube_f1_r1 = new ModelRenderer(this);
            cube_f1_r1.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f1_r1, 0.0F, 3.1416F, 0.0F);
            cube_f1_r1.texOffs(94, 62).addBox(0.0F, -2.0F, -12.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
            cube_f1_r1.texOffs(63, 74).addBox(0.0F, -2.0F, 7.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
            cube_f1_r1.texOffs(38, 6).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
            cube_f1_r1.texOffs(38, 0).addBox(3.0F, -2.0F, -11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
            cube_f1_r1.texOffs(10, 104).addBox(4.0F, -2.0F, -11.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
            cube_f1_r1.texOffs(103, 30).addBox(4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
            cube_f1_r1.texOffs(20, 27).addBox(5.0F, -2.0F, 4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r1.texOffs(20, 19).addBox(5.0F, -2.0F, -11.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r1.texOffs(20, 8).addBox(6.0F, -2.0F, -10.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r1.texOffs(20, 0).addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
            cube_f1_r1.texOffs(0, 0).addBox(7.0F, -2.0F, -9.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
            cube_f1_r1.texOffs(20, 0).addBox(8.0F, -2.0F, -8.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
            cube_f1_r1.texOffs(24, 36).addBox(9.0F, -2.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
            cube_f1_r1.texOffs(38, 0).addBox(10.0F, -2.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
            cube_f1_r1.texOffs(45, 96).addBox(11.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
            f1.addChild(cube_f1_r1);
        }

        { // F2
            cube_f2_r0 = new ModelRenderer(this);
            cube_f2_r0.setPos(0.0F, 0.0F, 0.0F);
            cube_f2_r0.texOffs(78, 0).addBox(-7.0F, -4.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f2_r0.texOffs(86, 82).addBox(-6.0F, -4.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r0.texOffs(30, 86).addBox(-5.0F, -4.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f2.addChild(cube_f2_r0);

            cube_f2_r1 = new ModelRenderer(this);
            cube_f2_r1.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f2_r1, 0.0F, 3.1416F, -3.1416F);
            cube_f2_r1.texOffs(80, 38).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r1.texOffs(79, 13).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r1.texOffs(71, 29).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f2.addChild(cube_f2_r1);

            cube_f2_r2 = new ModelRenderer(this);
            cube_f2_r2.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f2_r2, 0.0F, -1.5708F, -3.1416F);
            cube_f2_r2.texOffs(81, 49).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r2.texOffs(81, 26).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r2.texOffs(71, 61).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f2.addChild(cube_f2_r2);

            cube_f2_r3 = new ModelRenderer(this);
            cube_f2_r3.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f2_r3, 0.0F, 0.0F, -3.1416F);
            cube_f2_r3.texOffs(83, 16).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r3.texOffs(75, 82).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r3.texOffs(39, 72).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f2.addChild(cube_f2_r3);

            cube_f2_r4 = new ModelRenderer(this);
            cube_f2_r4.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f2_r4, 0.0F, 1.5708F, -3.1416F);
            cube_f2_r4.texOffs(38, 84).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r4.texOffs(83, 60).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r4.texOffs(51, 73).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f2.addChild(cube_f2_r4);

            cube_f2_r5 = new ModelRenderer(this);
            cube_f2_r5.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f2_r5, 0.0F, 1.5708F, 0.0F);
            cube_f2_r5.texOffs(84, 71).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r5.texOffs(84, 41).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r5.texOffs(26, 75).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f2.addChild(cube_f2_r5);

            cube_f2_r6 = new ModelRenderer(this);
            cube_f2_r6.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f2_r6, 0.0F, 3.1416F, 0.0F);
            cube_f2_r6.texOffs(61, 85).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r6.texOffs(50, 85).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r6.texOffs(0, 77).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f2.addChild(cube_f2_r6);

            cube_f2_r7 = new ModelRenderer(this);
            cube_f2_r7.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f2_r7, 0.0F, -1.5708F, 0.0F);
            cube_f2_r7.texOffs(24, 86).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r7.texOffs(67, 85).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f2_r7.texOffs(12, 77).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f2.addChild(cube_f2_r7);
        }

        { // F3
            cube_f3_r0 = new ModelRenderer(this);
            cube_f3_r0.setPos(0.0F, 0.0F, 0.0F);
            cube_f3_r0.texOffs(74, 74).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f3_r0.texOffs(0, 70).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r0.texOffs(34, 38).addBox(-4.0F, -6.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            f3.addChild(cube_f3_r0);

            cube_f3_r1 = new ModelRenderer(this);
            cube_f3_r1.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f3_r1, 0.0F, 3.1416F, -3.1416F);
            cube_f3_r1.texOffs(38, 6).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            cube_f3_r1.texOffs(22, 53).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r1.texOffs(0, 38).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f3.addChild(cube_f3_r1);

            cube_f3_r2 = new ModelRenderer(this);
            cube_f3_r2.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f3_r2, 0.0F, -1.5708F, -3.1416F);
            cube_f3_r2.texOffs(16, 38).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            cube_f3_r2.texOffs(35, 63).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r2.texOffs(8, 38).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f3.addChild(cube_f3_r2);

            cube_f3_r3 = new ModelRenderer(this);
            cube_f3_r3.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f3_r3, 0.0F, 0.0F, -3.1416F);
            cube_f3_r3.texOffs(38, 17).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            cube_f3_r3.texOffs(45, 65).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r3.texOffs(32, 51).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f3.addChild(cube_f3_r3);

            cube_f3_r4 = new ModelRenderer(this);
            cube_f3_r4.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f3_r4, 0.0F, 1.5708F, -3.1416F);
            cube_f3_r4.texOffs(22, 38).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            cube_f3_r4.texOffs(66, 26).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r4.texOffs(13, 53).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f3.addChild(cube_f3_r4);

            cube_f3_r5 = new ModelRenderer(this);
            cube_f3_r5.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f3_r5, 0.0F, 1.5708F, 0.0F);
            cube_f3_r5.texOffs(38, 23).addBox(-4.0F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            cube_f3_r5.texOffs(58, 66).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r5.texOffs(53, 37).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f3.addChild(cube_f3_r5);

            cube_f3_r6 = new ModelRenderer(this);
            cube_f3_r6.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f3_r6, 0.0F, 3.1416F, 0.0F);
            cube_f3_r6.texOffs(28, 38).addBox(-4.0F, -6.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            cube_f3_r6.texOffs(69, 38).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r6.texOffs(61, 37).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f3.addChild(cube_f3_r6);

            cube_f3_r7 = new ModelRenderer(this);
            cube_f3_r7.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f3_r7, 0.0F, -1.5708F, 0.0F);
            cube_f3_r7.texOffs(38, 30).addBox(-4.0F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            cube_f3_r7.texOffs(69, 49).addBox(-5.0F, -5.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f3_r7.texOffs(26, 63).addBox(-6.0F, -5.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f3.addChild(cube_f3_r7);
        }

        { // F4
            cube_f4_r0 = new ModelRenderer(this);
            cube_f4_r0.setPos(0.0F, 0.0F, 0.0F);
            cube_f4_r0.texOffs(29, 27).addBox(-5.0F, -8.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            cube_f4_r0.texOffs(10, 28).addBox(-4.0F, -8.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            f4.addChild(cube_f4_r0);

            cube_f4_r1 = new ModelRenderer(this);
            cube_f4_r1.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f4_r1, 0.0F, 3.1416F, -3.1416F);
            cube_f4_r1.texOffs(0, 0).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f4_r1.texOffs(20, 0).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f4.addChild(cube_f4_r1);

            cube_f4_r2 = new ModelRenderer(this);
            cube_f4_r2.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f4_r2, 0.0F, -1.5708F, -3.1416F);
            cube_f4_r2.texOffs(0, 9).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f4_r2.texOffs(20, 8).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f4.addChild(cube_f4_r2);

            cube_f4_r3 = new ModelRenderer(this);
            cube_f4_r3.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f4_r3, 0.0F, 0.0F, -3.1416F);
            cube_f4_r3.texOffs(10, 0).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f4_r3.texOffs(20, 19).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f4.addChild(cube_f4_r3);

            cube_f4_r4 = new ModelRenderer(this);
            cube_f4_r4.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f4_r4, 0.0F, 1.5708F, -3.1416F);
            cube_f4_r4.texOffs(10, 9).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f4_r4.texOffs(20, 27).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f4.addChild(cube_f4_r4);

            cube_f4_r5 = new ModelRenderer(this);
            cube_f4_r5.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f4_r5, 0.0F, 1.5708F, 0.0F);
            cube_f4_r5.texOffs(0, 19).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f4_r5.texOffs(29, 0).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f4.addChild(cube_f4_r5);

            cube_f4_r6 = new ModelRenderer(this);
            cube_f4_r6.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f4_r6, 0.0F, 3.1416F, 0.0F);
            cube_f4_r6.texOffs(10, 19).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f4_r6.texOffs(29, 8).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f4.addChild(cube_f4_r6);

            cube_f4_r7 = new ModelRenderer(this);
            cube_f4_r7.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f4_r7, 0.0F, -1.5708F, 0.0F);
            cube_f4_r7.texOffs(0, 28).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
            cube_f4_r7.texOffs(29, 19).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
            f4.addChild(cube_f4_r7);
        }

        { // F5
            cube_f5_r0 = new ModelRenderer(this);
            cube_f5_r0.setPos(0.0F, 0.0F, 0.0F);
            cube_f5_r0.texOffs(52, 13).addBox(-4.0F, -10.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
            cube_f5_r0.texOffs(71, 13).addBox(-3.0F, -10.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r0.texOffs(13, 70).addBox(-3.0F, -10.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r0.texOffs(69, 55).addBox(-2.0F, -10.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r0.texOffs(58, 25).addBox(-2.0F, -10.0F, 2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r0.texOffs(45, 17).addBox(-1.0F, -10.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
            cube_f5_r0.texOffs(45, 6).addBox(-1.0F, -10.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
            f5.addChild(cube_f5_r0);

            cube_f5_r1 = new ModelRenderer(this);
            cube_f5_r1.setPos(0.0F, -1.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f5_r1, 0.0F, 3.1416F, 0.0F);
            cube_f5_r1.texOffs(45, 0).addBox(-1.0F, -9.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
            cube_f5_r1.texOffs(40, 36).addBox(-1.0F, -9.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
            cube_f5_r1.texOffs(52, 25).addBox(-2.0F, -9.0F, 2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r1.texOffs(47, 51).addBox(-2.0F, -9.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r1.texOffs(6, 48).addBox(-3.0F, -9.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r1.texOffs(0, 48).addBox(-3.0F, -9.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f5_r1.texOffs(52, 0).addBox(-4.0F, -9.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
            f5.addChild(cube_f5_r1);
        }

        { // F6
            cube_f6_r0 = new ModelRenderer(this);
            cube_f6_r0.setPos(0.0F, 0.0F, 0.0F);
            BaseModel.setRotationAngle(cube_f6_r0, 0.0F, 3.1416F, 0.0F);
            cube_f6_r0.texOffs(38, 30).addBox(2.0F, -13.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
            cube_f6_r0.texOffs(62, 102).addBox(1.0F, -14.0F, -3.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);
            cube_f6_r0.texOffs(101, 0).addBox(0.0F, -15.0F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
            cube_f6_r0.texOffs(53, 37).addBox(-1.0F, -16.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
            cube_f6_r0.texOffs(0, 38).addBox(-2.0F, -16.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
            cube_f6_r0.texOffs(28, 38).addBox(-3.0F, -16.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
            cube_f6_r0.texOffs(16, 38).addBox(-4.0F, -16.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
            cube_f6_r0.texOffs(40, 36).addBox(-5.0F, -15.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
            cube_f6_r0.texOffs(41, 51).addBox(-6.0F, -14.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
            cube_f6_r0.texOffs(44, 30).addBox(-7.0F, -13.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f6_r0.texOffs(40, 43).addBox(-8.0F, -12.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
            cube_f6_r0.texOffs(38, 0).addBox(-9.0F, -11.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
            f6.addChild(cube_f6_r0);
        }
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_hat.copyFrom(head);
        matrixStack.pushPose();
        matrixStack.scale(0.66F, 0.66F, 0.66F);
        bb_hat.render(matrixStack, buffer, packedLight, packedOverlay);
        matrixStack.popPose();
    }

}
