package org.auioc.mods.ahutils.utils.addrlimiter.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class AddrMap {
    private List<UUID> onlineUsers = new ArrayList<UUID>();
    private long lastSeen;

    public void setOnlineUsers(List<UUID> onlineUsers) {
        this.onlineUsers = onlineUsers;
    }

    public void addOnlineUser(UUID uuid) {
        this.onlineUsers.add(uuid);
    }

    public void removeOnlineUser(UUID uuid) {
        Iterator<UUID> iterator = this.onlineUsers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(uuid)) {
                iterator.remove();
            }

        }
    }

    public List<UUID> getOnlineUsers() {
        return onlineUsers;
    }

    public int getOnlineUserCount() {
        return onlineUsers.size();
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public long getLastSeen() {
        return lastSeen;
    }
}
