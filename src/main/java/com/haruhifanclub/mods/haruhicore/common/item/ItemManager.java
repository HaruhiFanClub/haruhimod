package com.haruhifanclub.mods.haruhicore.common.item;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.common.block.BlockManager;
import com.haruhifanclub.mods.haruhicore.common.item.impl.EpicReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.item.impl.ModIconItem;
import com.haruhifanclub.mods.haruhicore.common.item.impl.PhysicsExcaliburItem;
import com.haruhifanclub.mods.haruhicore.common.item.impl.ReinforcementStoneItem;
import com.haruhifanclub.mods.haruhicore.common.item.impl.TestItem;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.ItemGroupManager;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HaruhiCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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


    public static RegistryObject<Item> SOS_BADGE_CUSHION_BLOCK = ITEMS.register(
        "sos_badge_cushion", () -> new BlockItem(
            BlockManager.SOS_BADGE_CUSHION_BLOCK.get(), new Item.Properties().tab(ItemGroupManager.itemGroup)
        )
    );
}
