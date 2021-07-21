package com.haruhifanclub.mods.haruhicore;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;

@Mod(HaruhiCore.MOD_ID)
public class HaruhiCore {
    public static final String MOD_ID = "haruhicore";

    public HaruhiCore() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);

        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // MinecraftForge.EVENT_BUS.register(this);


        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        com.haruhifanclub.mods.haruhicore.common.item.ItemManager.ITEMS.register(modEventBus);
    }

    // private void setup(final FMLCommonSetupEvent event) {
    // Loggers.info("[Init] Mod HaruhiCore is initialized");

    // }
}
