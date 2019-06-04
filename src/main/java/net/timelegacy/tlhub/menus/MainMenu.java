package net.timelegacy.tlhub.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MainMenu implements Listener {

  public static void openMenu(Player p) {
    Inventory mainMenu = Bukkit.createInventory(null, 54, "Main Menu");

    p.openInventory(mainMenu);
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      if (event.getInventory().getTitle().equals("Main Menu")) {
        event.setCancelled(true);

        // todo
      }
    }
  }
}
