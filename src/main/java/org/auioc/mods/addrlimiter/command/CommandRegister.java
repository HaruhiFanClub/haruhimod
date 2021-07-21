package org.auioc.mods.addrlimiter.command;

import static net.minecraft.command.Commands.literal;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;


public class CommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
            literal("addrlimiter").executes((ctx) -> {
                System.out.println("Addrlimiter\n");
                return Command.SINGLE_SUCCESS;
            })
        );
    }

}
