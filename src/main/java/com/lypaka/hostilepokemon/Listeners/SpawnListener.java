package com.lypaka.hostilepokemon.Listeners;

import com.lypaka.hostilepokemon.API.SetHostileEvent;
import com.lypaka.hostilepokemon.ConfigGetters;
import com.pixelmonmod.pixelmon.api.events.spawning.SpawnEvent;
import com.pixelmonmod.pixelmon.api.util.helpers.RandomHelper;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import com.pixelmonmod.pixelmon.spawning.PlayerTrackingSpawner;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SpawnListener {

    @SubscribeEvent
    public void onSpawn (SpawnEvent event) {

        if (ConfigGetters.spawnChance <= 0) return;
        if (RandomHelper.getRandomChance(ConfigGetters.spawnChance)) {

            if (event.action.getOrCreateEntity() instanceof PixelmonEntity) {

                if (event.spawner instanceof PlayerTrackingSpawner) {

                    ServerPlayerEntity player = ((PlayerTrackingSpawner) event.spawner).getTrackedPlayer();
                    PixelmonEntity pixelmon = (PixelmonEntity) event.action.getOrCreateEntity();
                    double defaultAtk = pixelmon.getAttributeValue(Attributes.ATTACK_DAMAGE);
                    double defaultSpd = pixelmon.getAttributeValue(Attributes.ATTACK_SPEED);
                    SetHostileEvent hostileEvent = new SetHostileEvent(player, pixelmon, defaultAtk, defaultSpd);
                    MinecraftForge.EVENT_BUS.post(hostileEvent);
                    if (!hostileEvent.isCanceled()) {

                        pixelmon.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(hostileEvent.getAttackDamage());
                        pixelmon.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(hostileEvent.getAttackSpeed());
                        pixelmon.setAttackTarget(player);
                        pixelmon.goalSelector.addGoal(0, new MeleeAttackGoal(pixelmon, 1.5, true));

                    }

                }

            }

        }

    }

}
