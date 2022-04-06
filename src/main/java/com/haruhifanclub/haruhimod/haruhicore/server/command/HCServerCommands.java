package com.haruhifanclub.haruhimod.haruhicore.server.command;

import static net.minecraft.commands.Commands.literal;
import com.haruhifanclub.haruhimod.haruhicore.HaruhiCore;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import org.auioc.mcmod.arnicalib.common.command.impl.VersionCommand;
import org.auioc.mcmod.arnicalib.server.command.AHServerCommands;
import net.minecraft.commands.CommandSourceStack;

public final class HCServerCommands {

    public static final CommandNode<CommandSourceStack> NODE = literal(HaruhiCore.MOD_ID).build();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        VersionCommand.addVersionNode(NODE, HaruhiCore.class);

        dispatcher.register(literal(HaruhiCore.MOD_ID).redirect(NODE));
        AHServerCommands.getAHNode(dispatcher).addChild(NODE);
    }

}
