package net.timelegacy.tlhub.handler;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.timelegacy.tlcore.TLCore;
import net.timelegacy.tlhub.TLHub;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//This class was made by Braden Nicholson on June 14th, 2018

public class GameMenuHandler implements Listener {

  public HashMap<String, Inventory> menus = new HashMap<String, Inventory>();
  TLHub lobby = TLHub.getInstance();

  public Inventory createGameMenu(String name) {
    String newName = lobby.core.messageUtils.friendlyify(name);
    Inventory inv = Bukkit.createInventory(null, 27, lobby.core.messageUtils.c(newName));
    menus.put(name, inv);
    return inv;
  }

  public Inventory getGameMenu(String name) {
    return menus.get(name);
  }

  public void removeGameMenu(String name) {
    menus.remove(name);
  }

  public void initialize() {

    List<String> type = new ArrayList<>();
    type.add("BEDWARS");
    type.add("SURVIVALGAMES");
    type.add("MAGMARUNNER");
    type.add("CHROMATICA");

    for (String t : type) {
      createGameMenu(t.toUpperCase());
    }

  }

  @SuppressWarnings("deprecation")
  public void updateInv() {

    Bukkit.getScheduler().scheduleAsyncRepeatingTask(lobby, () -> {
      if (Bukkit.getOnlinePlayers().size() > 0) {
        for (Map.Entry<String, Inventory> menu : lobby.gameMenus.menus.entrySet()) {

          try {
            int i = 0;

            HashMap<String, Integer> menus = new HashMap<>();
            for (Map.Entry<String, Inventory> map : lobby.gameMenus.menus.entrySet()) {
              int count = (int) TLCore.getInstance().mongoDB.servers
                  .count(Filters.eq("game", map.getKey()));

              if (count > 0) {
                for (int cou = count; cou < map.getValue().getSize(); cou++) {
                  map.getValue().setItem(cou, new ItemStack(Material.AIR, 1));
                }
                MongoCursor<Document> cursor = TLCore.getInstance().mongoDB.servers
                    .find(Filters.eq("game", map.getKey())).iterator();
                while (cursor.hasNext()) {
                  Document doc = cursor.next();

                  String serverName = doc.getString("uid");
                  String gameType = doc.getString("type");
                  String gameName = doc.getString("game");

                  lobby.gameMenus.getGameMenu(menu.getKey())
                      .setItem(i++, createItem(serverName, gameName, gameType));
                }

                cursor.close();
                i = 0;
              } else {
                map.getValue().clear();
              }

            }

          } catch (Exception e) {
            //System.out.println(e);
          }
        }
      }
    }, 0L, 2 * 20);
  }

  private ItemStack createItem(String server, String gameName, String gameType) {
    List<String> lore = new ArrayList<String>();

    ItemStack is = new ItemStack(Material.LEGACY_STAINED_CLAY, 1);
    ItemMeta im = is.getItemMeta();

    im.setDisplayName(server);

    switch (lobby.core.serverHandler.getState(server)) {
      case "WAITING":
        is.setDurability((short) 5);
        lore.add("§a§oWaiting...");
        break;

      case "STARTING":
        is.setDurability((short) 13);
        lore.add("§2§oStarting...");
        break;

      case "FULL":
        is.setDurability((short) 3);
        lore.add("§b§oFull...");
        break;

      case "INGAME":
        is.setDurability((short) 9);
        lore.add("§7§oIn Game...");
        break;

      default:
        is.setDurability((short) 14);
        lore.add("§4§oRestarting...");
        break;

    }

    lore.add("");
    lore.add(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&oGame: " +
        lobby.core.messageUtils.SECOND_COLOR + gameName));
    lore.add(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&oType: " +
        lobby.core.messageUtils.SECOND_COLOR + gameType));
    lore.add(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&oPlayers: " +
        lobby.core.messageUtils.SECOND_COLOR +
        lobby.core.serverHandler.getOnlinePlayers(server) + lobby.core.messageUtils.MAIN_COLOR + "/"
        +
        lobby.core.messageUtils.SECOND_COLOR + lobby.core.serverHandler.getMaxPlayers(server)));
    lore.add(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&oMap: " +
        lobby.core.messageUtils.SECOND_COLOR + lobby.core.serverHandler.getMap(server)));

    im.setLore(lore);
    is.setItemMeta(im);

    return is;
  }

  private void sendToServer(String server, Player p) {

    p.closeInventory();

    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);

    try {
      out.writeUTF("Connect");
      out.writeUTF(server);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    p.sendPluginMessage(lobby, "BungeeCord", b.toByteArray());
  }

  @EventHandler
  public void onClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (lobby.gameMenus.menus.containsKey(event.getInventory().getName().toUpperCase())) {
      event.setCancelled(true);
      if (event.getCurrentItem() == null) {
        p.closeInventory();
        return;
      }
      if (!event.getCurrentItem().hasItemMeta()) {
        p.closeInventory();
        return;
      }
      if (event.getCurrentItem().hasItemMeta() && !event.getCurrentItem().getItemMeta().hasLore()) {
        p.closeInventory();
        return;
      }

      String name = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

      switch (lobby.core.serverHandler.getState(name)) {
        case "WAITING":
          try {
            sendToServer(name, p);
          } catch (Exception e) {
            lobby.core.messageUtils.sendMessage(p,
                lobby.core.messageUtils.ERROR_COLOR + "Error contacting server. Please try later.",
                true);
          }
          break;

        case "STARTING":
          try {
            sendToServer(name, p);
          } catch (Exception e) {
            lobby.core.messageUtils.sendMessage(p,
                lobby.core.messageUtils.ERROR_COLOR + "Error contacting server. Please try later.",
                true);
          }
          break;

        case "FULL":
          lobby.core.messageUtils.sendMessage(p,
              lobby.core.messageUtils.ERROR_COLOR + "This server is currently full. Please wait.",
              true);
          break;

        case "INGAME":
          lobby.core.messageUtils.sendMessage(p,
              lobby.core.messageUtils.ERROR_COLOR + "This server is currently ingame.",
              true);
          break;

        default:
          lobby.core.messageUtils.sendMessage(p,
              lobby.core.messageUtils.ERROR_COLOR + "Server restarting... Please try later.",
              true);
          break;

      }

      p.closeInventory();
    }
  }


}
