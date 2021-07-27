package org.auioc.mods.ahutils.server.command;

import java.util.Collection;
import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.auioc.mods.ahutils.common.network.PacketHandler;
import org.auioc.mods.ahutils.utils.Loggers;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.GameProfileArgument;
import net.minecraft.entity.player.ServerPlayerEntity;

public abstract class ServerCommandHandlers {
    public static int triggerClientCrash(CommandContext<CommandSource> ctx, int mode) throws CommandSyntaxException {
        Collection<GameProfile> targets = GameProfileArgument.getGameProfiles(ctx, "targets");
        for (GameProfile gameprofile : targets) {
            ServerPlayerEntity player = ctx.getSource().getServer().getPlayerList().getPlayer(gameprofile.getId());
            PacketHandler.sendTo(player, new org.auioc.mods.ahutils.client.network.TriggerCrashPacket(mode));
            Loggers.info(String.format("Send TriggerCrashPacket with mode %d to player %s (%s)", mode, player.getName().getString(), player.getStringUUID()));
        }
        return Command.SINGLE_SUCCESS;
    }
}
