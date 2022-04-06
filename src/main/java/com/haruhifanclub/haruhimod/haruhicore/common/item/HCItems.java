package com.haruhifanclub.haruhimod.haruhicore.common.item;

import java.util.function.Supplier;
import com.haruhifanclub.haruhimod.haruhicore.HaruhiCore;
import com.haruhifanclub.haruhimod.haruhicore.api.item.HCTier;
import com.haruhifanclub.haruhimod.haruhicore.common.block.HCBlocks;
import com.haruhifanclub.haruhimod.haruhicore.common.item.base.HCMusicDiscItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.BaseballBatItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.DanchouConeBlockItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.EpicReinforcementStoneItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.GuidedBaseballBatItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.HourglassItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.MaidOutfitItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.MikurusContactItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.MikurusMaidOutfitItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.ReinforcementStoneItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.TpddItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.WizardCloakItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.WizardHatItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.WizardWandItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.YukisWizardCloakItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.YukisWizardHatItem;
import com.haruhifanclub.haruhimod.haruhicore.common.item.impl.YukisWizardWandItem;
import com.haruhifanclub.haruhimod.haruhicore.common.itemgroup.HCCreativeModeTabs;
import com.haruhifanclub.haruhimod.haruhicore.common.sound.HCSoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class HCItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HaruhiCore.MOD_ID);

    private static RegistryObject<Item> register(String id, Supplier<? extends Item> sup) {
        return ITEMS.register(id, sup);
    }

    // Technical items
    public static final RegistryObject<Item> ICON_ITEM = register("icon", () -> new Item((new Item.Properties())));

    // Common items
    public static final RegistryObject<Item> REINFORCEMENT_STONE_ITEM = register("reinforcement_stone", ReinforcementStoneItem::new);
    public static final RegistryObject<Item> EPIC_REINFORCEMENT_STONE_ITEM = register("epic_reinforcement_stone", EpicReinforcementStoneItem::new);

    // Block items
    public static final RegistryObject<Item> SOS_BADGE_SLAB_BLOCK = register("sos_badge_slab", () -> new BlockItem(HCBlocks.SOS_BADGE_SLAB_BLOCK.get(), new Item.Properties().tab(HCCreativeModeTabs.TAB_MAIN)));
    public static final RegistryObject<Item> DANCHOU_CONE_BLOCK = register("danchou_cone", DanchouConeBlockItem::new);


    // HaruhiCore V2 //

    // Armors
    public static final RegistryObject<Item> WIZARD_HAT_ITEM = register("wizard_hat", WizardHatItem::new);
    public static final RegistryObject<Item> YUKIS_WIZARD_HAT_ITEM = register("yukis_wizard_hat", YukisWizardHatItem::new);
    public static final RegistryObject<Item> WIZARD_CLOAK_ITEM = register("wizard_cloak", WizardCloakItem::new);
    public static final RegistryObject<Item> YUKIS_WIZARD_CLOAK_ITEM = register("yukis_wizard_cloak", YukisWizardCloakItem::new);
    public static final RegistryObject<Item> MAID_OUTFIT_ITEM = register("maid_outfit", MaidOutfitItem::new);
    public static final RegistryObject<Item> MIKURUS_MAID_OUTFIT_ITEM = register("mikurus_maid_outfit", MikurusMaidOutfitItem::new);
    public static final RegistryObject<Item> MIKURUS_CONTACT_ITEM = register("mikurus_contact", MikurusContactItem::new);

    // Weapons
    public static final RegistryObject<Item> BASEBALL_BAT_ITEM = register("baseball_bat", BaseballBatItem::new);
    public static final RegistryObject<Item> GUIDED_BASEBALL_BAT_ITEM = register("guided_baseball_bat", GuidedBaseballBatItem::new);
    public static final RegistryObject<Item> YUKIS_WIZARD_WAND_ITEM = register("yukis_wizard_wand", YukisWizardWandItem::new);
    public static final RegistryObject<Item> INFERIOR_WIZARD_WAND_ITEM = register("inferior_wizard_wand", () -> new WizardWandItem(HCTier.INFERIOR));
    public static final RegistryObject<Item> ORDINARY_WIZARD_WAND_ITEM = register("ordinary_wizard_wand", () -> new WizardWandItem(HCTier.ORDINARY));
    public static final RegistryObject<Item> EXCELLENT_WIZARD_WAND_ITEM = register("excellent_wizard_wand", () -> new WizardWandItem(HCTier.EXCELLENT));
    public static final RegistryObject<Item> RARE_WIZARD_WAND_ITEM = register("rare_wizard_wand", () -> new WizardWandItem(HCTier.RARE));
    public static final RegistryObject<Item> EPIC_WIZARD_WAND_ITEM = register("epic_wizard_wand", () -> new WizardWandItem(HCTier.EPIC));


    // Music Discs
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_IN_THE_SUMMERTIME = register("music_disc_in_the_summertime", () -> new HCMusicDiscItem(HCSoundEvents.MUSIC_DISC_IN_THE_SUMMERTIME));
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_SOMEDAY_IN_THE_RAIN = register("music_disc_someday_in_the_rain", () -> new HCMusicDiscItem(HCSoundEvents.MUSIC_DISC_SOMEDAY_IN_THE_RAIN));
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_VOX_IN_BOX = register("music_disc_vox_in_box", () -> new HCMusicDiscItem(HCSoundEvents.MUSIC_DISC_VOX_IN_BOX));
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_HALO = register("music_disc_halo", () -> new HCMusicDiscItem(HCSoundEvents.MUSIC_DISC_HALO));

    public static final RegistryObject<Item> HOURGLASS_ITEM = register("hourglass", HourglassItem::new);
    public static final RegistryObject<Item> TPDD_ITEM = register("tpdd", TpddItem::new);

}
