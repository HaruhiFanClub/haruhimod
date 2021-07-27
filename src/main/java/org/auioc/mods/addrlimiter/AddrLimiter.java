package org.auioc.mods.addrlimiter;

import org.auioc.mods.addrlimiter.config.Config;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(AddrLimiter.MOD_ID)
public class AddrLimiter {
    public static final String MOD_ID = "addrlimiter";

    public AddrLimiter() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }
}
