package com.haruhifanclub.mods.haruhicore.server.command;

import static net.minecraft.command.Commands.literal;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;

public class ServerCommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
            literal("haruhicore")
                .executes(
                    (ctx) -> {
                        return Command.SINGLE_SUCCESS;
                    }
                )
        );
    }
}
