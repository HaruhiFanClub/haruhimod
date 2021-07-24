package com.haruhifanclub.mods.haruhicore.server.command;

import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;
import java.util.Collection;
import com.haruhifanclub.mods.haruhicore.client.network.TriggerCrashPacket;
import com.haruhifanclub.mods.haruhicore.common.network.PacketHandler;
import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.GameProfileArgument;
import net.minecraft.entity.player.ServerPlayerEntity;

public class ServerCommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
            literal("haruhicore")
                .executes(
                    (ctx) -> {
                        return Command.SINGLE_SUCCESS;
                    }
                ).then(
                    literal("crash")
                        .requires((commandSource) -> {
                            return commandSource.hasPermission(4);
                        })
                        .then(
                            argument("targets", GameProfileArgument.gameProfile())
                                .executes(
                                    (ctx) -> {
                                        Collection<GameProfile> targets = GameProfileArgument.getGameProfiles(ctx, "targets");
                                        for (GameProfile gameprofile : targets) {
                                            ServerPlayerEntity player = ctx.getSource().getServer().getPlayerList().getPlayer(gameprofile.getId());
                                            PacketHandler.sendTo(player, new TriggerCrashPacket());
                                        }
                                        return Command.SINGLE_SUCCESS;
                                    }
                                )
                        )
                )
        );
    }
}
