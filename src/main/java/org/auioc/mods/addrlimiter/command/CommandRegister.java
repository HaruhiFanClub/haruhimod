package org.auioc.mods.addrlimiter.command;

import static net.minecraft.command.Commands.literal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import com.google.gson.Gson;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import org.auioc.mods.addrlimiter.AddrLimiter;
import org.auioc.mods.addrlimiter.data.AddrManager;
import org.auioc.mods.addrlimiter.data.AddrMap;
import org.auioc.mods.ahutils.utils.LogUtil;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.StringTextComponent;

public class CommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
            literal("addrlimiter")
                .executes((ctx) -> {
                    return Command.SINGLE_SUCCESS;
                })
                .then(
                    literal("dump")
                        .requires((commandSource) -> {
                            return commandSource.hasPermission(4);
                        }).executes((ctx) -> {
                            Path directory = Paths.get("dumps/");
                            File file = new File(directory.toUri().getPath() + "/" + AddrLimiter.MOD_ID + ".json");
                            if (!directory.toFile().exists()) {
                                try {
                                    Files.createDirectory(directory);
                                    LogUtil.warn("Folder dumps does not exist, created automatically");
                                } catch (final IOException e) {
                                    LogUtil.error("Could not create dump directory", e);
                                    throw new CommandSyntaxException(
                                        new SimpleCommandExceptionType(() -> {
                                            return "";
                                        }),
                                        () -> {
                                            return "Could not create dump directory: " + e.getMessage();
                                        }
                                    );
                                }
                            }

                            Map<String, AddrMap> data = AddrManager.getInstance().dump();
                            Gson gson5 = new Gson();
                            String dataString = gson5.toJson(data);

                            try {
                                final BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
                                writer.write(new StringBuffer().append(dataString).toString());
                                writer.close();
                            } catch (final Exception e) {
                                LogUtil.error("[AddrLimiter] Cannot dump data to file: ", e);
                                throw new CommandSyntaxException(
                                    new SimpleCommandExceptionType(() -> {
                                        return "";
                                    }),
                                    () -> {
                                        return "[AddrLimiter] Cannot dump data to file: " + e.getMessage();
                                    }
                                );
                            }

                            LogUtil.info("[AddrLimiter] Successful dump data to file: " + file.toPath().toString());
                            ctx.getSource().sendSuccess(new StringTextComponent("[AddrLimiter] Successful dump data to file: " + file.toPath().toString()), true);

                            return Command.SINGLE_SUCCESS;
                        })
                )
        );
    }
}
