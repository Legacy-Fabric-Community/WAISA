package io.github.boogiemonster1o1.waisa.client;

import java.util.Objects;

import io.github.boogiemonster1o1.waisa.client.widget.WBlock;
import io.github.boogiemonster1o1.waisa.client.widget.WBox;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.BlockHitResult;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Session {
	private final BlockHitResult result;
	protected final WBox box = new WBox();

	public Session(BlockHitResult result, ClientWorld world) {
		this.result = result;
		if (result.type == BlockHitResult.Type.BLOCK) {
			this.box.addChild(new WBlock(world.getBlockState(result.getBlockPos()), 0, 0));
		}
		this.box.layout();
		int anchorX = (int) ((RenderManager.INSTANCE.window.getScaledWidth() - this.box.getWidth()) / 2);
		this.box.setX(anchorX);
		int anchorY = 4;
		this.box.setY(anchorY);
	}

	public boolean isResultEqual(BlockHitResult other, ClientWorld world) {
		if (other.type != this.result.type) {
			return false;
		}
		if (other.type == BlockHitResult.Type.ENTITY) {
			return other.entity == this.result.entity;
		}
		return other.getBlockPos().equals(this.result.getBlockPos()) &&
				Objects.equals(
						world.getBlockState(other.getBlockPos()),
						world.getBlockState(this.result.getBlockPos())
				);
	}
}
