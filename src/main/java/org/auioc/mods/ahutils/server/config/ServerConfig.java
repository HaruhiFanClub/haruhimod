package org.auioc.mods.ahutils.server.config;

import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    public static ForgeConfigSpec CONFIG;

    public static ForgeConfigSpec.BooleanValue EnableAddrLimiter;

    public static ForgeConfigSpec.IntValue MaxPlayerPreAddr;
    public static ForgeConfigSpec.BooleanValue EnableAddrWhitelist;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> AddrWhitelist;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();
        b.push("addrlimiter");

        EnableAddrLimiter = b.define("enable", false);

        MaxPlayerPreAddr = b.defineInRange("max_player_pre_address", 1, 1, Integer.MAX_VALUE);

        EnableAddrWhitelist = b.define("enable_address_whitelist", false);

        AddrWhitelist = b.define("address_whitelist", new ArrayList<String>());

        b.pop();
        CONFIG = b.build();
    }
}
