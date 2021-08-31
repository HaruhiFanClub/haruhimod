package org.auioc.mods.ahutils.common.command.argument;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import org.auioc.mods.ahutils.utils.game.I18nUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.DamageSource;

public class DamageSourceArgument implements ArgumentType<DamageSource> {
    private static HashMap<String, DamageSource> MAP = new HashMap<String, DamageSource>();

    public static DamageSourceArgument damageSource() {
        return new DamageSourceArgument();
    }

    public static DamageSource getDamageSource(CommandContext<CommandSource> context, String argument) throws CommandSyntaxException {
        return context.getArgument(argument, DamageSource.class);
    }

    @Override
    public DamageSource parse(StringReader reader) throws CommandSyntaxException {
        String sourceName = reader.readString();

        if (MAP.containsKey(sourceName)) {
            return MAP.get(sourceName);
        }

        throw (new SimpleCommandExceptionType(
            I18nUtils.getTranslatedText("ahutils.argument.damage_source.invalid", sourceName)
        )).create();
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return ISuggestionProvider.suggest(MAP.keySet(), builder);
    }

    static {
        {
            MAP.put("inFire", DamageSource.IN_FIRE);
            MAP.put("lightningBolt", DamageSource.LIGHTNING_BOLT);
            MAP.put("onFire", DamageSource.ON_FIRE);
            MAP.put("lava", DamageSource.LAVA);
            MAP.put("hotFloor", DamageSource.HOT_FLOOR);
            MAP.put("inWall", DamageSource.IN_WALL);
            MAP.put("cramming", DamageSource.CRAMMING);
            MAP.put("drown", DamageSource.DROWN);
            MAP.put("starve", DamageSource.STARVE);
            MAP.put("cactus", DamageSource.CACTUS);
            MAP.put("fall", DamageSource.FALL);
            MAP.put("flyIntoWall", DamageSource.FLY_INTO_WALL);
            MAP.put("outOfWorld", DamageSource.OUT_OF_WORLD);
            MAP.put("generic", DamageSource.GENERIC);
            MAP.put("magic", DamageSource.MAGIC);
            MAP.put("wither", DamageSource.WITHER);
            MAP.put("anvil", DamageSource.ANVIL);
            MAP.put("fallingBlock", DamageSource.FALLING_BLOCK);
            MAP.put("dragonBreath", DamageSource.DRAGON_BREATH);
            MAP.put("dryout", DamageSource.DRY_OUT);
            MAP.put("sweetBerryBush", DamageSource.SWEET_BERRY_BUSH);
        }
    };
}
