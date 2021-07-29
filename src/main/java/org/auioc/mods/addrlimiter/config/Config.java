package org.auioc.mods.addrlimiter.config;

import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.BooleanValue EnableAddrLimiter;

    public static ForgeConfigSpec.IntValue MaxPlayerPreAddr;
    public static ForgeConfigSpec.BooleanValue EnableAddrWhitelist;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> AddrWhitelist;

    static {
        ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
        BUILDER.push("general");

        EnableAddrLimiter = BUILDER.comment("Restart required").define("enable", true);

        MaxPlayerPreAddr = BUILDER
            .comment("Maximum number of player at same IP address")
            .defineInRange("max_player_pre_address", 1, 1, Integer.MAX_VALUE);

        EnableAddrWhitelist = BUILDER
            .define("enable_address_whitelist", false);

        AddrWhitelist = BUILDER
            .define("address_whitelist", new ArrayList<String>());

        BUILDER.pop();
        SERVER_CONFIG = BUILDER.build();
    }
}
