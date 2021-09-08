package org.auioc.mods.ahutils.client.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ClientConfig {

    public static ForgeConfigSpec CONFIG;

    public static BooleanValue EnableAdvancedTooltip;
    public static BooleanValue AdvancedTooltipOnlyOnDebug;
    public static BooleanValue AdvancedTooltipOnlyOnShift;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

        {
            b.push("advanced_tooltip");

            EnableAdvancedTooltip = b.define("enable", false);
            AdvancedTooltipOnlyOnDebug = b.define("only_on_debug", false);
            AdvancedTooltipOnlyOnShift = b.define("only_on_shift", false);

            b.pop();
        }

        CONFIG = b.build();
    }

}
