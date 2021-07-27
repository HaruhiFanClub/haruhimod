package com.haruhifanclub.mods.haruhicore.common.block.impl;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LightBlock extends Block {
    public LightBlock() {
        super(AbstractBlock.Properties.of(Material.BARRIER));
    }
}
