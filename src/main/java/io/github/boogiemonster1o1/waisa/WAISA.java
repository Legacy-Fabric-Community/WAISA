package io.github.boogiemonster1o1.waisa;

import net.fabricmc.api.ModInitializer;

import net.legacyfabric.fabric.api.logger.v1.Logger;

public class WAISA implements ModInitializer {
	public static final Logger LOGGER = Logger.get("WAISA");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing WAISA");
	}
}
