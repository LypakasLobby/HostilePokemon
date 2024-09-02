package com.lypaka.hostilepokemon.Listeners;

import com.lypaka.hostilepokemon.API.SetHostileEvent;
import com.lypaka.hostilepokemon.HostilePokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SmackListener {

    @SubscribeEvent
    public void onSmack (LivingAttackEvent event) {

        if (event.getSource().getTrueSource() instanceof ServerPlayerEntity) {

            ServerPlayerEntity player = (ServerPlayerEntity) event.getSource().getTrueSource();
            if (event.getEntityLiving() instanceof PixelmonEntity) {

                PixelmonEntity pixelmon = (PixelmonEntity) event.getEntityLiving();
                double defaultAtk = pixelmon.getAttributeValue(Attributes.ATTACK_DAMAGE);
                double defaultSpd = pixelmon.getAttributeValue(Attributes.ATTACK_SPEED);
                SetHostileEvent hostileEvent = new SetHostileEvent(player, pixelmon, defaultAtk, defaultSpd, 1.5);
                MinecraftForge.EVENT_BUS.post(hostileEvent);
                if (!hostileEvent.isCanceled()) {

                    HostilePokemon.setHostile(pixelmon, player, hostileEvent.getAttackDamage(), hostileEvent.getAttackSpeed(), hostileEvent.getMovementSpeed());

                }

            }

        }

    }

}
