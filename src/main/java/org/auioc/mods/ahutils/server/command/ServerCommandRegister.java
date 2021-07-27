package org.auioc.mods.ahutils.server.command;

import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;
import java.util.Collection;
import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import org.auioc.mods.ahutils.common.network.PacketHandler;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.GameProfileArgument;
import net.minecraft.entity.player.ServerPlayerEntity;

public class ServerCommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
            literal("ahutils")
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
                                            PacketHandler.sendTo(player, new org.auioc.mods.ahutils.client.network.TriggerCrashPacket());
                                        }
                                        return Command.SINGLE_SUCCESS;
                                    }
                                )
                        )
                )
        );
    }
}
