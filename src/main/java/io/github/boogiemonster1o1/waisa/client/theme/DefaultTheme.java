package io.github.boogiemonster1o1.waisa.client.theme;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.render.DiffuseLighting;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DefaultTheme extends Theme {
	public static final DefaultTheme INSTANCE = new DefaultTheme();

	private DefaultTheme() {
	}

	@Override
	public void renderBackground(int x, int y, int width, int height) {
		GlStateManager.disableRescaleNormal();
		DiffuseLighting.disable();
		GlStateManager.disableLighting();
		GlStateManager.disableDepthTest();
		this.zOffset = 300.0f;
		int n = 0xF0100010;
		this.fillGradient(x - 3, y - 4, x + width + 3, y - 3, n, n);
		this.fillGradient(x - 3, y + height + 3, x + width + 3, y + height + 4, n, n);
		this.fillGradient(x - 3, y - 3, x + width + 3, y + height + 3, n, n);
		this.fillGradient(x - 4, y - 3, x - 3, y + height + 3, n, n);
		this.fillGradient(x + width + 3, y - 3, x + width + 4, y + height + 3, n, n);
		int o = 0x505000FF;
		int p = (o & 0xFEFEFE) >> 1 | o & 0xFF000000;
		this.fillGradient(x - 3, y - 3 + 1, x - 3 + 1, y + height + 3 - 1, o, p);
		this.fillGradient(x + width + 2, y - 3 + 1, x + width + 3, y + height + 3 - 1, o, p);
		this.fillGradient(x - 3, y - 3, x + width + 3, y - 3 + 1, o, o);
		this.fillGradient(x - 3, y + height + 2, x + width + 3, y + height + 3, p, p);
		this.zOffset = 0.0f;
		GlStateManager.enableLighting();
		GlStateManager.enableDepthTest();
		DiffuseLighting.enableNormally();
		GlStateManager.enableRescaleNormal();
	}
}
