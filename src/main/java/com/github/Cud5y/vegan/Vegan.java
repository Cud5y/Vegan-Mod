package com.github.Cud5y.vegan;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vegan implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Vegan Mod");

	@Override
	public void onInitialize() {
		LOGGER.info("Vegan mod by Cudsy has been initialized");
		Register.register();
	}

}
