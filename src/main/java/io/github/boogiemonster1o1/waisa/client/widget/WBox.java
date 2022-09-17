package io.github.boogiemonster1o1.waisa.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.platform.GlStateManager;
import io.github.boogiemonster1o1.waisa.client.RenderManager;

import net.minecraft.client.MinecraftClient;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class WBox extends WWidget {
	private final List<WWidget> children;

	public WBox() {
		super(0, 0);
		this.children = new ArrayList<>();
	}

	public void addChild(WWidget widget) {
		this.children.add(widget);
	}

	public void layout() {
		for (WWidget widget: children) {
			int newWidth = widget.getX() + widget.getWidth();
			int newHeight =  widget.getY() + widget.getHeight();
			this.setSize(Math.max(this.getWidth(), newWidth), Math.max(this.getHeight(), newHeight));
		}
	}

	public void render(MinecraftClient client, float tickDelta) {
		RenderManager.INSTANCE.theme.renderBackground(this.x, this.y, this.width, this.height);
		GlStateManager.pushMatrix();
		GlStateManager.translatef(this.x, this.y, 0);
		this.children.forEach(widget -> widget.render(client, tickDelta));
		GlStateManager.popMatrix();
	}
}
