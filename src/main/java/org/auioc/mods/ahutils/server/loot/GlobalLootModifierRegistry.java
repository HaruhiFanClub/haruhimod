package org.auioc.mods.ahutils.server.loot;

import org.auioc.mods.ahutils.AhUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class GlobalLootModifierRegistry {

    @SubscribeEvent
    public static void registerModifierSerializer(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        IForgeRegistry<GlobalLootModifierSerializer<?>> registry = event.getRegistry();

        registry.register(
            (new HLootInjector.Serializer()).setRegistryName(new ResourceLocation(AhUtils.MOD_ID, "loot_injector"))
        );
    }

}
