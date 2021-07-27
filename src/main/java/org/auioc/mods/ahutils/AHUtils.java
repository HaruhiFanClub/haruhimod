package org.auioc.mods.ahutils;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AHUtils.MOD_ID)
public class AHUtils {
    public static final String MOD_ID = "ahutils";

    public AHUtils() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        modSetup(modEventBus);
        forgeSetup(forgeEventBus);
    }

    private void modSetup(final IEventBus modEventBus) {
        modEventBus.register(org.auioc.mods.ahutils.common.network.PacketHandler.class);
    }

    private void forgeSetup(final IEventBus forgeEventBus) {
        forgeEventBus.register(org.auioc.mods.ahutils.server.event.ServerEventHandler.class);
    }
}
