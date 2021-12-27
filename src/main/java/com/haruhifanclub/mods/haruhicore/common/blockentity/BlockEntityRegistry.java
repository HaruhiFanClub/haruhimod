package com.haruhifanclub.mods.haruhicore.common.blockentity;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.common.block.BlockRegistry;
import com.haruhifanclub.mods.haruhicore.common.blockentity.impl.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, HaruhiCore.MOD_ID);


    public static RegistryObject<BlockEntityType<SosBadgeSlabBlockEntity>> SOS_BADGE_SLAB_BLOCK_TILE_ENTITY =
        TILE_ENTITIES.register("sos_badge_slab_tileentity", () -> {
            return BlockEntityType.Builder.of(SosBadgeSlabBlockEntity::new, BlockRegistry.SOS_BADGE_SLAB_BLOCK.get()).build(null);
        });
}
