package com.lypaka.hostilepokemon.Commands;

import com.lypaka.hostilepokemon.ConfigGetters;
import com.lypaka.hostilepokemon.HostilePokemon;
import com.lypaka.lypakautils.FancyText;
import com.lypaka.lypakautils.MiscHandlers.PermissionHandler;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;

public class ReloadCommand {

    public ReloadCommand (CommandDispatcher<CommandSource> dispatcher) {

        for (String a : HostilePokemonCommand.ALIASES) {

            dispatcher.register(
                    Commands.literal(a)
                            .then(
                                    Commands.literal("reload")
                                            .executes(c -> {

                                                if (c.getSource().getEntity() instanceof ServerPlayerEntity) {

                                                    ServerPlayerEntity player = (ServerPlayerEntity) c.getSource().getEntity();
                                                    if (!PermissionHandler.hasPermission(player, "hostilepokemon.command.admin")) {

                                                        player.sendMessage(FancyText.getFormattedText("&cYou don't have permission to use this command!"), player.getUniqueID());
                                                        return 0;

                                                    }

                                                }

                                                HostilePokemon.configManager.load();
                                                ConfigGetters.load();
                                                c.getSource().sendFeedback(FancyText.getFormattedText("&aSuccessfully reloaded HostilePokemon!"), true);
                                                return 0;

                                            })
                            )
            );

        }

    }

}
