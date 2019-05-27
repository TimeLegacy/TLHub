package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.datatype.AABB3D;
import net.timelegacy.tlcore.datatype.Polygon;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DiscoveriesHandler {
    private static HashMap<UUID, ArrayList<String>> playersDiscoveries = new HashMap<>();
    private static HashMap<Polygon, String> discoveries = new HashMap<>();

    public static void setupDiscoveries() {
        //TODO load discoveries from config
        discoveries.put(new Polygon(new AABB3D[]{new AABB3D(new Vector(94, 153.5, -125.5), new Vector(24, 29, 53))}), "irascastle");

    }

    public static void playerJoin(Player player) {
        //TODO get players Discoveries from the database
        if (!playersDiscoveries.containsKey(player.getUniqueId())) {
            playersDiscoveries.put(player.getUniqueId(), new ArrayList<>());
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().contains(player)) {
                    discoveryMagic(player);
                } else {
                    cancel();
                }
            }
        }.runTaskTimerAsynchronously(TLHub.getPlugin(), 0, 5);

    }

    public static int getTotalAvailableDiscoveries() {
        return discoveries.size();
    }

    public static int getExploredDiscoveries(Player player) {
        return playersDiscoveries.get(player.getUniqueId()).size();
    }

    private static void discoveryMagic(Player player) {
        for (Polygon poly : discoveries.keySet().toArray(new Polygon[discoveries.size()])) {


            if (Polygon.isInside(poly, AABB3D.getPlayersAABB(player))) {
                player.sendMessage(discoveries.get(poly));

                if (!playersDiscoveries.get(player.getUniqueId()).contains(discoveries.get(poly))) {
                    playersDiscoveries.get(player.getUniqueId()).add(discoveries.get(poly));
                }
                break;
            }
        }
    }
}

