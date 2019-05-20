package net.timelegacy.tlhub.menus;

import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlcore.handler.RankHandler;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cosmetic;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class CosmeticMenu implements Listener {

  static int getI(Player p, Inventory menu, int i, Cosmetic cosmetic, TLHub lobby) {
    if (menu.getItem(i) == null) {
      if (PerkHandler.hasPerk(p.getName(), cosmetic.getPerkPerm())
          || RankHandler.getRank(p.getName()).getPriority() >= 9) {
        menu.setItem(i, cosmetic.getItemStack());
      } else {
        menu.setItem(i, ItemUtils.createItem(Material.RED_STAINED_GLASS_PANE, 1,
            "&cUnavailable.", "&fUnlock by", "&fopening crates."));
      }
      i++;
    } else {
      while (menu.getItem(i) != null) {
        i++;
      }
      menu.setItem(i, cosmetic.getItemStack());
      i++;
    }
    return i;
  }

  public static void openMenu(Player p) {
    Inventory inv = Bukkit.createInventory(null, 9, "Cosmetic Menu");

    //345
    inv.setItem(3, ItemUtils
        .createItem(Material.REDSTONE, 1, MessageUtils.SECOND_COLOR + "Particles",
            MessageUtils.MAIN_COLOR + "Show off your particles!"));
    inv.setItem(4, ItemUtils
        .createItem(Material.EGG, 1, MessageUtils.SECOND_COLOR + "Pets",
            MessageUtils.MAIN_COLOR + "Everyone loves your fluffy/scary pets!"));
    inv.setItem(5, ItemUtils.createItem(Material.FLOWER_POT, 1,
        MessageUtils.SECOND_COLOR + "Hats (Coming Soon)",
        MessageUtils.MAIN_COLOR + "Got a new hat?"));

    inv.setItem(8, ItemUtils.createItem(Material.DIRT, 1,
        MessageUtils.SECOND_COLOR + "&kGadgets &r(Coming Soon)",
        MessageUtils.MAIN_COLOR + "Got a new hat?"));
    p.openInventory(inv);
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      if (event.getInventory().getTitle().equals("Cosmetic Menu")) {
        event.setCancelled(true);

        if (event.getCurrentItem().getType() == Material.REDSTONE) {
          p.closeInventory();
          ParticleMenu.openMenu(p, 1);
        } else if (event.getCurrentItem().getType() == Material.EGG) {
          p.closeInventory();
          PetsMenu.openMenu(p);

        } else if (event.getCurrentItem().getType() == Material.FLOWER_POT) {
          p.playSound(p.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
        }
      }
    }
  }
}
