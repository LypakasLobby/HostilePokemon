package com.lypaka.hostilepokemon.API;

import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

/**
 * Called when the server attempts to make a Pokemon hostile towards a player
 * Can modify the attack damage and the attack speed
 * Canceling the event cancels the Pokemon becoming hostile
 */
@Cancelable
public class SetHostileEvent extends Event {

    private final ServerPlayerEntity player;
    private final PixelmonEntity pixelmon;
    private double attackDamage;
    private double attackSpeed;
    private double movementSpeed;

    public SetHostileEvent (ServerPlayerEntity player, PixelmonEntity pixelmon, double attackDamage, double attackSpeed, double movementSpeed) {

        this.player = player;
        this.pixelmon = pixelmon;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.movementSpeed = movementSpeed;

    }

    public ServerPlayerEntity getPlayer() {

        return this.player;

    }

    public PixelmonEntity getPixelmon() {

        return this.pixelmon;

    }

    public double getAttackDamage() {

        return this.attackDamage;

    }

    public void setAttackDamage (double dmg) {

        this.attackDamage = dmg;

    }

    public double getAttackSpeed() {

        return this.attackSpeed;

    }

    public void setAttackSpeed (double spd) {

        this.attackSpeed = spd;

    }

    public double getMovementSpeed() {

        return movementSpeed;

    }

    public void setMovementSpeed (double spd) {

        this.movementSpeed = spd;

    }

}
