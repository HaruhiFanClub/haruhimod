package com.haruhifanclub.haruhiism.server.command;

import static net.minecraft.commands.Commands.literal;
import org.auioc.mcmod.arnicalib.game.command.AHCommands;
import org.auioc.mcmod.arnicalib.game.command.node.VersionCommand;
import com.haruhifanclub.haruhiism.Haruhiism;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.commands.CommandSourceStack;

public final class HMServerCommands {

    public static final CommandNode<CommandSourceStack> NODE = literal(Haruhiism.MOD_ID).build();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        VersionCommand.addVersionNode(NODE, Haruhiism.class);

        dispatcher.register(literal(Haruhiism.MOD_ID).redirect(NODE));
        AHCommands.getServerNode(dispatcher).addChild(NODE);
    }

}
