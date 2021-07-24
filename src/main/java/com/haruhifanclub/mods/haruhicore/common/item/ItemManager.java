package com.haruhifanclub.mods.haruhicore.common.item;

import java.util.function.Supplier;
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

    private static RegistryObject<Item> register(String id, Supplier<? extends Item> sup) {
        return ITEMS.register(id, sup);
    }

    // Technical items
    public static RegistryObject<Item> ICON_ITEM = register("icon", ModIconItem::new);
    public static RegistryObject<Item> TEST_ITEM = register("testitem", TestItem::new);
    public static RegistryObject<Item> PHYSICS_EXCALIBUR_ITEM = register("physics_excalibur", PhysicsExcaliburItem::new);

    // Common items
    public static RegistryObject<Item> REINFORCEMENT_STONE_ITEM = register("reinforcement_stone", ReinforcementStoneItem::new);
    public static RegistryObject<Item> EPIC_REINFORCEMENT_STONE_ITEM = register("epic_reinforcement_stone", EpicReinforcementStoneItem::new);

    // Block items
    public static RegistryObject<Item> SOS_BADGE_SLAB_BLOCK = register("sos_badge_slab", () -> new BlockItem(BlockManager.SOS_BADGE_SLAB_BLOCK.get(), new Item.Properties().tab(ItemGroupManager.itemGroup)));
    public static RegistryObject<Item> DANCHOU_CONE_BLOCK = register("danchou_cone", DanchouConeBlockItem::new);
}
