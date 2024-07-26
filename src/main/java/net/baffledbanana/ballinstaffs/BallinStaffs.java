package net.baffledbanana.ballinstaffs;

import net.baffledbanana.ballinstaffs.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BallinStaffs implements ModInitializer {
	public static final String MOD_ID = "ballinstaffs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
	}
}