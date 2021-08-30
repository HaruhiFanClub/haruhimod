package com.haruhifanclub.mods.haruhicore.common.tileentity;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.common.block.BlockRegistry;
import com.haruhifanclub.mods.haruhicore.common.tileentity.impl.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
        DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, HaruhiCore.MOD_ID);


    public static RegistryObject<TileEntityType<SosBadgeSlabTileEntity>> SOS_BADGE_SLAB_BLOCK_TILE_ENTITY =
        TILE_ENTITIES.register("sos_badge_slab_tileentity", () -> {
            return TileEntityType.Builder.of(SosBadgeSlabTileEntity::new, BlockRegistry.SOS_BADGE_SLAB_BLOCK.get()).build(null);
        });
}
