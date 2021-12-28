package com.haruhifanclub.mods.haruhicore;

import com.haruhifanclub.mods.haruhicore.common.advancement.CriterionRegistry;
import com.haruhifanclub.mods.haruhicore.common.block.BlockRegistry;
import com.haruhifanclub.mods.haruhicore.common.blockentity.BlockEntityRegistry;
import com.haruhifanclub.mods.haruhicore.common.config.CommonConfig;
import com.haruhifanclub.mods.haruhicore.common.entity.EntityRegistry;
import com.haruhifanclub.mods.haruhicore.common.item.ItemRegistry;
import com.haruhifanclub.mods.haruhicore.common.network.HCPacketHandler;
import com.haruhifanclub.mods.haruhicore.common.sound.SoundEventRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HaruhiCore.MOD_ID)
public class HaruhiCore {

    public static final String MOD_ID = "haruhicore";

    public HaruhiCore() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        modSetup(modEventBus);
        forgeSetup(forgeEventBus);
    }

    private void modSetup(final IEventBus modEventBus) {
        CriterionRegistry.register();
        BlockRegistry.BLOCKS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(modEventBus);
        EntityRegistry.ENTITIES.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        SoundEventRegistry.SOUND_EVENTS.register(modEventBus);
        modEventBus.register(HCPacketHandler.class);
    }

    private void forgeSetup(final IEventBus forgeEventBus) {}

}
