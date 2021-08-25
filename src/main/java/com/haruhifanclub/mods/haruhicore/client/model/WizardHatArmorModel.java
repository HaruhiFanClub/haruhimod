package com.haruhifanclub.mods.haruhicore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WizardHatArmorModel extends BipedModel<LivingEntity> {
    private final ModelRenderer bb_hat;

    private final ModelRenderer f0; // cube_r00 ~ r08
    private final ModelRenderer f1; // cube_r09
    private final ModelRenderer f2; // cube_r10 ~ r16
    private final ModelRenderer f3; // cube_r17 ~ r23
    private final ModelRenderer f4; // cube_r24 ~ r30
    private final ModelRenderer f5; // cube_r31
    private final ModelRenderer f6; // f6

    private final ModelRenderer cube_r00;
    private final ModelRenderer cube_r01;
    private final ModelRenderer cube_r02;
    private final ModelRenderer cube_r03;
    private final ModelRenderer cube_r04;
    private final ModelRenderer cube_r05;
    private final ModelRenderer cube_r08;
    private final ModelRenderer cube_r09;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer cube_r26;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;

    public WizardHatArmorModel() {
        super(1.0F);

        texWidth = 128;
        texHeight = 128;

        bb_hat = new ModelRenderer(this);
        bb_hat.setPos(0.0F, 0.0F, 0.0F);


        f0 = new ModelRenderer(this);
        f0.setPos(0.0F, -5.0F, 0.0F); // ~ F0
        bb_hat.addChild(f0);
        f0.texOffs(65, 18).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        f0.texOffs(99, 97).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        f0.texOffs(93, 43).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        f0.texOffs(26, 83).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        f0.texOffs(66, 14).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        f0.texOffs(65, 1).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        f0.texOffs(63, 82).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        f0.texOffs(93, 20).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        f0.texOffs(72, 94).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        f0.texOffs(65, 13).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        f0.texOffs(66, 33).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r00 = new ModelRenderer(this);
        cube_r00.setPos(0.0F, 0.0F, 0.0F);
        f0.addChild(cube_r00);
        BaseModel.setRotationAngle(cube_r00, 0.0F, 3.1416F, -3.1416F);
        cube_r00.texOffs(38, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r00.texOffs(52, 6).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r00.texOffs(0, 0).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r00.texOffs(81, 49).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r00.texOffs(69, 27).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r00.texOffs(43, 48).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r00.texOffs(40, 36).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r00.texOffs(16, 38).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r00.texOffs(69, 38).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r00.texOffs(13, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r00.texOffs(48, 30).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r01 = new ModelRenderer(this);
        cube_r01.setPos(0.0F, 0.0F, 0.0F);
        f0.addChild(cube_r01);
        BaseModel.setRotationAngle(cube_r01, 0.0F, -1.5708F, -3.1416F);
        cube_r01.texOffs(44, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r01.texOffs(0, 53).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r01.texOffs(0, 9).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r01.texOffs(83, 59).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r01.texOffs(71, 60).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r01.texOffs(52, 0).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r01.texOffs(19, 51).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r01.texOffs(69, 49).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r01.texOffs(75, 82).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r01.texOffs(36, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r01.texOffs(52, 19).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r02 = new ModelRenderer(this);
        cube_r02.setPos(0.0F, 0.0F, 0.0F);
        f0.addChild(cube_r02);
        BaseModel.setRotationAngle(cube_r02, 0.0F, 0.0F, -3.1416F);
        cube_r02.texOffs(16, 49).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r02.texOffs(56, 49).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r02.texOffs(0, 19).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r02.texOffs(39, 85).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r02.texOffs(72, 71).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r02.texOffs(0, 53).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r02.texOffs(52, 13).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r02.texOffs(27, 72).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r02.texOffs(84, 69).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r02.texOffs(52, 96).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r02.texOffs(54, 31).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r03 = new ModelRenderer(this);
        cube_r03.setPos(0.0F, 0.0F, 0.0F);
        f0.addChild(cube_r03);
        BaseModel.setRotationAngle(cube_r03, 0.0F, 1.5708F, -3.1416F);
        cube_r03.texOffs(50, 13).addBox(-6.0F, 0.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r03.texOffs(0, 58).addBox(-7.0F, 0.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r03.texOffs(0, 28).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r03.texOffs(50, 86).addBox(-9.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r03.texOffs(51, 74).addBox(-10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r03.texOffs(56, 37).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r03.texOffs(53, 25).addBox(-12.0F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r03.texOffs(39, 73).addBox(-13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r03.texOffs(13, 86).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r03.texOffs(97, 77).addBox(-15.0F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r03.texOffs(56, 54).addBox(-16.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r04 = new ModelRenderer(this);
        cube_r04.setPos(0.0F, 0.0F, 0.0F);
        f0.addChild(cube_r04);
        BaseModel.setRotationAngle(cube_r04, 0.0F, 1.5708F, 0.0F);
        cube_r04.texOffs(32, 59).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r04.texOffs(58, 61).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r04.texOffs(62, 93).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r04.texOffs(0, 88).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r04.texOffs(0, 77).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r04.texOffs(32, 60).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r04.texOffs(56, 49).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r04.texOffs(14, 75).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r04.texOffs(86, 79).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r04.texOffs(97, 89).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r04.texOffs(45, 60).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r05 = new ModelRenderer(this);
        cube_r05.setPos(0.0F, 0.0F, 0.0F);
        f0.addChild(cube_r05);
        BaseModel.setRotationAngle(cube_r05, 0.0F, 3.1416F, 0.0F);
        cube_r05.texOffs(13, 61).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r05.texOffs(65, 0).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r05.texOffs(25, 94).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r05.texOffs(90, 0).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r05.texOffs(79, 11).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r05.texOffs(58, 62).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r05.texOffs(45, 61).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r05.texOffs(78, 0).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r05.texOffs(86, 89).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r05.texOffs(0, 98).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r05.texOffs(0, 65).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        cube_r08 = new ModelRenderer(this);
        cube_r08.setPos(0.0F, 0.0F, 0.0F);
        f0.addChild(cube_r08);
        BaseModel.setRotationAngle(cube_r08, 0.0F, -1.5708F, 0.0F);
        cube_r08.texOffs(50, 65).addBox(-6.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r08.texOffs(13, 65).addBox(-7.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        cube_r08.texOffs(94, 53).addBox(-8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r08.texOffs(92, 33).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r08.texOffs(81, 22).addBox(-10.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r08.texOffs(0, 65).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r08.texOffs(13, 63).addBox(-12.0F, -1.0F, 0.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        cube_r08.texOffs(80, 38).addBox(-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r08.texOffs(91, 10).addBox(-14.0F, -1.0F, 0.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
        cube_r08.texOffs(83, 99).addBox(-15.0F, -1.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r08.texOffs(65, 5).addBox(-16.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        f1 = new ModelRenderer(this);
        f1.setPos(0.0F, -5.0F, 0.0F); // ~ F1
        bb_hat.addChild(f1);
        f1.texOffs(104, 43).addBox(11.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        f1.texOffs(38, 17).addBox(10.0F, -2.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
        f1.texOffs(0, 38).addBox(9.0F, -2.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
        f1.texOffs(20, 19).addBox(8.0F, -2.0F, -8.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
        f1.texOffs(0, 19).addBox(7.0F, -2.0F, -9.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
        f1.texOffs(95, 69).addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        f1.texOffs(26, 63).addBox(6.0F, -2.0F, -10.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        f1.texOffs(13, 53).addBox(5.0F, -2.0F, -11.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        f1.texOffs(32, 51).addBox(5.0F, -2.0F, 4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        f1.texOffs(34, 104).addBox(4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        f1.texOffs(104, 20).addBox(4.0F, -2.0F, -11.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        f1.texOffs(38, 23).addBox(3.0F, -2.0F, -11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        f1.texOffs(38, 17).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        f1.texOffs(24, 103).addBox(0.0F, -2.0F, 7.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
        f1.texOffs(102, 10).addBox(0.0F, -2.0F, -12.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

        cube_r09 = new ModelRenderer(this);
        cube_r09.setPos(0.0F, 0.0F, 0.0F);
        f1.addChild(cube_r09);
        BaseModel.setRotationAngle(cube_r09, 0.0F, 3.1416F, 0.0F);
        cube_r09.texOffs(94, 62).addBox(0.0F, -2.0F, -12.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
        cube_r09.texOffs(63, 74).addBox(0.0F, -2.0F, 7.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
        cube_r09.texOffs(38, 6).addBox(3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        cube_r09.texOffs(38, 0).addBox(3.0F, -2.0F, -11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        cube_r09.texOffs(10, 104).addBox(4.0F, -2.0F, -11.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        cube_r09.texOffs(103, 30).addBox(4.0F, -2.0F, 5.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        cube_r09.texOffs(20, 27).addBox(5.0F, -2.0F, 4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r09.texOffs(20, 19).addBox(5.0F, -2.0F, -11.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r09.texOffs(20, 8).addBox(6.0F, -2.0F, -10.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r09.texOffs(20, 0).addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        cube_r09.texOffs(0, 0).addBox(7.0F, -2.0F, -9.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
        cube_r09.texOffs(20, 0).addBox(8.0F, -2.0F, -8.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
        cube_r09.texOffs(24, 36).addBox(9.0F, -2.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
        cube_r09.texOffs(38, 0).addBox(10.0F, -2.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
        cube_r09.texOffs(45, 96).addBox(11.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        f2 = new ModelRenderer(this);
        f2.setPos(0.0F, -5.0F, 0.0F); // ~ F2
        bb_hat.addChild(f2);
        f2.texOffs(78, 0).addBox(-7.0F, -4.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        f2.texOffs(86, 82).addBox(-6.0F, -4.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        f2.texOffs(30, 86).addBox(-5.0F, -4.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(0.0F, -1.0F, 0.0F);
        f2.addChild(cube_r10);
        BaseModel.setRotationAngle(cube_r10, 0.0F, 3.1416F, -3.1416F);
        cube_r10.texOffs(80, 38).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r10.texOffs(79, 13).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r10.texOffs(71, 29).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(0.0F, -1.0F, 0.0F);
        f2.addChild(cube_r11);
        BaseModel.setRotationAngle(cube_r11, 0.0F, -1.5708F, -3.1416F);
        cube_r11.texOffs(81, 49).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r11.texOffs(81, 26).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r11.texOffs(71, 61).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(0.0F, -1.0F, 0.0F);
        f2.addChild(cube_r12);
        BaseModel.setRotationAngle(cube_r12, 0.0F, 0.0F, -3.1416F);
        cube_r12.texOffs(83, 16).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r12.texOffs(75, 82).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r12.texOffs(39, 72).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(0.0F, -1.0F, 0.0F);
        f2.addChild(cube_r13);
        BaseModel.setRotationAngle(cube_r13, 0.0F, 1.5708F, -3.1416F);
        cube_r13.texOffs(38, 84).addBox(-5.0F, 0.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r13.texOffs(83, 60).addBox(-6.0F, 0.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r13.texOffs(51, 73).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(0.0F, -1.0F, 0.0F);
        f2.addChild(cube_r14);
        BaseModel.setRotationAngle(cube_r14, 0.0F, 1.5708F, 0.0F);
        cube_r14.texOffs(84, 71).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r14.texOffs(84, 41).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r14.texOffs(26, 75).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(0.0F, -1.0F, 0.0F);
        f2.addChild(cube_r15);
        BaseModel.setRotationAngle(cube_r15, 0.0F, 3.1416F, 0.0F);
        cube_r15.texOffs(61, 85).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r15.texOffs(50, 85).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r15.texOffs(0, 77).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(0.0F, -1.0F, 0.0F);
        f2.addChild(cube_r16);
        BaseModel.setRotationAngle(cube_r16, 0.0F, -1.5708F, 0.0F);
        cube_r16.texOffs(24, 86).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r16.texOffs(67, 85).addBox(-6.0F, -3.0F, 2.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r16.texOffs(12, 77).addBox(-7.0F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        f3 = new ModelRenderer(this);
        f3.setPos(0.0F, -6.0F, 0.0F); // ~ F3
        bb_hat.addChild(f3);
        f3.texOffs(74, 74).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        f3.texOffs(0, 70).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        f3.texOffs(34, 38).addBox(-4.0F, -6.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(0.0F, -1.0F, 0.0F);
        f3.addChild(cube_r17);
        BaseModel.setRotationAngle(cube_r17, 0.0F, 3.1416F, -3.1416F);
        cube_r17.texOffs(38, 6).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r17.texOffs(22, 53).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r17.texOffs(0, 38).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(0.0F, -1.0F, 0.0F);
        f3.addChild(cube_r18);
        BaseModel.setRotationAngle(cube_r18, 0.0F, -1.5708F, -3.1416F);
        cube_r18.texOffs(16, 38).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r18.texOffs(35, 63).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r18.texOffs(8, 38).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setPos(0.0F, -1.0F, 0.0F);
        f3.addChild(cube_r19);
        BaseModel.setRotationAngle(cube_r19, 0.0F, 0.0F, -3.1416F);
        cube_r19.texOffs(38, 17).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r19.texOffs(45, 65).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r19.texOffs(32, 51).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setPos(0.0F, -1.0F, 0.0F);
        f3.addChild(cube_r20);
        BaseModel.setRotationAngle(cube_r20, 0.0F, 1.5708F, -3.1416F);
        cube_r20.texOffs(22, 38).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r20.texOffs(66, 26).addBox(-5.0F, 2.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r20.texOffs(13, 53).addBox(-6.0F, 2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setPos(0.0F, 0.0F, 0.0F);
        f3.addChild(cube_r21);
        BaseModel.setRotationAngle(cube_r21, 0.0F, 1.5708F, 0.0F);
        cube_r21.texOffs(38, 23).addBox(-4.0F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r21.texOffs(58, 66).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r21.texOffs(53, 37).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r22 = new ModelRenderer(this);
        cube_r22.setPos(0.0F, 0.0F, 0.0F);
        f3.addChild(cube_r22);
        BaseModel.setRotationAngle(cube_r22, 0.0F, 3.1416F, 0.0F);
        cube_r22.texOffs(28, 38).addBox(-4.0F, -6.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r22.texOffs(69, 38).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r22.texOffs(61, 37).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setPos(0.0F, -1.0F, 0.0F);
        f3.addChild(cube_r23);
        BaseModel.setRotationAngle(cube_r23, 0.0F, -1.5708F, 0.0F);
        cube_r23.texOffs(38, 30).addBox(-4.0F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r23.texOffs(69, 49).addBox(-5.0F, -5.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r23.texOffs(26, 63).addBox(-6.0F, -5.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        f4 = new ModelRenderer(this);
        f4.setPos(0.0F, -7.0F, 0.0F); // ~ F4
        bb_hat.addChild(f4);
        f4.texOffs(29, 27).addBox(-5.0F, -8.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        f4.texOffs(10, 28).addBox(-4.0F, -8.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setPos(0.0F, -1.0F, 0.0F);
        f4.addChild(cube_r24);
        BaseModel.setRotationAngle(cube_r24, 0.0F, 3.1416F, -3.1416F);
        cube_r24.texOffs(0, 0).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r24.texOffs(20, 0).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setPos(0.0F, -1.0F, 0.0F);
        f4.addChild(cube_r25);
        BaseModel.setRotationAngle(cube_r25, 0.0F, -1.5708F, -3.1416F);
        cube_r25.texOffs(0, 9).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r25.texOffs(20, 8).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r26 = new ModelRenderer(this);
        cube_r26.setPos(0.0F, -1.0F, 0.0F);
        f4.addChild(cube_r26);
        BaseModel.setRotationAngle(cube_r26, 0.0F, 0.0F, -3.1416F);
        cube_r26.texOffs(10, 0).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r26.texOffs(20, 19).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r27 = new ModelRenderer(this);
        cube_r27.setPos(0.0F, -1.0F, 0.0F);
        f4.addChild(cube_r27);
        BaseModel.setRotationAngle(cube_r27, 0.0F, 1.5708F, -3.1416F);
        cube_r27.texOffs(10, 9).addBox(-4.0F, 4.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r27.texOffs(20, 27).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r28 = new ModelRenderer(this);
        cube_r28.setPos(0.0F, -1.0F, 0.0F);
        f4.addChild(cube_r28);
        BaseModel.setRotationAngle(cube_r28, 0.0F, 1.5708F, 0.0F);
        cube_r28.texOffs(0, 19).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r28.texOffs(29, 0).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r29 = new ModelRenderer(this);
        cube_r29.setPos(0.0F, -1.0F, 0.0F);
        f4.addChild(cube_r29);
        BaseModel.setRotationAngle(cube_r29, 0.0F, 3.1416F, 0.0F);
        cube_r29.texOffs(10, 19).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r29.texOffs(29, 8).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r30 = new ModelRenderer(this);
        cube_r30.setPos(0.0F, -1.0F, 0.0F);
        f4.addChild(cube_r30);
        BaseModel.setRotationAngle(cube_r30, 0.0F, -1.5708F, 0.0F);
        cube_r30.texOffs(0, 28).addBox(-4.0F, -7.0F, 1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r30.texOffs(29, 19).addBox(-5.0F, -7.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        f5 = new ModelRenderer(this);
        f5.setPos(0.0F, -7.0F, 0.0F); // ~ F5
        bb_hat.addChild(f5);
        f5.texOffs(52, 13).addBox(-4.0F, -10.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        f5.texOffs(71, 13).addBox(-3.0F, -10.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        f5.texOffs(13, 70).addBox(-3.0F, -10.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        f5.texOffs(69, 55).addBox(-2.0F, -10.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        f5.texOffs(58, 25).addBox(-2.0F, -10.0F, 2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        f5.texOffs(45, 17).addBox(-1.0F, -10.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        f5.texOffs(45, 6).addBox(-1.0F, -10.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r31 = new ModelRenderer(this);
        cube_r31.setPos(0.0F, -1.0F, 0.0F);
        f5.addChild(cube_r31);
        BaseModel.setRotationAngle(cube_r31, 0.0F, 3.1416F, 0.0F);
        cube_r31.texOffs(45, 0).addBox(-1.0F, -9.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r31.texOffs(40, 36).addBox(-1.0F, -9.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r31.texOffs(52, 25).addBox(-2.0F, -9.0F, 2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r31.texOffs(47, 51).addBox(-2.0F, -9.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r31.texOffs(6, 48).addBox(-3.0F, -9.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r31.texOffs(0, 48).addBox(-3.0F, -9.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r31.texOffs(52, 0).addBox(-4.0F, -9.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

        f6 = new ModelRenderer(this);
        f6.setPos(0.0F, -5.0F, 0.0F); // ~ F6
        bb_hat.addChild(f6);
        BaseModel.setRotationAngle(f6, 0.0F, 3.1416F, 0.0F);
        f6.texOffs(38, 30).addBox(2.0F, -13.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        f6.texOffs(62, 102).addBox(1.0F, -14.0F, -3.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);
        f6.texOffs(101, 0).addBox(0.0F, -15.0F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
        f6.texOffs(53, 37).addBox(-1.0F, -16.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
        f6.texOffs(0, 38).addBox(-2.0F, -16.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
        f6.texOffs(28, 38).addBox(-3.0F, -16.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        f6.texOffs(16, 38).addBox(-4.0F, -16.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        f6.texOffs(40, 36).addBox(-5.0F, -15.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
        f6.texOffs(41, 51).addBox(-6.0F, -14.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        f6.texOffs(44, 30).addBox(-7.0F, -13.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        f6.texOffs(40, 43).addBox(-8.0F, -12.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        f6.texOffs(38, 0).addBox(-9.0F, -11.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_hat.copyFrom(head);
        matrixStack.pushPose();
        bb_hat.render(matrixStack, buffer, packedLight, packedOverlay);
        matrixStack.popPose();
    }

}
