package org.auioc.mods.ahutils.server.command;

import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.GameProfileArgument;

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
                            literal("client")
                                .then(
                                    argument("targets", GameProfileArgument.gameProfile())
                                        .executes((ctx) -> ServerCommandHandlers.triggerClientCrash(ctx, 0))
                                        .then(
                                            argument("mode", IntegerArgumentType.integer(0))
                                                .executes((ctx) -> ServerCommandHandlers.triggerClientCrash(ctx, ctx.getArgument("mode", Integer.class)))
                                        )
                                )
                        )
                )
        );
    }
}
