package com.haruhifanclub.mods.haruhicore;

import com.haruhifanclub.mods.haruhicore.client.event.ClientForgeEventHandler;
import com.haruhifanclub.mods.haruhicore.client.event.ClientModEventHandler;
import com.haruhifanclub.mods.haruhicore.common.advancement.CriterionRegistry;
import com.haruhifanclub.mods.haruhicore.common.block.HCBlocks;
import com.haruhifanclub.mods.haruhicore.common.blockentity.HCBlockEntities;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.entity.HCEntities;
import com.haruhifanclub.mods.haruhicore.common.item.HCItems;
import com.haruhifanclub.mods.haruhicore.common.network.HCPacketHandler;
import com.haruhifanclub.mods.haruhicore.common.sound.HCSoundEvents;
import com.haruhifanclub.mods.haruhicore.server.event.HCServerEventHandler;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.auioc.mods.arnicalib.utils.LogUtil;
import org.auioc.mods.arnicalib.utils.java.VersionUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HaruhiCore.MOD_ID)
public class HaruhiCore {

    public static final String MOD_ID = "haruhicore";
    public static final String MOD_NAME = "HaruhiCore";
    public static final String MAIN_VERSION;
    public static final String FULL_VERSION;

    public static final Logger LOGGER = LogUtil.getLogger(MOD_NAME);
    private static final Marker CORE = LogUtil.getMarker("CORE");

    public HaruhiCore() {
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
        Pair<String, String> version = VersionUtils.getModVersion(HaruhiCore.class);
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
            modEventBus.register(ClientModEventHandler.class);
        }

        public void forgeSetup() {
            forgeEventBus.register(ClientForgeEventHandler.class);
        }
    }

}
