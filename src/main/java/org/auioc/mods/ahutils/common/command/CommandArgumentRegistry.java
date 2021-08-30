package org.auioc.mods.ahutils.common.command;

import org.auioc.mods.ahutils.common.command.argument.DamageSourceArgument;
import net.minecraft.command.arguments.ArgumentSerializer;
import net.minecraft.command.arguments.ArgumentTypes;

public class CommandArgumentRegistry {
    public static void register() {
        ArgumentTypes.register("ahutils:damage_source", DamageSourceArgument.class, new ArgumentSerializer<>(DamageSourceArgument::damageSource));
    }
}
