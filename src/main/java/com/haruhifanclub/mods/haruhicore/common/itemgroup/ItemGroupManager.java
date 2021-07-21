package com.haruhifanclub.mods.haruhicore.common.itemgroup;

import com.haruhifanclub.mods.haruhicore.HaruhiCore;
import com.haruhifanclub.mods.haruhicore.common.itemgroup.impl.MainItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HaruhiCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemGroupManager {
    public static ItemGroup itemGroup = new MainItemGroup();

}
