package com.lypaka.hostilepokemon.API;

import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.eventbus.api.Event;

public class PokemonKilledPlayerEvent extends Event {

    private final ServerPlayerEntity player;
    private final PixelmonEntity pixelmon;

    public PokemonKilledPlayerEvent (ServerPlayerEntity player, PixelmonEntity pixelmon) {

        this.player = player;
        this.pixelmon = pixelmon;

    }

    public ServerPlayerEntity getPlayer() {

        return this.player;

    }

    public PixelmonEntity getPixelmon() {

        return this.pixelmon;

    }

}
