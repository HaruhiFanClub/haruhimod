package org.auioc.mods.addrlimiter.command;

import static net.minecraft.command.Commands.literal;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;


public class CommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
            literal("addrlimiter")
                .executes((ctx) -> {
                    return Command.SINGLE_SUCCESS;
                })
                .then(
                    literal("dump")
                        .requires((commandSource) -> {
                            return commandSource.hasPermission(4);
                        }).executes((ctx) -> {
                            return Command.SINGLE_SUCCESS;
                        })
                )
        );
    }
}
