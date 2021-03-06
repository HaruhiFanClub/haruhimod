package com.haruhifanclub.haruhiism.common.item;

import java.util.function.Supplier;
import com.haruhifanclub.haruhiism.Haruhiism;
import com.haruhifanclub.haruhiism.api.item.HMTier;
import com.haruhifanclub.haruhiism.common.block.HMBlocks;
import com.haruhifanclub.haruhiism.common.item.base.HMMusicDiscItem;
import com.haruhifanclub.haruhiism.common.item.impl.BaseballBatItem;
import com.haruhifanclub.haruhiism.common.item.impl.DanchouArmbandItem;
import com.haruhifanclub.haruhiism.common.item.impl.DanchouConeBlockItem;
import com.haruhifanclub.haruhiism.common.item.impl.GodBlessDanchouArmbandItem;
import com.haruhifanclub.haruhiism.common.item.impl.GuidedBaseballBatItem;
import com.haruhifanclub.haruhiism.common.item.impl.HourglassItem;
import com.haruhifanclub.haruhiism.common.item.impl.MaidOutfitItem;
import com.haruhifanclub.haruhiism.common.item.impl.MikurusContactItem;
import com.haruhifanclub.haruhiism.common.item.impl.MikurusMaidOutfitItem;
import com.haruhifanclub.haruhiism.common.item.impl.TpddItem;
import com.haruhifanclub.haruhiism.common.item.impl.WizardCloakItem;
import com.haruhifanclub.haruhiism.common.item.impl.WizardHatItem;
import com.haruhifanclub.haruhiism.common.item.impl.WizardWandItem;
import com.haruhifanclub.haruhiism.common.item.impl.YukisWizardCloakItem;
import com.haruhifanclub.haruhiism.common.item.impl.YukisWizardHatItem;
import com.haruhifanclub.haruhiism.common.item.impl.YukisWizardWandItem;
import com.haruhifanclub.haruhiism.common.itemgroup.HMCreativeModeTabs;
import com.haruhifanclub.haruhiism.common.sound.HMSoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class HMItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Haruhiism.MOD_ID);

    private static RegistryObject<Item> register(String id, Supplier<? extends Item> sup) {
        return ITEMS.register(id, sup);
    }

    // Technical items
    public static final RegistryObject<Item> ICON_ITEM = register("icon", () -> new Item((new Item.Properties())));

    // Common items
    public static final RegistryObject<Item> DANCHOU_ARMBAND_ITEM = register("danchou_armband", DanchouArmbandItem::new);
    public static final RegistryObject<Item> GOD_BLESS_DANCHOU_ARMBAND_ITEM = register("god_bless_danchou_armband", GodBlessDanchouArmbandItem::new);

    // Block items
    public static final RegistryObject<Item> SOS_BADGE_SLAB_BLOCK = register("sos_badge_slab", () -> new BlockItem(HMBlocks.SOS_BADGE_SLAB_BLOCK.get(), new Item.Properties().tab(HMCreativeModeTabs.TAB_MAIN)));
    public static final RegistryObject<Item> DANCHOU_CONE_BLOCK = register("danchou_cone", DanchouConeBlockItem::new);


    // Haruhi Core V2 //

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
    public static final RegistryObject<Item> INFERIOR_WIZARD_WAND_ITEM = register("inferior_wizard_wand", () -> new WizardWandItem(HMTier.INFERIOR));
    public static final RegistryObject<Item> ORDINARY_WIZARD_WAND_ITEM = register("ordinary_wizard_wand", () -> new WizardWandItem(HMTier.ORDINARY));
    public static final RegistryObject<Item> EXCELLENT_WIZARD_WAND_ITEM = register("excellent_wizard_wand", () -> new WizardWandItem(HMTier.EXCELLENT));
    public static final RegistryObject<Item> RARE_WIZARD_WAND_ITEM = register("rare_wizard_wand", () -> new WizardWandItem(HMTier.RARE));
    public static final RegistryObject<Item> EPIC_WIZARD_WAND_ITEM = register("epic_wizard_wand", () -> new WizardWandItem(HMTier.EPIC));


    // Music Discs
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_IN_THE_SUMMERTIME = register("music_disc_in_the_summertime", () -> new HMMusicDiscItem(HMSoundEvents.MUSIC_DISC_IN_THE_SUMMERTIME));
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_SOMEDAY_IN_THE_RAIN = register("music_disc_someday_in_the_rain", () -> new HMMusicDiscItem(HMSoundEvents.MUSIC_DISC_SOMEDAY_IN_THE_RAIN));
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_VOX_IN_BOX = register("music_disc_vox_in_box", () -> new HMMusicDiscItem(HMSoundEvents.MUSIC_DISC_VOX_IN_BOX));
    public static final RegistryObject<Item> MUSIC_DISC_ITEM_HALO = register("music_disc_halo", () -> new HMMusicDiscItem(HMSoundEvents.MUSIC_DISC_HALO));

    public static final RegistryObject<Item> HOURGLASS_ITEM = register("hourglass", HourglassItem::new);
    public static final RegistryObject<Item> TPDD_ITEM = register("tpdd", TpddItem::new);

}
