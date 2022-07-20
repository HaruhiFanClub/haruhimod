package com.haruhifanclub.haruhimod.haruhiism.common.block;

import java.util.function.Supplier;
import com.haruhifanclub.haruhimod.haruhiism.Haruhiism;
import com.haruhifanclub.haruhimod.haruhiism.common.block.impl.DanchouConeBlock;
import com.haruhifanclub.haruhimod.haruhiism.common.block.impl.SosBadgeSlabBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class HCBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Haruhiism.MOD_ID);

    private static RegistryObject<Block> register(String id, Supplier<? extends Block> sup) {
        return BLOCKS.register(id, sup);
    }


    public final static RegistryObject<Block> SOS_BADGE_SLAB_BLOCK = register("sos_badge_slab", SosBadgeSlabBlock::new);
    public final static RegistryObject<Block> DANCHOU_CONE_BLOCK = register("danchou_cone", DanchouConeBlock::new);

}
