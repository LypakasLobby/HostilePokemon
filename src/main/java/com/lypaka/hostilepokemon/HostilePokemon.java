package com.lypaka.hostilepokemon;

import com.lypaka.hostilepokemon.Listeners.EntityAttributeModificationListener;
import com.lypaka.lypakautils.ConfigurationLoaders.BasicConfigManager;
import com.lypaka.lypakautils.ConfigurationLoaders.ConfigUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("hostilepokemon")
public class HostilePokemon {

    public static final String MOD_ID = "hostilepokemon";
    public static final String MOD_NAME = "HostilePokemon";
    public static final Logger logger = LogManager.getLogger(MOD_NAME);
    public static BasicConfigManager configManager;

    public HostilePokemon() {

        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(EntityAttributeModificationListener::onEntityModification); // Fucking weird I HAVE to do it this way, but oh well

        Path dir = ConfigUtils.checkDir(Paths.get("./config/hostilepokemon"));
        String[] files = new String[]{"hostilepokemon.conf"};
        configManager = new BasicConfigManager(files, dir, HostilePokemon.class, MOD_NAME, MOD_ID, logger);
        configManager.init();

    }

}
