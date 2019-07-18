package net.timelegacy.tlhub.cosmetics.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.timelegacy.tlcore.handler.RankHandler;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MenuUtils;
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

  private final TLHub plugin;

  public CosmeticMenu(TLHub plugin) {
    this.plugin = plugin;
  }

  static int getI(Player player, Inventory menu, int i, Cosmetic cosmetic, TLHub lobby) {
    if (menu.getItem(i) == null) {
      if (player.hasPermission(cosmetic.getPerkPerm()) || RankHandler.getRank(player.getUniqueId()).getPriority() >= 9) {
        menu.setItem(i, cosmetic.getItemStack());
      } else {
        menu.setItem(i, ItemUtils.createItem(Material.RED_STAINED_GLASS_PANE, 1,
            "&cUnavailable.",
            "&fUnlock by",
            "&fopening crates."));
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

  public void openMenu(Player player) {
    Inventory inv = Bukkit.createInventory(null, 9 * 6, MenuUtils
        .centerTitle("&8&lCosmetics"));

    // Row 1

    // Row 2
    inv.setItem(10, ItemUtils.createItem(Material.PISTON, 1, "&eGadgets",
        String.join(",", fakeListLore("gadgets", player))));
    inv.setItem(12, ItemUtils.createItem(Material.ELYTRA, 1, "&eParticles",
        String.join(",", fakeListLore("particles", player))));
    inv.setItem(14, ItemUtils.createItemNoAttrib(Material.DIAMOND_HELMET, "&eHats",
        Collections.singletonList(String.join(",", fakeListLore("hats", player)))));
    inv.setItem(16, ItemUtils.createItem(Material.ARMOR_STAND, 1, "&eOutfits", "&7Coming Soon"));

    // Row 3

    // Row 4
    inv.setItem(30, ItemUtils.createItem(Material.BLACK_BANNER, 1, "&eBanners", "&7Coming Soon"));
    inv.setItem(32, ItemUtils.createItem(Material.BONE, 1, "&ePets", "&7Coming Soon"));

    // Row 5

    // Row 6
    inv.setItem(49, ItemUtils.createItem(Material.STRUCTURE_VOID, 1, "&cClose Cosmetics"));

    player.openInventory(inv);
  }

  private List<String> fakeListLore(String type, Player player) {
    plugin.getCosmeticHandler().getGadgets().size();

    List<String> fakeList = new ArrayList<>();
    fakeList.add(
        "&aUnlocked&7: &8(&7"
            + plugin.getCosmeticHandler().getTotals(player)
            .get("player" + type.substring(0, 1).toUpperCase() + type.substring(1))
            + "/"
            + plugin.getCosmeticHandler().getTotals(player).get(type)
            + "&8)");

    return fakeList;
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();

    if (event.getCurrentItem() == null) {
      return;
    }

    if (event.getCurrentItem().getType() == Material.AIR) {
      return;
    }

    if (!MessageUtils.replaceColors(event.getInventory().getTitle().replace(" ", ""))
        .equalsIgnoreCase("Cosmetics")) {
      return;
    }

    event.setCancelled(true);

    if (event.getCurrentItem().getType() == Material.PISTON) {
      player.closeInventory();
      new GadgetsMenu(plugin).openMenu(player, 1);
    } else if (event.getCurrentItem().getType() == Material.ELYTRA) {
      player.closeInventory();
      new ParticleMenu(plugin).openMenu(player, 1);
    } else if (event.getCurrentItem().getType() == Material.DIAMOND_HELMET) {
      player.closeInventory();
      //new HatsCategoriesMenu(plugin).openMenu(player, 1);
      new HatsMenu(plugin).openMenu(player, 1);
    } else if (event.getCurrentItem().getType() == Material.ARMOR_STAND) {
      // todo outfits
      player.playSound(player.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
    } else if (event.getCurrentItem().getType() == Material.BLACK_BANNER) {
      // todo banners
      player.playSound(player.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
    } else if (event.getCurrentItem().getType() == Material.STRUCTURE_VOID) {
      player.closeInventory();
    }
  }
}
