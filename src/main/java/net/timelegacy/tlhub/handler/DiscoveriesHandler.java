package net.timelegacy.tlhub.handler;

import de.Herbystar.TTA.TTA_Methods;
import net.timelegacy.tlcore.datatype.AABB3D;
import net.timelegacy.tlcore.datatype.Polygon;
import net.timelegacy.tlcore.datatype.Zone;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlhub.TLHub;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DiscoveriesHandler {
    private static HashMap<UUID, String> playersCurrentArea = new HashMap<>();
    private static HashMap<UUID, ArrayList<String>> playersDiscoveries = new HashMap<>();
    private static HashMap<Polygon, Pair<String, String>> discoveries = new HashMap<>();

    public static void setupDiscoveries() {
        //TODO load discoveries from config
        String resourceName = "/discoveries.json";
        InputStream is = TLHub.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);

        JSONArray discovery = object.getJSONArray("discoveries");
        for (int i = 0; i < discovery.length(); i++) {
            JSONObject discoveryObject = discovery.getJSONObject(i);

            System.out.println(discoveryObject.getString("formalname"));
            System.out.println(discoveryObject.getString("shortname"));

            JSONArray boundingBoxes = discoveryObject.getJSONArray("boundingboxes");
            for (int b = 0; b < boundingBoxes.length(); b++) {
                JSONArray boundingBoxesJSONArray = boundingBoxes.getJSONArray(b);

                for (int bb = 0; bb < boundingBoxesJSONArray.length(); bb++) {
                    JSONArray locations = boundingBoxesJSONArray.getJSONArray(bb);

                    for (int loc = 0; loc < locations.length(); loc++) {
                        //get the 3 location coords
                        double locz = locations.getDouble(loc);
                        System.out.println(locz);
                    }
                }
            }
            AABB3D[] polyArray = new AABB3D[poly.size()];
            polyArray = poly.toArray(polyArray);
            discoveriesList.add(new Zone(d.getString("shortname"), d.getString("formalname"), new Polygon(polyArray)));
        }

        //discoveries.put(new Polygon(new AABB3D[]{new AABB3D(new Vector(94, 153.5, -125.5), new Vector(24, 29, 53))}), );

    }

    public static void playerJoin(Player player) {
        //TODO get players Discoveries from the database
        if (!playersDiscoveries.containsKey(player.getUniqueId())) {
            playersDiscoveries.put(player.getUniqueId(), new ArrayList<>());
        }
        String[] perks = PerkHandler.getPerks(player.getName()).split(",");

        for (String perk : perks) {
            if (perk.startsWith("LOBBY.DISCOVERY.")) {
                playersDiscoveries.get(player.getUniqueId()).add(perk.replace("LOBBY.DISCOVERY.", "").toLowerCase());
            }
        }
        playersCurrentArea.put(player.getUniqueId(), "");

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
        for (Zone z : discoveries) {
            if (playersCurrentArea.get(player.getUniqueId()).equals("")) {
                if (Polygon.isInside(z.getBoundingBoxes(), AABB3D.getPlayersAABB(player))) {
                    playersCurrentArea.remove(player.getUniqueId());
                    playersCurrentArea.put(player.getUniqueId(), z.getShortName());
                    TTA_Methods.createBossBar(player, ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + "Discovered Area" + ChatColor.WHITE + " | " + ChatColor.YELLOW + ChatColor.ITALIC + z.getFormalname(), 1.0, BarStyle.SOLID, BarColor.PURPLE, null, true);
                    if (!playersDiscoveries.get(player.getUniqueId()).contains(z.getShortName())) {
                        playersDiscoveries.get(player.getUniqueId()).add(z.getShortName());
                        PerkHandler.addPerk(player.getName(), "LOBBY.DISCOVERY." + z.getShortName());
                        ScoreboardHandler.updateDiscoveries(player);
                        TTA_Methods.sendTitle(player, ChatColor.DARK_PURPLE + z.getFormalname(), 0, 40, 10, ChatColor.YELLOW + ChatColor.ITALIC.toString() + "Discovered", 0, 40, 10);
                    }
                    break;
                }
            } else if (z.getShortName().equals(playersCurrentArea.get(player.getUniqueId()))) {
                if (!Polygon.isInside(z.getBoundingBoxes(), AABB3D.getPlayersAABB(player))) {
                    playersCurrentArea.remove(player.getUniqueId());
                    playersCurrentArea.put(player.getUniqueId(), "");
                    TTA_Methods.removeBossBar(player);
                    discoveryMagic(player);
                }
            }
        }
    }
}

