package io.github.boogiemonster1o1.waisa.client.widget;

import net.minecraft.client.MinecraftClient;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

// Inspired by LibGUI
@Environment(EnvType.CLIENT)
public class WWidget {
	protected int x;
	protected int y;
	protected int width = 16;
	protected int height = 16;

	public WWidget(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void render(MinecraftClient client, float tickDelta) {
	}
}
