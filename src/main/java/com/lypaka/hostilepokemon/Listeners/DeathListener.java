package com.lypaka.hostilepokemon.Listeners;

import com.lypaka.hostilepokemon.API.PlayerKilledPokemonEvent;
import com.lypaka.hostilepokemon.API.PokemonKilledPlayerEvent;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DeathListener {

    @SubscribeEvent
    public void onDeath (LivingDeathEvent event) {

        if (event.getEntityLiving() instanceof ServerPlayerEntity) {

            if (event.getSource().getTrueSource() instanceof PixelmonEntity) {

                ServerPlayerEntity player = (ServerPlayerEntity) event.getEntityLiving();
                PixelmonEntity pixelmon = (PixelmonEntity) event.getSource().getTrueSource();
                PokemonKilledPlayerEvent killEvent = new PokemonKilledPlayerEvent(player, pixelmon);
                MinecraftForge.EVENT_BUS.post(killEvent);

            }

        } else if (event.getEntityLiving() instanceof PixelmonEntity) {

            if (event.getSource().getTrueSource() instanceof ServerPlayerEntity) {

                ServerPlayerEntity player = (ServerPlayerEntity) event.getEntityLiving();
                PixelmonEntity pixelmon = (PixelmonEntity) event.getSource().getTrueSource();
                PlayerKilledPokemonEvent killEvent = new PlayerKilledPokemonEvent(player, pixelmon);
                MinecraftForge.EVENT_BUS.post(killEvent);

            }

        }

    }

}
