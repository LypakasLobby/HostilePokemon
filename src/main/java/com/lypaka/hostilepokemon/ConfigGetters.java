package com.lypaka.hostilepokemon;

public class ConfigGetters {

    public static double spawnChance;

    public static void load() {

        spawnChance = HostilePokemon.configManager.getConfigNode(0, "Spawn-Chance").getDouble();

    }

}
