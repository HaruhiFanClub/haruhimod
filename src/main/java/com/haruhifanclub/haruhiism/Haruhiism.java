package com.haruhifanclub.haruhiism;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.auioc.mcmod.arnicalib.utils.LogUtil;
import org.auioc.mcmod.arnicalib.utils.java.VersionUtils;
import com.haruhifanclub.haruhiism.client.event.HMClientEventHandler;
import com.haruhifanclub.haruhiism.client.keybinding.HMKeyMappings;
import com.haruhifanclub.haruhiism.client.model.HMLayerDefinitions;
import com.haruhifanclub.haruhiism.common.advancement.HMCriterions;
import com.haruhifanclub.haruhiism.common.block.HMBlocks;
import com.haruhifanclub.haruhiism.common.blockentity.HMBlockEntities;
import com.haruhifanclub.haruhiism.common.config.CommonConfig;
import com.haruhifanclub.haruhiism.common.item.HMItems;
import com.haruhifanclub.haruhiism.common.network.HMPacketHandler;
import com.haruhifanclub.haruhiism.common.sound.HMSoundEvents;
import com.haruhifanclub.haruhiism.integ.curios.client.renderer.CuriosRenderers;
import com.haruhifanclub.haruhiism.integ.curios.common.CuriosIMC;
import com.haruhifanclub.haruhiism.server.event.HMServerEventHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Haruhiism.MOD_ID)
public class Haruhiism {

    public static final String MOD_ID = "haruhiism";
    public static final String MOD_NAME = "Haruhiism";
    public static final String MAIN_VERSION;
    public static final String FULL_VERSION;

    public static final Logger LOGGER = LogUtil.getLogger(MOD_NAME);
    private static final Marker CORE = LogUtil.getMarker("CORE");

    public Haruhiism() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);

        handleIMC();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        modSetup(modEventBus);
        forgeSetup(forgeEventBus);

        final ClientSideOnlySetup ClientSideOnlySetup = new ClientSideOnlySetup(modEventBus, forgeEventBus);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSideOnlySetup::modSetup);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSideOnlySetup::forgeSetup);
    }

    static {
        Pair<String, String> version = VersionUtils.getModVersion(Haruhiism.class);
        MAIN_VERSION = version.getLeft();
        FULL_VERSION = version.getRight();
        LOGGER.info(CORE, "Version: " + MAIN_VERSION + " (" + FULL_VERSION + ")");
    }

    private static void handleIMC() {
        CuriosIMC.send();
    }

    private void modSetup(final IEventBus modEventBus) {
        HMPacketHandler.init();
        HMCriterions.register();
        HMBlocks.BLOCKS.register(modEventBus);
        HMBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        HMItems.ITEMS.register(modEventBus);
        HMSoundEvents.SOUND_EVENTS.register(modEventBus);
    }

    private void forgeSetup(final IEventBus forgeEventBus) {
        forgeEventBus.register(HMServerEventHandler.class);
    }


    private class ClientSideOnlySetup {
        private final IEventBus modEventBus;
        private final IEventBus forgeEventBus;

        public ClientSideOnlySetup(final IEventBus modEventBus, final IEventBus forgeEventBus) {
            this.modEventBus = modEventBus;
            this.forgeEventBus = forgeEventBus;
        }

        public void modSetup() {
            modEventBus.addListener((FMLClientSetupEvent event) -> {
                HMKeyMappings.register();
                CuriosRenderers.register();
            });
            modEventBus.addListener(HMLayerDefinitions::register);
        }

        public void forgeSetup() {
            forgeEventBus.register(HMClientEventHandler.class);
        }
    }

}
