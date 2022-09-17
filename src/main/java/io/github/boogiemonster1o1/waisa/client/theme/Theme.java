package io.github.boogiemonster1o1.waisa.client.theme;

import net.minecraft.client.gui.DrawableHelper;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public abstract class Theme extends DrawableHelper {
	public abstract void renderBackground(int x, int y, int width, int height);
}
