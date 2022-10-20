package com.haruhifanclub.haruhiism.common.config;

import org.auioc.mcmod.arnicalib.game.config.ConfigUtils;
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

    public static final ForgeConfigSpec SPEC;

    static {
        final ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

        {
            b.push("item");

            {
                ConfigUtils.pushWithoutPop(b, "reinforcement_stone", HMReinforcementStoneItem.Config::build);
                {
                    ConfigUtils.push(b, "common", DanchouArmbandItem.Config::build);
                    ConfigUtils.push(b, "epic", GodBlessDanchouArmbandItem.Config::build);
                }
                b.pop();
            }

            {

                ConfigUtils.pushWithoutPop(b, "baseball_bat", HMBaseballBatItem.Config::build);
                {
                    ConfigUtils.push(b, "guided", GuidedBaseballBatItem.Config::build);
                }
                b.pop();
            }

            ConfigUtils.push(b, "tpdd", TpddItem.Config::build);
            ConfigUtils.push(b, "mikurus_maid_outfit", MikurusMaidOutfitItem.Config::build);
            ConfigUtils.push(b, "mikurus_contact", MikurusContactItem.Config::build);
            ConfigUtils.push(b, "yukis_wizard_cloak", YukisWizardCloakItem.Config::build);

            b.pop();
        }


        {
            b.push("block");

            ConfigUtils.push(b, "sos_badge_slab", SosBadgeSlabBlockEntity.Config::build);

            b.pop();
        }

        SPEC = b.build();
    }

}
