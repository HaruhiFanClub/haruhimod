package org.auioc.mods.ahutils.utils.addrlimiter.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.auioc.mods.ahutils.server.config.ServerConfig;
import org.auioc.mods.ahutils.utils.LogUtil;

public class AddrManager {
    private static AddrManager instance;

    private AddrManager() {}

    public static AddrManager getInstance() {
        if (AddrManager.instance == null) {
            AddrManager.instance = new AddrManager();
        }
        return AddrManager.instance;
    }

    private Integer maxPlayerPreAddr = 1;

    private final Map<String, AddrMap> addrMap =
        Collections.synchronizedMap(new HashMap<String, AddrMap>());

    public void setLimit(Integer limit) {
        this.maxPlayerPreAddr = limit;
    }

    public Integer getLimit() {
        return this.maxPlayerPreAddr;
    }

    public final void add(String address, UUID uuid) {
        LogUtil.debug(String.format("Adding player %s to address: %s", uuid.toString(), address));

        if (!addrMap.containsKey(address)) {
            AddrMap map = new AddrMap();
            map.setLastSeen(System.currentTimeMillis());
            map.addOnlineUser(uuid);
            addrMap.put(address, map);
        } else {
            AddrMap map = addrMap.get(address);
            map.setLastSeen(System.currentTimeMillis());
            map.addOnlineUser(uuid);
            addrMap.put(address, map);
        }
    }

    public final void remove(String address, UUID uuid) {
        if (addrMap.containsKey(address)) {

            LogUtil.debug(String.format("Removing player %s from address: %s", uuid.toString(), address));
            AddrMap map = addrMap.get(address);

            map.removeOnlineUser(uuid);

            if (map.getOnlineUserCount() == 0) {
                addrMap.remove(address);
            }

            addrMap.put(address, map);
        }
    }

    public final boolean check(String address, UUID uuid) {
        if (addrMap.containsKey(address)) {
            AddrMap map = addrMap.get(address);

            if ((ServerConfig.EnableAddrWhitelist.get()) && (ServerConfig.AddrWhitelist.get().contains(address))) {
                LogUtil.info(String.format("Address %s is in the whitelist", address));
                return true;
            }

            // if (map.getOnlineUserCount() > 0) {
            if ((map.getOnlineUserCount()) > (ServerConfig.MaxPlayerPreAddr.get())) {
                LogUtil.warn("Reached the limit on the maximum number of player at same address");
                return false;
            }

            return true;
        }
        return true;
    }

    public final Map<String, AddrMap> dump() {
        return addrMap;
    }

}
