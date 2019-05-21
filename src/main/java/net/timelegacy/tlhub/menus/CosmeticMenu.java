package net.timelegacy.tlhub.menus;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlcore.handler.RankHandler;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cosmetic;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

  public static String centerTitle(String title) {
    return Strings.repeat(" ", 26 - ChatColor.stripColor(title).length()) + MessageUtils
        .colorize(title);
  }


  public static void openMenu(Player player) {
    Inventory inv = Bukkit.createInventory(null, 9 * 6, centerTitle("&8&lCosmetics"));

    // Row 1

    // Row 2
    inv.setItem(10, ItemUtils.createItem(Material.PISTON, 1, "&eGadgets",
        String.join(",", fakeListLore("gadgets", player))));
    inv.setItem(12, ItemUtils.createItem(Material.ELYTRA, 1, "&eParticles",
        String.join(",", fakeListLore("particles", player))));
    inv.setItem(14, ItemUtils.createItem(Material.DIAMOND_HELMET, 1, "&eHats",
        String.join(",", fakeListLore("hats", player))));
    inv.setItem(16, ItemUtils.createItem(Material.ARMOR_STAND, 1, "&eOutfits",
        String.join(",", fakeListLore("outfits", player))));

    // Row 3

    // Row 4
    inv.setItem(30, ItemUtils.createItem(Material.BLACK_BANNER, 1, "&eBanners", "&7Coming Soon"));
    inv.setItem(32, ItemUtils
        .createItem(Material.BONE, 1, "&ePets", String.join(",", fakeListLore("pets", player))));

    // Row 5

    // Row 6
    inv.setItem(49, ItemUtils.createItem(Material.STRUCTURE_VOID, 1, "&cClose Cosmetics"));

    player.openInventory(inv);

  }

  public static List<String> fakeListLore(String type, Player player) {
    List<String> fakeList = new ArrayList<>();
    fakeList.add(
        "&aUnlocked&7: &8(&7"
            + CosmeticHandler.getTotals(player)
            .get("player" + type.substring(0, 1).toUpperCase() + type.substring(1))
            + "/"
            + CosmeticHandler.getTotals(player).get(type)
            + "&8)");

    return fakeList;
  }


  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      if (ChatColor.stripColor(event.getInventory().getTitle()).replace(" ", "")
          .equalsIgnoreCase("Cosmetics")) {
        event.setCancelled(true);

        if (event.getCurrentItem().getType() == Material.PISTON) {
          //todo gadgets
          p.playSound(p.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
        } else if (event.getCurrentItem().getType() == Material.ELYTRA) {
          p.closeInventory();
          ParticleMenu.openMenu(p, 1);
        } else if (event.getCurrentItem().getType() == Material.DIAMOND_HELMET) {
          //todo hats
          p.playSound(p.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
        } else if (event.getCurrentItem().getType() == Material.ARMOR_STAND) {
          //todo outfits
          p.playSound(p.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
        } else if (event.getCurrentItem().getType() == Material.BLACK_BANNER) {
          //todo banners
          p.playSound(p.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
        } else if (event.getCurrentItem().getType() == Material.BONE) {
          p.closeInventory();
          PetsMenu.openMenu(p);
        } else if (event.getCurrentItem().getType() == Material.STRUCTURE_VOID) {
          p.closeInventory();
        }
      }
    }
  }
}
