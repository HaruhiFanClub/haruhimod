package com.haruhifanclub.mods.haruhicore.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class CommonConfig {
    public static ForgeConfigSpec CONFIG;

    public static BooleanValue EnablePhysicsExcalibur;

    public static BooleanValue EnableCommonReinforcementStone;
    public static BooleanValue EnableEpicReinforcementStone;
    public static IntValue CommonReinforcingExperienceCost;
    public static IntValue EpicReinforcingExperienceCost;
    public static ConfigValue<String> ReinforcingSuccessSound;
    public static ConfigValue<String> ReinforcingFailedSound;
    public static ConfigValue<List<? extends String>> ReinforcementStoneItemBlacklist;
    public static ConfigValue<List<? extends String>> ReinforcementStoneUseOnBlock;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();
        b.push("item");

        {
            b.push("physics_excalibur");
            EnablePhysicsExcalibur = b
                .define("enable", false);
            b.pop();
        }

        {
            b.push("reinforcement_stone");

            ReinforcementStoneItemBlacklist = b
                .define("item_blacklist", new ArrayList<String>());
            ReinforcementStoneUseOnBlock = b
                .define("use_on_block", new ArrayList<String>(Arrays.asList("minecraft:anvil")));

            ReinforcingSuccessSound = b
                .define("success_sound", "");
            ReinforcingFailedSound = b
                .define("failed_sound", "");

            {
                b.push("common");

                EnableCommonReinforcementStone = b
                    .define("enable", false);
                CommonReinforcingExperienceCost = b
                    .defineInRange("experience_cost", 0, 0, Integer.MAX_VALUE);

                b.pop();
            }

            {
                b.push("epic");

                EnableEpicReinforcementStone = b
                    .define("enable", false);
                EpicReinforcingExperienceCost = b
                    .defineInRange("experience_cost", 0, 0, Integer.MAX_VALUE);

                b.pop();
            }

            b.pop();
        }


        b.pop();
        CONFIG = b.build();
    }
}
