package com.haruhifanclub.mods.haruhicore.server.command;

import static net.minecraft.commands.Commands.literal;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.commands.CommandSourceStack;

public final class ServerCommandRegistry {

    public static final CommandNode<CommandSourceStack> NODE = literal(HaruhiCore.MOD_ID).build();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(literal(HaruhiCore.MOD_ID).redirect(NODE));
        org.auioc.mods.arnicalib.server.command.ServerCommandRegistry.getRootNode(dispatcher).addChild(NODE);
    }

}
