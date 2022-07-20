package com.haruhifanclub.haruhimod.haruhiism.server.command;

import static net.minecraft.commands.Commands.literal;
import org.auioc.mcmod.arnicalib.common.command.impl.VersionCommand;
import org.auioc.mcmod.arnicalib.server.command.AHServerCommands;
import com.haruhifanclub.haruhimod.haruhiism.Haruhiism;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.commands.CommandSourceStack;

public final class HCServerCommands {

    public static final CommandNode<CommandSourceStack> NODE = literal(Haruhiism.MOD_ID).build();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        VersionCommand.addVersionNode(NODE, Haruhiism.class);

        dispatcher.register(literal(Haruhiism.MOD_ID).redirect(NODE));
        AHServerCommands.getAHNode(dispatcher).addChild(NODE);
    }

}
