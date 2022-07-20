package com.haruhifanclub.haruhimod.haruhiism;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.auioc.mcmod.arnicalib.utils.LogUtil;
import org.auioc.mcmod.arnicalib.utils.java.VersionUtils;
import com.haruhifanclub.haruhimod.haruhiism.client.event.HCClientEventHandler;
import com.haruhifanclub.haruhimod.haruhiism.client.keybinding.HCKeyMappings;
import com.haruhifanclub.haruhimod.haruhiism.client.model.LayerDefinitionRegistry;
import com.haruhifanclub.haruhimod.haruhiism.common.advancement.CriterionRegistry;
import com.haruhifanclub.haruhimod.haruhiism.common.block.HCBlocks;
import com.haruhifanclub.haruhimod.haruhiism.common.blockentity.HCBlockEntities;
import com.haruhifanclub.haruhimod.haruhiism.common.config.CommonConfig;
import com.haruhifanclub.haruhimod.haruhiism.common.entity.HCEntities;
import com.haruhifanclub.haruhimod.haruhiism.common.item.HCItems;
import com.haruhifanclub.haruhimod.haruhiism.common.network.HCPacketHandler;
import com.haruhifanclub.haruhimod.haruhiism.common.sound.HCSoundEvents;
import com.haruhifanclub.haruhimod.haruhiism.server.event.HCServerEventHandler;
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

    public static final String MOD_ID = "Haruhiism";
    public static final String MOD_NAME = "Haruhiism";
    public static final String MAIN_VERSION;
    public static final String FULL_VERSION;

    public static final Logger LOGGER = LogUtil.getLogger(MOD_NAME);
    private static final Marker CORE = LogUtil.getMarker("CORE");

    public Haruhiism() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);

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

    private void modSetup(final IEventBus modEventBus) {
        HCPacketHandler.init();
        CriterionRegistry.register();
        HCBlocks.BLOCKS.register(modEventBus);
        HCBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        HCEntities.ENTITIES.register(modEventBus);
        HCItems.ITEMS.register(modEventBus);
        HCSoundEvents.SOUND_EVENTS.register(modEventBus);
    }

    private void forgeSetup(final IEventBus forgeEventBus) {
        forgeEventBus.register(HCServerEventHandler.class);
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
                HCKeyMappings.register();
            });
            modEventBus.addListener(LayerDefinitionRegistry::register);
        }

        public void forgeSetup() {
            forgeEventBus.register(HCClientEventHandler.class);
        }
    }

}
