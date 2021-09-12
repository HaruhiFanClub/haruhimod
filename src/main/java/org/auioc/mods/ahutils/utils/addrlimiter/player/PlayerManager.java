package org.auioc.mods.ahutils.utils.addrlimiter.player;

import java.util.UUID;
import org.auioc.mods.ahutils.server.config.ServerConfig;
import org.auioc.mods.ahutils.utils.addrlimiter.data.AddrManager;
import org.auioc.mods.ahutils.utils.LogUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

public class PlayerManager {
    private static PlayerManager instance;

    private static AddrManager limiter = AddrManager.getInstance();

    private PlayerManager() {}

    public static PlayerManager getInstance() {
        if (PlayerManager.instance == null) {
            PlayerManager.instance = new PlayerManager();
        }
        return PlayerManager.instance;
    }

    public void playerLogin(final PlayerEntity player) {
        UUID uuid = player.getUUID();

        String ipAddress = ((ServerPlayerEntity) player).getIpAddress();

        LogUtil.info("[Login] " + player.getName().getString() + " " + uuid.toString() + " " + ipAddress);

        limiter.add(ipAddress, uuid);
        boolean result = limiter.check(ipAddress, uuid);
        if (!result) {
            ((ServerPlayerEntity) player).connection.disconnect(
                (ITextComponent) new StringTextComponent(
                    "The number of players with the same IP address has reached the limit.\n"
                )
                    .append(
                        new StringTextComponent(
                            String.format(
                                "You can only connect %d times with the same IP!",
                                ServerConfig.MaxPlayerPreAddr.get()
                            )
                        )
                            .setStyle(Style.EMPTY.withColor(TextFormatting.RED))
                    )
            );
        }

    }

    public void playerLogout(final PlayerEntity player) {
        String ipAddress = ((ServerPlayerEntity) player).getIpAddress();

        UUID uuid = player.getUUID();

        LogUtil.info("[Logout] " + player.getName().getString() + " " + uuid + " " + ipAddress);

        limiter.remove(ipAddress, uuid);
    }
}
