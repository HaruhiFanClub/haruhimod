package org.auioc.mods.ahutils.common.itemgroup;

import org.auioc.mods.ahutils.common.itemgroup.impl.AhUItemGroup;
import org.auioc.mods.ahutils.common.itemgroup.impl.McHiddenItemsGroup;
import net.minecraft.item.ItemGroup;

public class ItemGroupManager {
    public static ItemGroup ahuItemGroup = new AhUItemGroup();
    public static ItemGroup mcHiddenItemsGroup = new McHiddenItemsGroup();
}
