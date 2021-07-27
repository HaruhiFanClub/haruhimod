package org.auioc.mods.addrlimiter;

import org.auioc.mods.addrlimiter.config.Config;
import org.auioc.mods.ahutils.utils.Loggers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AddrLimiter.MOD_ID)
public class AddrLimiter {
    public static final String MOD_ID = "addrlimiter";

    public AddrLimiter() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        Loggers.info("[Init] Mod AddrLimiter is initialized");
    }
}
