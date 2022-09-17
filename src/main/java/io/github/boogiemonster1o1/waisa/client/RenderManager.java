package io.github.boogiemonster1o1.waisa.client;

import io.github.boogiemonster1o1.waisa.client.theme.DefaultTheme;
import io.github.boogiemonster1o1.waisa.client.theme.Theme;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.Window;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.BlockHitResult;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class RenderManager extends DrawableHelper {
	public static final RenderManager INSTANCE = new RenderManager();
	public Theme theme = DefaultTheme.INSTANCE;
	public Window window;
	private Session session;

	private RenderManager() {
	}

	public void render(MinecraftClient client, float tickDelta) {
		this.window = new Window(client);
		if (this.session != null) {
			this.session.box.render(client, tickDelta);
		}
	}

	public void tick(ClientWorld world) {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client.player == null) {
			return;
		}
		if (client.result == null || client.result.type == BlockHitResult.Type.MISS) {
			this.session = null;
			return;
		}
		if (this.session != null && this.session.isResultEqual(client.result, world)) {
			return;
		}
		this.session = new Session(client.result, world);
	}
}
