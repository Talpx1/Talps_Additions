package com.talp1.talpsadditions.entity.WalkingFungus;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WalkingFungusModel <T extends WalkingFungusEntity> extends AgeableModel<T> {
	private final ModelRenderer WalkingFungus;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer l_arm;
	private final ModelRenderer r_arm;
	private final ModelRenderer l_foot;
	private final ModelRenderer r_foot;
	private final ModelRenderer top;

	public WalkingFungusModel() {
		textureWidth = 32;
		textureHeight = 32;

		WalkingFungus = new ModelRenderer(this);
		WalkingFungus.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -8.0F, 0.0F);
		WalkingFungus.addChild(head);
		head.setTextureOffset(18, 9).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -3.0F, 0.0F);
		WalkingFungus.addChild(body);
		body.setTextureOffset(16, 16).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		l_arm = new ModelRenderer(this);
		l_arm.setRotationPoint(-1.5F, -4.5F, 0.0F);
		WalkingFungus.addChild(l_arm);
		l_arm.setTextureOffset(3, 3).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		r_arm = new ModelRenderer(this);
		r_arm.setRotationPoint(1.5F, -4.5F, 0.0F);
		WalkingFungus.addChild(r_arm);
		r_arm.setTextureOffset(0, 0).addBox(0.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		l_foot = new ModelRenderer(this);
		l_foot.setRotationPoint(0.75F, -0.25F, -1.25F);
		WalkingFungus.addChild(l_foot);
		l_foot.setTextureOffset(0, 6).addBox(-2.0F, -0.75F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		r_foot = new ModelRenderer(this);
		r_foot.setRotationPoint(-0.75F, -0.5F, -1.5F);
		WalkingFungus.addChild(r_foot);
		r_foot.setTextureOffset(4, 0).addBox(1.0F, -0.5F, -0.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		top = new ModelRenderer(this);
		top.setRotationPoint(0.5F, -7.0F, -0.5F);
		WalkingFungus.addChild(top);
		top.setTextureOffset(0, 0).addBox(-4.5F, -1.0F, -3.5F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		top.setTextureOffset(0, 9).addBox(-3.5F, -2.0F, -2.5F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		top.setTextureOffset(0, 16).addBox(-2.5F, -2.3F, -1.5F, 4.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.r_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.6F * limbSwingAmount / 1.0F;
		this.l_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount / 1.0F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		WalkingFungus.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of();
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.WalkingFungus);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}