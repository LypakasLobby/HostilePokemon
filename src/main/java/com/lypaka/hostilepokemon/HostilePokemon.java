package com.lypaka.hostilepokemon;

import com.lypaka.hostilepokemon.Listeners.EntityAttributeModificationListener;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("hostilepokemon")
public class HostilePokemon {

    public static final String MOD_ID = "hostilepokemon";
    public static final String MOD_NAME = "HostilePokemon";
    public static final Logger logger = LogManager.getLogger(MOD_NAME);

    public HostilePokemon() {

        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(EntityAttributeModificationListener::onEntityModification); // Fucking weird I HAVE to do it this way, but oh well

    }

}
