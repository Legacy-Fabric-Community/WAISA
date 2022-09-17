package io.github.boogiemonster1o1.waisa.client.widget;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.texture.SpriteAtlasTexture;

public class WBlock extends WWidget {
	private final BlockState state;

	public WBlock(BlockState state, int x, int y) {
		super(x, y);
		this.state = state;
		this.setSize(24, 24);
	}

	@Override
	public void render(MinecraftClient client, float tickDelta) {
		super.render(client, tickDelta);
		GlStateManager.pushMatrix();
		GlStateManager.enableTexture();
		GlStateManager.enableAlphaTest();
		GlStateManager.translatef(this.x, this.y, 0);
		MinecraftClient.getInstance().getTextureManager().bindTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEX);
		GlStateManager.scalef(16f, -16f, 16f);
		GlStateManager.translatef(0.5f, 0.5f, 0.5f);
//		GlStateManager.rotatef(45.0f, 1, 0, 0);
//		GlStateManager.rotatef(90.0f, 0, 0, 1);
		BlockRenderManager blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();
		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(770, 772);
		GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		GlStateManager.pushMatrix();
		blockRenderManager.renderBlockEntity(this.state, 1.0f);
		GlStateManager.popMatrix();
		GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		GlStateManager.disableTexture();
		GlStateManager.disableAlphaTest();
		GlStateManager.pushMatrix();
		GlStateManager.popMatrix();
		GlStateManager.popMatrix();
	}
}
