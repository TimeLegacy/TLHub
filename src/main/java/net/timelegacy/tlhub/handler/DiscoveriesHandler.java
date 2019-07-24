package net.timelegacy.tlhub.handler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import net.timelegacy.tlcore.datatype.AABB3D;
import net.timelegacy.tlcore.datatype.Polyhedron;
import net.timelegacy.tlcore.datatype.Zone;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DiscoveriesHandler {

  private static HashMap<UUID, BossBar> playersBossBar = new HashMap<>();
  private static HashMap<UUID, String> playersCurrentArea = new HashMap<>();
  private static HashMap<UUID, ArrayList<String>> playersDiscoveries = new HashMap<>();
  private static HashMap<UUID, Double> playersBossBarStatus = new HashMap<>();
  public static Zone[] discoveries;
  private static Zone spawnArea =
      new Zone(
          "spawn",
          "spawn",
          new Polyhedron(0.5, 122, 12.5,23, 20, 45));

  public static void setupDiscoveries() {
    // TODO load discoveries from config
    String resourceName = "/discoveries.json";
    InputStream is = TLHub.class.getResourceAsStream(resourceName);
    if (is == null) {
      throw new NullPointerException("Cannot find resource file " + resourceName);
    }

    JSONTokener tokener = new JSONTokener(is);
    JSONObject object = new JSONObject(tokener);

    JSONArray discoveriesJson = object.getJSONArray("discoveries");
    ArrayList<Zone> discoveriesList = new ArrayList<>();

    for (int i = 0; i < discoveriesJson.length(); i++) {
      ArrayList<AABB3D> poly = new ArrayList<>();
      JSONObject d = discoveriesJson.getJSONObject(i);
      JSONArray boundingBoxes = d.getJSONArray("boundingboxes");

      for (int ii = 0; ii < boundingBoxes.length(); ii++) {
        JSONArray center = boundingBoxes.getJSONArray(ii).getJSONArray(0);
        JSONArray size = boundingBoxes.getJSONArray(ii).getJSONArray(1);
        poly.add(
            new AABB3D(
                new Vector(center.getDouble(0), center.getDouble(1), center.getDouble(2)),
                new Vector(size.getDouble(0), size.getDouble(1), size.getDouble(2))));
      }
      AABB3D[] polyArray = new AABB3D[poly.size()];
      polyArray = poly.toArray(polyArray);
      discoveriesList.add(
          new Zone(d.getString("shortname"), d.getString("formalname"), new Polyhedron(polyArray)));
    }

    discoveries = new Zone[discoveriesList.size()];
    discoveries = (discoveriesList.toArray(discoveries));
  }

  public static void playerJoin(Player player) {
    // TODO get players Discoveries from the database
    if (!playersDiscoveries.containsKey(player.getUniqueId())) {
      playersDiscoveries.put(player.getUniqueId(), new ArrayList<>());
    }

    List<String> perks = PerkHandler.getPerks(player.getUniqueId());

    for (String perk : perks) {
      if (perk.startsWith("lobby.discovery.")) {
        playersDiscoveries
            .get(player.getUniqueId())
            .add(perk.replace("lobby.discovery.", "").toLowerCase());
      }
    }
    playersBossBarStatus.put(player.getUniqueId(), 0d);
    playersCurrentArea.put(player.getUniqueId(), "spawn");
  }

  public static void playerLeave(Player player) {
    playersDiscoveries.remove(player.getUniqueId());
    playersCurrentArea.remove(player.getUniqueId());
    playersBossBar.remove(player.getUniqueId());
    playersBossBarStatus.remove(player.getUniqueId());
  }

  public static int getTotalAvailableDiscoveries() {
    return discoveries.length;
  }

  public static int getExploredDiscoveries(Player player) {
    return playersDiscoveries.get(player.getUniqueId()).size();
  }

  private static String repeatNTimes(String s, int n) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      builder.append(s);
    }

    return builder.toString();
  }

  public static void discoveryMagic(Player player) {
    if (Polyhedron.isInside(spawnArea.getBoundingBoxes(), AABB3D.getPlayersAABB(player))) {
      setBossBar(player, " ", "spawn");
      return;
    }
    for (Zone zone : discoveries) {
      if (playersCurrentArea.get(player.getUniqueId()).equals("wild")) {
        if (Polyhedron.isInside(zone.getBoundingBoxes(), AABB3D.getPlayersAABB(player))) {
          setBossBar(
              player,
              ChatColor.LIGHT_PURPLE
                  + ChatColor.ITALIC.toString()
                  + "Discovered Area"
                  + ChatColor.WHITE
                  + " | "
                  + ChatColor.YELLOW
                  + ChatColor.ITALIC
                  + zone.getFormalname(),
              zone.getShortName());
          if (!playersDiscoveries.get(player.getUniqueId()).contains(zone.getShortName())) {
            playersDiscoveries.get(player.getUniqueId()).add(zone.getShortName());
            PerkHandler.addPerk(player.getUniqueId(), "lobby.discovery." + zone.getShortName());
            ScoreboardHandler.updateDiscoveries(player);
            new BukkitRunnable() {
              int spaceCount = 10;

              @Override
              public void run() {
                spaceCount--;
                String title = "";
                String subTitle = "";

                char[] titleChars = zone.getFormalname().toCharArray();
                for (char titleChar : titleChars) {
                  title = title + repeatNTimes(" ", spaceCount) + titleChar;
                }
                char[] subTitleChars = ("Discovered").toCharArray();
                for (char subTitleChar : subTitleChars) {
                  subTitle = subTitle + repeatNTimes(" ", spaceCount) + subTitleChar;
                }
                player.sendTitle(
                    ChatColor.LIGHT_PURPLE + title,
                    ChatColor.YELLOW + ChatColor.ITALIC.toString() + subTitle,
                    1,
                    45,
                    20);

                if (spaceCount == 0) {
                  cancel();
                }
              }
            }.runTaskTimerAsynchronously(TLHub.getPlugin(), 0, 1);
          }
          return;
        }
      } else if (zone.getShortName().equals(playersCurrentArea.get(player.getUniqueId()))) {
        if (!Polyhedron.isInside(zone.getBoundingBoxes(), AABB3D.getPlayersAABB(player))) {
          setBossBar(player, ChatColor.YELLOW + ChatColor.ITALIC.toString() + "Wilderness", "wild");
          discoveryMagic(player);
        }
        return;
      }
    }

    setBossBar(player, ChatColor.YELLOW + ChatColor.ITALIC.toString() + "Wilderness", "wild");
  }

  private static void setBossBar(Player player, String display, String shortName) {
    UUID uuid = player.getUniqueId();
    if (playersCurrentArea.get(uuid).equals(shortName)) {
      return;
    }
    if (playersBossBar.get(uuid) != null) {
      playersBossBar.get(uuid).removePlayer(player);
    }
    if (display.equals("")) {
      return;
    }

    playersBossBar.put(uuid, Bukkit.createBossBar(display, BarColor.PURPLE, BarStyle.SOLID));
    playersBossBar.get(uuid).setProgress(playersBossBarStatus.get(uuid) / 60);
    playersBossBar.get(uuid).addPlayer(player);
    playersCurrentArea.put(uuid, shortName);

    new BukkitRunnable() {
      String last = playersCurrentArea.get(uuid);

      @Override
      public void run() {
        if (playersCurrentArea.get(uuid) == null || !playersCurrentArea.get(uuid).equals(last)) {
          cancel();
        }
        if (playersCurrentArea.get(uuid) == "spawn") {

          playersBossBarStatus.put(uuid, playersBossBarStatus.get(uuid) - 1);
          if (playersBossBarStatus.get(uuid) <= 0) {
            playersBossBarStatus.put(uuid, 1d);
            playersBossBar.get(uuid).removePlayer(player);
            playersCurrentArea.put(uuid, shortName);
            cancel();
          }
          playersBossBar.get(uuid).setProgress(playersBossBarStatus.get(uuid) / 60d);
          return;
        }

        if (playersBossBarStatus.get(uuid) < 60) {
          playersBossBarStatus.put(uuid, playersBossBarStatus.get(uuid) + 1);
          playersBossBar.get(uuid).setProgress(playersBossBarStatus.get(uuid) / 60d);
        } else {
          playersBossBarStatus.put(uuid, 60d);
          playersBossBar.get(uuid).setProgress(1);
          cancel();
        }
      }
    }.runTaskTimerAsynchronously(TLHub.getPlugin(), 0, 1);
  }

  public static Zone[] getDiscoveries() {
    return discoveries;
  }
}
