package org.auioc.mods.ahutils.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class CommonConfig {
    public static ForgeConfigSpec CONFIG;


    public static BooleanValue EnablePhysicsExcalibur;

    public static BooleanValue LightBlockDefaultStateVisible;
    public static IntValue LightBlockDefaultStateLevel;


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

        CONFIG = b.build();
    }
}

