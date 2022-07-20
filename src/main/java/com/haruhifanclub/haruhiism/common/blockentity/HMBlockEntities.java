package com.haruhifanclub.haruhiism.common.blockentity;

import com.haruhifanclub.haruhiism.Haruhiism;
import com.haruhifanclub.haruhiism.common.block.HMBlocks;
import com.haruhifanclub.haruhiism.common.blockentity.impl.SosBadgeSlabBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HMBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Haruhiism.MOD_ID);


    public static final RegistryObject<BlockEntityType<SosBadgeSlabBlockEntity>> SOS_BADGE_SLAB_BLOCK_ENTITY =
        BLOCK_ENTITIES.register("sos_badge_slab", () -> BlockEntityType.Builder.of(SosBadgeSlabBlockEntity::new, HMBlocks.SOS_BADGE_SLAB_BLOCK.get()).build(null));

}
