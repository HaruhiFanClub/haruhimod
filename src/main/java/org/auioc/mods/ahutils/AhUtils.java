package org.auioc.mods.ahutils;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AhUtils.MOD_ID)
public class AhUtils {
    public static final String MOD_ID = "ahutils";

    public AhUtils() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, org.auioc.mods.ahutils.common.config.CommonConfig.CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, org.auioc.mods.ahutils.client.config.ClientConfig.CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, org.auioc.mods.ahutils.server.config.ServerConfig.CONFIG);

        org.auioc.mods.ahutils.utils.delogger.Delogger.init();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        final ClientSideOnlySetup ClientSideOnlySetup = new ClientSideOnlySetup(modEventBus, forgeEventBus);

        modSetup(modEventBus);
        forgeSetup(forgeEventBus);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSideOnlySetup::modSetup);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSideOnlySetup::forgeSetup);
    }

    private void modSetup(final IEventBus modEventBus) {
        // org.auioc.mods.ahutils.common.item.ItemRegistry.ITEMS.register(modEventBus);
        // org.auioc.mods.ahutils.common.block.BlockRegistry.BLOCKS.register(modEventBus);
        modEventBus.register(org.auioc.mods.ahutils.common.network.PacketHandler.class);
        org.auioc.mods.ahutils.common.command.CommandArgumentRegistry.register();
        modEventBus.register(org.auioc.mods.ahutils.server.loot.GlobalLootModifierRegistry.class);
    }

    private void forgeSetup(final IEventBus forgeEventBus) {
        org.auioc.mods.ahutils.common.itemgroup.ItemGroupRegistry.register();
        forgeEventBus.register(org.auioc.mods.ahutils.server.event.ServerEventHandler.class);
        forgeEventBus.register(org.auioc.mods.ahutils.common.event.CommonEventHandler.class);
    }

    public class ClientSideOnlySetup {
        private final IEventBus modEventBus;
        private final IEventBus forgeEventBus;

        public ClientSideOnlySetup(IEventBus modEventBus, IEventBus forgeEventBus) {
            this.modEventBus = modEventBus;
            this.forgeEventBus = forgeEventBus;
        }

        public void modSetup() {
            // modEventBus.register(org.auioc.mods.ahutils.client.render.RenderTypeRegistry.class);
        }

        public void forgeSetup() {
            forgeEventBus.register(org.auioc.mods.ahutils.client.event.ClientEventHandler.class);
        }
    }
}
