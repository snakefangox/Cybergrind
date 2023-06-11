package net.snakefangox.cybergrind;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cybergrind implements ModInitializer {
    public static final String MODID = "cybergrind";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        Things.register();
    }
}