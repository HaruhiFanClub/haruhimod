package com.haruhifanclub.mods.haruhicore.common.block.impl;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DanchouConeBlock extends Block {
    public DanchouConeBlock() {
        super(
            AbstractBlock.Properties
                .of(Material.HEAVY_METAL)
        );
    }
}
