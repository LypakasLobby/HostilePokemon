package com.lypaka.hostilepokemon.Commands;

import com.lypaka.hostilepokemon.HostilePokemon;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = HostilePokemon.MOD_ID)
public class HostilePokemonCommand {

    public static final List<String> ALIASES = Arrays.asList("hostilepokemon", "hpkmn", "hostiles", "hospoke");

    @SubscribeEvent
    public static void onCommandRegistration (RegisterCommandsEvent event) {

        new ReloadCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());

    }

}
