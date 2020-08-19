package com.talp1.talpsadditions.entity.MoleEntity;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MoleModel<T extends MoleEntity> extends AgeableModel<T> {
    private final ModelRenderer Full_Body;
    private final ModelRenderer Body;
    private final ModelRenderer Head;
    private final ModelRenderer Nose;
    private final ModelRenderer Left_front_leg;
    private final ModelRenderer Right_front_leg;
    private final ModelRenderer Left_back_leg;
    private final ModelRenderer Right_back_leg;
    private final ModelRenderer Tail;

    public MoleModel() {
        textureWidth = 32;
        textureHeight = 32;

        Full_Body = new ModelRenderer(this);
        Full_Body.setRotationPoint(0.0F, 24.0F, 0.0F);


        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, -2.0F, 0.0F);
        Full_Body.addChild(Body);
        setRotationAngle(Body, 0.0F, 3.1416F, 0.0F);
        Body.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -4.5F, 6.0F, 4.0F, 9.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setRotationPoint(-0.0833F, -2.547F, -4.722F);
        Full_Body.addChild(Head);
        setRotationAngle(Head, 0.1222F, 3.1416F, 0.0F);
        Head.setTextureOffset(0, 13).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

        Nose = new ModelRenderer(this);
        Nose.setRotationPoint(-0.1083F, -0.8661F, 18.7838F);
        Full_Body.addChild(Nose);
        setRotationAngle(Nose, 0.1309F, 3.1416F, 0.0F);
        Nose.setTextureOffset(3, 5).addBox(-0.5F, 1.0255F, 24.1114F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Left_front_leg = new ModelRenderer(this);
        Left_front_leg.setRotationPoint(3.75F, -0.1F, -3.75F);
        Full_Body.addChild(Left_front_leg);
        Left_front_leg.setTextureOffset(0, 2).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Right_front_leg = new ModelRenderer(this);
        Right_front_leg.setRotationPoint(3.75F, -0.1F, -3.75F);
        Full_Body.addChild(Right_front_leg);
        Right_front_leg.setTextureOffset(3, 3).addBox(-7.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Left_back_leg = new ModelRenderer(this);
        Left_back_leg.setRotationPoint(3.75F, -0.1F, -3.75F);
        Full_Body.addChild(Left_back_leg);
        Left_back_leg.setTextureOffset(0, 4).addBox(-1.0F, -1.0F, 6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Right_back_leg = new ModelRenderer(this);
        Right_back_leg.setRotationPoint(3.75F, -0.1F, -3.75F);
        Full_Body.addChild(Right_back_leg);
        Right_back_leg.setTextureOffset(3, 1).addBox(-7.5F, -1.0F, 6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Tail = new ModelRenderer(this);
        Tail.setRotationPoint(0.0F, -2.5F, 4.5F);
        Full_Body.addChild(Tail);
        setRotationAngle(Tail, 0.0F, 3.1416F, 0.0F);
        Tail.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
    }

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//previously the render function, render code was moved to a method below
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of();
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.Full_Body);
	}
}