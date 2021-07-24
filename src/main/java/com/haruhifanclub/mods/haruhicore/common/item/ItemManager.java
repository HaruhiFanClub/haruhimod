package com.haruhifanclub.mods.haruhicore.common.item;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.common.block.BlockManager;
import com.haruhifanclub.mods.haruhicore.common.item.impl.*;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ItemManager {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, HaruhiCore.MOD_ID);

    public static RegistryObject<Item> ICON_ITEM = ITEMS.register("icon", ModIconItem::new);
    public static RegistryObject<Item> TEST_ITEM = ITEMS.register("testitem", TestItem::new);
    public static RegistryObject<Item> PHYSICS_EXCALIBUR_ITEM =
        ITEMS.register("physics_excalibur", PhysicsExcaliburItem::new);

    public static RegistryObject<Item> REINFORCEMENT_STONE_ITEM =
        ITEMS.register("reinforcement_stone", ReinforcementStoneItem::new);
    public static RegistryObject<Item> EPIC_REINFORCEMENT_STONE_ITEM =
        ITEMS.register("epic_reinforcement_stone", EpicReinforcementStoneItem::new);


    public static RegistryObject<Item> SOS_BADGE_SLAB_BLOCK = ITEMS.register(
        "sos_badge_slab", () -> new BlockItem(
            BlockManager.SOS_BADGE_SLAB_BLOCK.get(), new Item.Properties().tab(ItemGroupManager.itemGroup)
        )
    );

    public static RegistryObject<Item> DANCHOU_CONE_BLOCK = ITEMS.register("danchou_cone", DanchouConeBlockItem::new);
}
