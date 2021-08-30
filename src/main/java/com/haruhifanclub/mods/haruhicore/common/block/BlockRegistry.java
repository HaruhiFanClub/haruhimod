package com.haruhifanclub.mods.haruhicore.common.block;

import java.util.function.Supplier;
import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.common.block.impl.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, HaruhiCore.MOD_ID);

    private static RegistryObject<Block> register(String id, Supplier<? extends Block> sup) {
        return BLOCKS.register(id, sup);
    }


    public final static RegistryObject<Block> SOS_BADGE_SLAB_BLOCK = register("sos_badge_slab", SosBadgeSlabBlock::new);
    public final static RegistryObject<Block> DANCHOU_CONE_BLOCK = register("danchou_cone", DanchouConeBlock::new);
}
