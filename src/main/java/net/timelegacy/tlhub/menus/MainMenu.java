package net.timelegacy.tlhub.menus;

import net.timelegacy.tlcore.TLCore;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MainMenu implements Listener {

  TLCore core = TLCore.getInstance();

  private TLHub lobby = TLHub.getInstance();

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      if (event.getInventory().getTitle().equals("Main Menu")) {
        event.setCancelled(true);

        //todo
      }
    }
  }

  public void openMenu(Player p) {
    Inventory mainMenu = Bukkit.createInventory(null, 54, "Main Menu");

    p.openInventory(mainMenu);
  }

}
