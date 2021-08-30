package org.auioc.mods.ahutils.server.command;

import org.auioc.mods.ahutils.server.command.arguments.DamageSourceArgument;
import net.minecraft.command.arguments.ArgumentSerializer;
import net.minecraft.command.arguments.ArgumentTypes;

public class ServerCommandArgumentRegistry {
    public static void register() {
        ArgumentTypes.register("ahutils:damage_source", DamageSourceArgument.class, new ArgumentSerializer<>(DamageSourceArgument::damageSource));
    }
}
