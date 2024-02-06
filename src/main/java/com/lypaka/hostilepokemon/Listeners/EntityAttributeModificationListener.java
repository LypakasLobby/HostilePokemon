package com.lypaka.hostilepokemon.Listeners;

import com.pixelmonmod.pixelmon.init.registry.EntityRegistration;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityAttributeModificationListener {

    @SubscribeEvent
    public static void onEntityModification (EntityAttributeModificationEvent event) {

        event.add(EntityRegistration.PIXELMON.get(), Attributes.ATTACK_DAMAGE, 2.0);
        event.add(EntityRegistration.PIXELMON.get(), Attributes.ATTACK_SPEED);
        event.add(EntityRegistration.PIXELMON.get(), Attributes.ATTACK_KNOCKBACK);

    }

}
