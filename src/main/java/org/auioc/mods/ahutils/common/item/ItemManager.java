package org.auioc.mods.ahutils.common.item;

import java.util.function.Supplier;
import org.auioc.mods.ahutils.AhUtils;
import org.auioc.mods.ahutils.common.item.impl.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ItemManager {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, AhUtils.MOD_ID);

    private static RegistryObject<Item> register(String id, Supplier<? extends Item> sup) {
        return ITEMS.register(id, sup);
    }

    public static RegistryObject<Item> PHYSICS_EXCALIBUR_ITEM = register("physics_excalibur", PhysicsExcaliburItem::new);

    public static RegistryObject<Item> LIGHT_BLOCK = register("light", LightBlockItem::new);
}
