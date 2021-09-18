package com.haruhifanclub.mods.haruhicore.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;;

public class CommonConfig {
    public static ForgeConfigSpec CONFIG;


    public static BooleanValue EnableCommonReinforcementStone;
    public static BooleanValue EnableEpicReinforcementStone;
    public static IntValue CommonReinforcingExperienceCost;
    public static IntValue CommonReinforcingLuckEffectMultiplier;
    public static IntValue CommonReinforcingDanchouConeMultiplier;
    public static IntValue EpicReinforcingExperienceCost;
    public static ConfigValue<String> ReinforcingSuccessSound;
    public static ConfigValue<String> ReinforcingFailedSound;
    public static ConfigValue<List<? extends String>> ReinforcementStoneItemBlacklist;
    public static ConfigValue<List<? extends String>> ReinforcementStoneUseOnBlock;

    public static BooleanValue TpddBroadcastOnWrite;
    public static BooleanValue TpddBroadcastOnRead;
    public static IntValue TpddReadCooldown;
    public static IntValue TpddWriteCooldown;
    public static IntValue TpddReadDuration;

    public static IntValue MikurusMaidOutfitEffectRange;
    public static BooleanValue MikurusMaidOutfitForOtherPlayers;
    public static BooleanValue MikurusMaidOutfitForFriendlyEntities;

    public static IntValue YukisWizardCloakEffectDuration;

    public static ConfigValue<List<? extends String>> BaseballBatCompatibleEnchantments;
    public static ConfigValue<Float> GuidedBaseballBatKnockbackDamageMultiplier;
    public static DoubleValue GuidedBaseballBatHitProjectileRayTraceLength;


    public static IntValue SingleSosBadgeSlabEffectCooldown;
    public static IntValue SingleSosBadgeSlabLootCooldown;
    public static ConfigValue<String> SingleSosBadgeSlabLootTable;

    public static IntValue DoubleSosBadgeSlabEffectCooldown;
    public static ConfigValue<List<? extends Integer>> DoubleSosBadgeSlabEffectLevelRange;
    public static IntValue DoubleSosBadgeSlabLootCooldown;
    public static ConfigValue<String> DoubleSosBadgeSlabLootTable;
    public static BooleanValue SosBadgeSlabLogLootDetail;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

        {
            b.push("item");

            {
                b.push("reinforcement_stone");
                ReinforcementStoneItemBlacklist = b.define("item_blacklist", new ArrayList<String>());
                ReinforcementStoneUseOnBlock = b.define("use_on_block", new ArrayList<String>(Arrays.asList("minecraft:anvil")));
                ReinforcingSuccessSound = b.define("success_sound", "");
                ReinforcingFailedSound = b.define("failed_sound", "");
                {
                    b.push("common");
                    EnableCommonReinforcementStone = b.define("enable", true);
                    CommonReinforcingExperienceCost = b.defineInRange("experience_cost", 0, 0, Integer.MAX_VALUE);
                    CommonReinforcingLuckEffectMultiplier = b.defineInRange("luck_effect_multiplier", 1, 0, Integer.MAX_VALUE);
                    CommonReinforcingDanchouConeMultiplier = b.defineInRange("danchou_cone_multiplier", 2, 0, Integer.MAX_VALUE);
                    b.pop();
                }
                {
                    b.push("epic");
                    EnableEpicReinforcementStone = b.define("enable", true);
                    EpicReinforcingExperienceCost = b.defineInRange("experience_cost", 0, 0, Integer.MAX_VALUE);
                    b.pop();
                }
                b.pop();
            }

            {
                b.push("tpdd");
                TpddBroadcastOnWrite = b.define("broadcast_on_write", true);
                TpddBroadcastOnRead = b.define("broadcast_on_read", true);
                TpddWriteCooldown = b.defineInRange("write_cooldown", 3, 0, Integer.MAX_VALUE);
                TpddReadCooldown = b.defineInRange("read_cooldown", 3, 0, Integer.MAX_VALUE);
                TpddReadDuration = b.defineInRange("read_duration", 3, 0, Integer.MAX_VALUE);
                b.pop();
            }

            {
                b.push("mikurus_maid_outfit");
                MikurusMaidOutfitEffectRange = b.defineInRange("effect_range", 10, 1, 64);
                MikurusMaidOutfitForOtherPlayers = b.define("is_effective_for_other_players", true);
                MikurusMaidOutfitForFriendlyEntities = b.define("is_effective_for_friendly_entities", true);
                b.pop();
            }

            {
                b.push("yukis_wizard_cloak");
                YukisWizardCloakEffectDuration = b.defineInRange("effect_duration", 840, 20, Integer.MAX_VALUE);
                b.pop();
            }

            {
                b.push("baseball_bat");
                BaseballBatCompatibleEnchantments = b.define(
                    "compatible_enchantments", new ArrayList<String>(Arrays.asList("minecraft:knockback", "minecraft:unbreaking", "minecraft:mending", "minecraft:vanishing_curse"))
                );
                {
                    b.push("guided");
                    GuidedBaseballBatKnockbackDamageMultiplier = b.define("knockback_damage_multiplier", 1.5F);
                    GuidedBaseballBatHitProjectileRayTraceLength = b.defineInRange("hit_projectile_max_distance", 7.5D, 0.0D, Double.MAX_VALUE);
                    b.pop();
                }
                b.pop();
            }

            b.pop();
        }


        {
            b.push("block");

            {
                b.push("sos_badge_slab");
                SosBadgeSlabLogLootDetail = b.define("log_loot_detail", false);
                {
                    b.push("single");
                    SingleSosBadgeSlabEffectCooldown = b.defineInRange("effect_cooldown", 6, 1, Integer.MAX_VALUE);
                    SingleSosBadgeSlabLootCooldown = b.defineInRange("loot_cooldown", 6, 1, Integer.MAX_VALUE);
                    SingleSosBadgeSlabLootTable = b.define("loot_table", "");
                    b.pop();
                }
                {
                    b.push("double");
                    DoubleSosBadgeSlabEffectCooldown = b.defineInRange("effect_cooldown", 3, 1, Integer.MAX_VALUE);
                    DoubleSosBadgeSlabLootCooldown = b.defineInRange("loot_cooldown", 3, 1, Integer.MAX_VALUE);
                    DoubleSosBadgeSlabLootTable = b.define("loot_table", "");
                    DoubleSosBadgeSlabEffectLevelRange = b
                        .comment("Array: [min, max]", "Range: 0 ~ 255")
                        .define(
                            "effect_level_range",
                            new ArrayList<Integer>(Arrays.asList(0, 2)),
                            (x) -> checkIntArray(x, 2)
                        );
                    b.pop();
                }
                b.pop();
            }

            b.pop();
        }

        CONFIG = b.build();
    }


    @SuppressWarnings("unchecked")
    private static boolean checkIntArray(Object x, int size) {
        if (!(x instanceof ArrayList)) {
            return false;
        }
        if (((ArrayList<Object>) x).size() != size) {
            return false;
        }
        for (Object o : (ArrayList<Object>) x) {
            if (!(o instanceof Integer)) {
                return false;
            }
        }
        return true;
    }

}
