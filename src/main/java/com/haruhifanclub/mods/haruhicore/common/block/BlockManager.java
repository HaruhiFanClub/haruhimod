package com.haruhifanclub.mods.haruhicore.common.block;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.common.block.impl.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HaruhiCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BlockManager {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, HaruhiCore.MOD_ID);

    public static RegistryObject<Block> TEST_BLOCK = BLOCKS.register("testblock", TestBlock::new);

    public static RegistryObject<Block> SOS_BADGE_SLAB_BLOCK =
        BLOCKS.register("sos_badge_slab", SosBadgeSlabBlock::new);

    public static RegistryObject<Block> DANCHOU_CONE_BLOCK =
        BLOCKS.register("danchou_cone", DanchouConeBlock::new);
}
