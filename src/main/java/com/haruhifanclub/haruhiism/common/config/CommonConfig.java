package com.haruhifanclub.haruhiism.common.config;

import java.util.function.Consumer;
import com.haruhifanclub.haruhiism.common.blockentity.impl.SosBadgeSlabBlockEntity;
import com.haruhifanclub.haruhiism.common.item.base.HMBaseballBatItem;
import com.haruhifanclub.haruhiism.common.item.base.HMReinforcementStoneItem;
import com.haruhifanclub.haruhiism.common.item.impl.DanchouArmbandItem;
import com.haruhifanclub.haruhiism.common.item.impl.GodBlessDanchouArmbandItem;
import com.haruhifanclub.haruhiism.common.item.impl.GuidedBaseballBatItem;
import com.haruhifanclub.haruhiism.common.item.impl.MikurusContactItem;
import com.haruhifanclub.haruhiism.common.item.impl.MikurusMaidOutfitItem;
import com.haruhifanclub.haruhiism.common.item.impl.TpddItem;
import com.haruhifanclub.haruhiism.common.item.impl.YukisWizardCloakItem;
import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    public static final ForgeConfigSpec CONFIG;

    static {
        final ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

        {
            b.push("item");

            {
                pushWithoutPop(b, "reinforcement_stone", HMReinforcementStoneItem.Config::build);
                {
                    push(b, "common", DanchouArmbandItem.Config::build);
                    push(b, "epic", GodBlessDanchouArmbandItem.Config::build);
                }
                b.pop();
            }

            {

                pushWithoutPop(b, "baseball_bat", HMBaseballBatItem.Config::build);
                {
                    push(b, "guided", GuidedBaseballBatItem.Config::build);
                }
                b.pop();
            }

            push(b, "tpdd", TpddItem.Config::build);
            push(b, "mikurus_maid_outfit", MikurusMaidOutfitItem.Config::build);
            push(b, "mikurus_contact", MikurusContactItem.Config::build);
            push(b, "yukis_wizard_cloak", YukisWizardCloakItem.Config::build);

            b.pop();
        }


        {
            b.push("block");

            push(b, "sos_badge_slab", SosBadgeSlabBlockEntity.Config::build);

            b.pop();
        }

        CONFIG = b.build();
    }


    private static void pushWithoutPop(ForgeConfigSpec.Builder builder, String path, Consumer<ForgeConfigSpec.Builder> subBuilder) {
        builder.push(path);
        subBuilder.accept(builder);
    }

    private static void push(ForgeConfigSpec.Builder builder, String path, Consumer<ForgeConfigSpec.Builder> subBuilder) {
        builder.push(path);
        subBuilder.accept(builder);
        builder.pop();
    }

}
