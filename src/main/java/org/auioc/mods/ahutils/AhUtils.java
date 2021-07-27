package org.auioc.mods.ahutils;

import org.auioc.mods.ahutils.common.config.CommonConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AhUtils.MOD_ID)
public class AhUtils {
    public static final String MOD_ID = "ahutils";

    public AhUtils() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        modSetup(modEventBus);
        forgeSetup(forgeEventBus);
    }

    private void modSetup(final IEventBus modEventBus) {
        org.auioc.mods.ahutils.common.item.ItemManager.ITEMS.register(modEventBus);
        org.auioc.mods.ahutils.common.block.BlockManager.BLOCKS.register(modEventBus);
        modEventBus.register(org.auioc.mods.ahutils.common.network.PacketHandler.class);
    }

    private void forgeSetup(final IEventBus forgeEventBus) {
        forgeEventBus.register(org.auioc.mods.ahutils.server.event.ServerEventHandler.class);
    }
}
