package org.auioc.mods.ahutils.common.config;

import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class CommonConfig {
    public static ForgeConfigSpec CONFIG;


    public static BooleanValue EnablePhysicsExcalibur;

    public static BooleanValue LightBlockDefaultStateVisible;
    public static IntValue LightBlockDefaultStateLevel;

    public static BooleanValue DeloggerFilterJavaOut;
    public static BooleanValue DeloggerFilterJavaLogger;
    public static BooleanValue DeloggerFilterLog4JRoot;
    public static BooleanValue DeloggerFilterLog4JMisc;
    public static ConfigValue<List<? extends String>> DeloggerBasicFilter;
    public static ConfigValue<List<? extends String>> DeloggerRegexFilter;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

        {
            b.push("item");

            {
                b.push("physics_excalibur");
                EnablePhysicsExcalibur = b.define("enable", false);
                b.pop();
            }

            b.pop();
        }

        {
            b.push("block");

            {
                b.push("light").comment("Restart required");

                {
                    b.push("default_state");
                    LightBlockDefaultStateVisible = b.define("visible", true);
                    LightBlockDefaultStateLevel = b.defineInRange("level", 0, 0, 15);
                    b.pop();
                }

                b.pop();
            }

            b.pop();
        }

        {
            b.push("utils");

            {
                b.push("delogger");

                DeloggerFilterJavaOut = b.define("filter_java_out", false);
                DeloggerFilterJavaLogger = b.define("filter_ava_logger", false);
                DeloggerFilterLog4JRoot = b.define("filter_log4j_root", false);
                DeloggerFilterLog4JMisc = b.define("filter_log4j_misc", false);

                {
                    b.push("filter");
                    DeloggerBasicFilter = b.define("basic", new ArrayList<String>());
                    DeloggerRegexFilter = b.define("regex", new ArrayList<String>());
                    b.pop();
                }

                b.pop();
            }

            b.pop();
        }

        CONFIG = b.build();
    }
}

