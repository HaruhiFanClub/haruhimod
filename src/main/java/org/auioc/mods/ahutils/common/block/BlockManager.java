package org.auioc.mods.ahutils.common.block;

import java.util.function.Supplier;
import org.auioc.mods.ahutils.AhUtils;
import org.auioc.mods.ahutils.common.block.impl.LightBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class BlockManager {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, AhUtils.MOD_ID);

    private static RegistryObject<Block> register(String id, Supplier<? extends Block> sup) {
        return BLOCKS.register(id, sup);
    }

    public final static RegistryObject<Block> LIGHT_BLOCK = register("light", LightBlock::new);
}
