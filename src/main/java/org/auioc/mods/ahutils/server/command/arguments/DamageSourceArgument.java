package org.auioc.mods.ahutils.server.command.arguments;

import java.util.concurrent.CompletableFuture;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import org.auioc.mods.ahutils.utils.game.DamageSourceUtils;
import org.auioc.mods.ahutils.utils.game.I18nUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.DamageSource;

public class DamageSourceArgument implements ArgumentType<DamageSource> {

    public static DamageSourceArgument damageSource() {
        return new DamageSourceArgument();
    }

    public static DamageSource getDamageSource(CommandContext<CommandSource> context, String argument) throws CommandSyntaxException {
        return context.getArgument(argument, DamageSource.class);
    }

    @Override
    public DamageSource parse(StringReader reader) throws CommandSyntaxException {
        String sourceName = reader.readString();

        if (DamageSourceUtils.map.containsKey(sourceName)) {
            return DamageSourceUtils.map.get(sourceName);
        }

        throw (new SimpleCommandExceptionType(
            I18nUtils.getTranslatedText("ahutils.argument.damage_source.invalid", sourceName)
        )).create();
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return ISuggestionProvider.suggest(DamageSourceUtils.map.keySet(), builder);
    }
}
