package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.datatype.Polygon;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class DiscoveriesHandler {
    private static int discoveriesTotal;
    private static HashMap<UUID, Integer> playersDiscoveries = new HashMap<UUID, Integer>();
    private static HashMap<String, Polygon> discoveries = new HashMap<>();

    public static void setupDiscoveries() {
        //TODO load discoveries from config
        discoveriesTotal = 23;
    }

    public static void loadPlayerData(Player player) {
        //TODO get players Discoveries from the database
        if (player.getName().equals("piajesse")) {
            playersDiscoveries.put(player.getUniqueId(), 22);
        } else {
            playersDiscoveries.put(player.getUniqueId(), 0);
        }
    }

    public static int getTotalAvailableDiscoveries() {
        return discoveriesTotal;
    }

    public static int getDiscoveries(Player player) {
        return playersDiscoveries.get(player.getUniqueId());
    }
}
