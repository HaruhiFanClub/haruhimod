package org.auioc.mods.ahutils.utils.game;

import java.util.HashMap;
import net.minecraft.util.DamageSource;

public class DamageSourceUtils {
    public static HashMap<String, DamageSource> map = new HashMap<String, DamageSource>();

    static {
        {
            map.put("inFire", DamageSource.IN_FIRE);
            map.put("lightningBolt", DamageSource.LIGHTNING_BOLT);
            map.put("onFire", DamageSource.ON_FIRE);
            map.put("lava", DamageSource.LAVA);
            map.put("hotFloor", DamageSource.HOT_FLOOR);
            map.put("inWall", DamageSource.IN_WALL);
            map.put("cramming", DamageSource.CRAMMING);
            map.put("drown", DamageSource.DROWN);
            map.put("starve", DamageSource.STARVE);
            map.put("cactus", DamageSource.CACTUS);
            map.put("fall", DamageSource.FALL);
            map.put("flyIntoWall", DamageSource.FLY_INTO_WALL);
            map.put("outOfWorld", DamageSource.OUT_OF_WORLD);
            map.put("generic", DamageSource.GENERIC);
            map.put("magic", DamageSource.MAGIC);
            map.put("wither", DamageSource.WITHER);
            map.put("anvil", DamageSource.ANVIL);
            map.put("fallingBlock", DamageSource.FALLING_BLOCK);
            map.put("dragonBreath", DamageSource.DRAGON_BREATH);
            map.put("dryout", DamageSource.DRY_OUT);
            map.put("sweetBerryBush", DamageSource.SWEET_BERRY_BUSH);
        }
    };
}
