package com.talp1.talpsadditions.entity.YetiEntity;// Made with Blockbench 3.6.6


import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.PolarBearRenderer;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.PolarBearModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.util.math.MathHelper;

public class YetiModel<T extends YetiEntity> extends AgeableModel<T>{
	private final ModelRenderer Yeti;
	private final ModelRenderer Left_leg;
	private final ModelRenderer Right_leg;
	private final ModelRenderer Right_foot;
	private final ModelRenderer Left_foot;
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Right_arm;
	private final ModelRenderer Left_arm;

	public YetiModel() {
		textureWidth = 128;
		textureHeight = 128;

		Yeti = new ModelRenderer(this);
		Yeti.setRotationPoint(0.0F, -1.75F, 0.0F);


		Left_leg = new ModelRenderer(this);
		Left_leg.setRotationPoint(8.0F, 10.5F, 2.0F);
		Yeti.addChild(Left_leg);
		Left_leg.setTextureOffset(76, 34).addBox(-3.0F, 0.25F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F, false);

		Left_foot = new ModelRenderer(this);
		Left_foot.setRotationPoint(0.2143F, 8.5F, 0.0714F);
		Left_leg.addChild(Left_foot);
		Left_foot.setTextureOffset(50, 40).addBox(-4.2143F, 4.75F, -7.0714F, 8.0F, 2.0F, 10.0F, 0.0F, false);
		Left_foot.setTextureOffset(70, 76).addBox(-4.2143F, 2.75F, -5.0714F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		Left_foot.setTextureOffset(24, 77).addBox(-3.2143F, 0.75F, -3.0714F, 6.0F, 2.0F, 6.0F, 0.0F, false);
		Left_foot.setTextureOffset(6, 10).addBox(2.7857F, 5.5F, -8.0714F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Left_foot.setTextureOffset(9, 5).addBox(0.7857F, 5.5F, -9.0714F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Left_foot.setTextureOffset(9, 0).addBox(-1.2143F, 5.5F, -9.0714F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Left_foot.setTextureOffset(0, 44).addBox(-4.2143F, 4.75F, -9.0714F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Right_leg = new ModelRenderer(this);
		Right_leg.setRotationPoint(-8.0F, 10.5F, 2.0F);
		Yeti.addChild(Right_leg);
		Right_leg.setTextureOffset(0, 77).addBox(-3.0F, 0.25F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F, false);

		Right_foot = new ModelRenderer(this);
		Right_foot.setRotationPoint(-0.2143F, 9.5F, 0.0714F);
		Right_leg.addChild(Right_foot);
		Right_foot.setTextureOffset(52, 52).addBox(-3.7857F, 3.75F, -7.0714F, 8.0F, 2.0F, 10.0F, 0.0F, false);
		Right_foot.setTextureOffset(76, 24).addBox(-3.7857F, 1.75F, -5.0714F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		Right_foot.setTextureOffset(78, 52).addBox(-2.7857F, -0.25F, -3.0714F, 6.0F, 2.0F, 6.0F, 0.0F, false);
		Right_foot.setTextureOffset(8, 49).addBox(-3.7857F, 4.5F, -8.0714F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Right_foot.setTextureOffset(6, 46).addBox(-1.7857F, 4.5F, -9.0714F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Right_foot.setTextureOffset(6, 42).addBox(0.2143F, 4.5F, -9.0714F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Right_foot.setTextureOffset(0, 48).addBox(2.2143F, 3.75F, -9.0714F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -1.75F, 1.0F);
		Yeti.addChild(Body);
		Body.setTextureOffset(0, 0).addBox(-11.5F, -12.5F, -7.5F, 23.0F, 25.0F, 15.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-1.0F, -14.25F, 1.0F);
		Yeti.addChild(Head);
		Head.setTextureOffset(0, 40).addBox(-8.5F, -10.0F, -6.0F, 19.0F, 10.0F, 12.0F, 0.0F, false);
		Head.setTextureOffset(61, 0).addBox(-8.5F, -3.0F, -7.0F, 19.0F, 3.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(50, 45).addBox(-7.5F, -4.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(6, 40).addBox(7.5F, -4.0F, -7.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 40).addBox(-10.5F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 10).addBox(10.5F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(50, 40).addBox(-10.5F, -12.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(8, 10).addBox(11.5F, -12.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		Right_arm = new ModelRenderer(this);
		Right_arm.setRotationPoint(-13.6667F, -9.4167F, 1.5F);
		Yeti.addChild(Right_arm);
		Right_arm.setTextureOffset(0, 5).addBox(-1.3333F, 15.1667F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		Right_arm.setTextureOffset(28, 62).addBox(-2.8333F, -3.8333F, -4.5F, 5.0F, 6.0F, 9.0F, 0.0F, false);
		Right_arm.setTextureOffset(76, 4).addBox(-1.8333F, 2.1667F, -3.5F, 4.0F, 13.0F, 7.0F, 0.0F, false);

		Left_arm = new ModelRenderer(this);
		Left_arm.setRotationPoint(13.6667F, -9.4167F, 1.5F);
		Yeti.addChild(Left_arm);
		Left_arm.setTextureOffset(0, 0).addBox(-1.6667F, 15.1667F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		Left_arm.setTextureOffset(0, 62).addBox(-2.1667F, -3.8333F, -4.5F, 5.0F, 6.0F, 9.0F, 0.0F, false);
		Left_arm.setTextureOffset(56, 64).addBox(-2.1667F, 2.1667F, -3.5F, 4.0F, 13.0F, 7.0F, 0.0F, false);
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
		return ImmutableList.of(this.Yeti);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.Left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / 1.0F;
		this.Right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.6F * limbSwingAmount / 1.0F;
		this.Left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount / 1.0F;
	}


}