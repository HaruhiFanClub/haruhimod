package com.haruhifanclub.mods.haruhicore.server.command;

import static net.minecraft.commands.Commands.literal;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import org.auioc.mods.arnicalib.server.command.impl.VersionCommand;
import net.minecraft.commands.CommandSourceStack;

public final class ServerCommandRegistry {

    public static final CommandNode<CommandSourceStack> NODE = literal(HaruhiCore.MOD_ID).build();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        NODE.addChild(literal("version").executes((ctx) -> VersionCommand.getModVersion(ctx, HaruhiCore.MAIN_VERSION, HaruhiCore.FULL_VERSION, HaruhiCore.MOD_NAME)).build());

        dispatcher.register(literal(HaruhiCore.MOD_ID).redirect(NODE));
        org.auioc.mods.arnicalib.server.command.ServerCommandRegistry.getRootNode(dispatcher).addChild(NODE);
    }

}
