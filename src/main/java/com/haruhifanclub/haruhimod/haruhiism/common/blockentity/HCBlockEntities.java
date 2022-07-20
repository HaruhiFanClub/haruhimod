package com.haruhifanclub.haruhimod.haruhiism.common.blockentity;

import com.haruhifanclub.haruhimod.haruhiism.HaruhiCore;
import com.haruhifanclub.haruhimod.haruhiism.common.block.HCBlocks;
import com.haruhifanclub.haruhimod.haruhiism.common.blockentity.impl.SosBadgeSlabBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HCBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, HaruhiCore.MOD_ID);


    public static final RegistryObject<BlockEntityType<SosBadgeSlabBlockEntity>> SOS_BADGE_SLAB_BLOCK_ENTITY =
        BLOCK_ENTITIES.register("sos_badge_slab", () -> BlockEntityType.Builder.of(SosBadgeSlabBlockEntity::new, HCBlocks.SOS_BADGE_SLAB_BLOCK.get()).build(null));

}
