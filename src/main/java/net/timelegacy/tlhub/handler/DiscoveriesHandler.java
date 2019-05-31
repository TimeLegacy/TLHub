package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.datatype.AABB3D;
import net.timelegacy.tlcore.datatype.Polygon;
import net.timelegacy.tlhub.TLHub;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DiscoveriesHandler {
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

            String name = "Unknown";
            String properName = "Unknown";
            List<Vector> vec = new ArrayList<>();
            List<AABB3D> aabb3DList = new ArrayList<>();

            JSONObject boundingBoxes = discovery.getJSONObject(i);
            for (int b = 0; b < boundingBoxes.length(); i++) {

                /*JSONObject names = boundingBoxes.getString(b);
                name = names.getString("formalname");
                properName = names.getString("shortname");*/

                System.out.println(name + " - " + properName);

                List<Double> makeVec = new ArrayList<>();
                JSONArray boxesTwo = discovery.getJSONArray(b);
                for (int bb = 0; bb < boundingBoxes.length(); i++) {
                    JSONObject vecter = boxesTwo.getJSONObject(b);
                    JSONArray vectors = vecter.getJSONArray("boundingBoxes");
                    for (int v = 0; v < vectors.length(); i++) {
                        makeVec.add(vectors.getDouble(v));
                    }
                }
                vec.add(new Vector(makeVec.get(0), makeVec.get(1), makeVec.get(0)));

            }
        }


        //discoveries.put(new Polygon(new AABB3D[]{new AABB3D(new Vector(94, 153.5, -125.5), new Vector(24, 29, 53))}), );

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
                player.sendMessage(discoveries.get(poly).getRight());

                if (!playersDiscoveries.get(player.getUniqueId()).contains(discoveries.get(poly).getLeft())) {
                    playersDiscoveries.get(player.getUniqueId()).add(discoveries.get(poly).getLeft());
                }
                break;
            }
        }
    }
}

