package com.lypaka.hostilepokemon.Listeners;

import com.lypaka.hostilepokemon.HostilePokemon;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.config.PixelmonConfigProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

@Mod.EventBusSubscriber(modid = HostilePokemon.MOD_ID)
public class ServerStartedListener {

    @SubscribeEvent
    public static void onServerStarted (FMLServerStartedEvent event) {

        if (!PixelmonConfigProxy.getGeneral().isCanPokemonBeHit()) {

            HostilePokemon.logger.error("Detected that Pixelmon's config node for \"can Pokemon be hit\" is set to false!");
            HostilePokemon.logger.error("I'm pretty sure you're gonna wanna set that to true before using this mod, lol.");
            return;

        }
        MinecraftForge.EVENT_BUS.register(new DeathListener());
        MinecraftForge.EVENT_BUS.register(new SmackListener());
        Pixelmon.EVENT_BUS.register(new SpawnListener());

    }

}
