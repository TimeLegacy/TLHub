package net.timelegacy.tlhub.cosmetics.menu;

import de.erethon.headlib.HeadLib;
import java.util.ArrayList;
import java.util.List;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlcore.handler.RankHandler;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MenuUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cosmetic;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class HatsMenu implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  public static void openMenu(Player p, int page) {
    Inventory menu = Bukkit.createInventory(p, 54, MessageUtils.colorize("&8&lHats >> &8&nPage " + page));

    // Row 5
    menu.setItem(39, ItemUtils.createItem(Material.ARROW, 1, "&aPrevious Page"));
    menu.setItem(40, ItemUtils.createItem(Material.RED_STAINED_GLASS, 1, "&cReset Hat"));
    menu.setItem(41, ItemUtils.createItem(Material.ARROW, 1, "&aNext Page"));

    // Row 6
    menu.setItem(49, ItemUtils.createItem(Material.ENCHANTING_TABLE, 1, "&eReturn to Cosmetics"));

    p.openInventory(menu);

    new BukkitRunnable() {

      @Override
      public void run() {
        int start = (page * 21) - 21;
        int forgotten = 0;

        for (int i = 10; i <= 34; i++) {
          if (i == 17 || i == 18 || i == 26 || i == 27) {
            forgotten++;
            continue;
          }

          List<Cosmetic> hats = new ArrayList<>();
          for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("HAT")) {
              hats.add(cosmetic);
            }
          }

          int current = ((i - 10) + start) - forgotten;

          if (current >= hats.size()) {
            continue;
          }

          ItemStack itemStack = hats.get(current).getItemStack();
          ItemStack is = itemStack.clone();

          if (PerkHandler.hasPerk(p.getUniqueId(), hats.get(current).getPerkPerm())
                  || RankHandler.getRank(p.getUniqueId()).getPriority() >= 9) {
            ItemMeta ism = is.getItemMeta();
            List<String> lore = ism.getLore() == null ? new ArrayList<>() : ism.getLore();
            if (HeadLib.getTextureValue(itemStack).equalsIgnoreCase(hats.get(current).getSkullValue())) {
              ism.addEnchant(Enchantment.DURABILITY, 1, true);
              lore.add(MessageUtils.colorize("&a&lENABLED!"));
            } else {
              lore.add(MessageUtils.colorize("&a&lUNLOCKED"));
            }
            ism.setLore(lore);
            is.setItemMeta(ism);
          } else {
            is = ItemUtils.createItem(Material.RED_STAINED_GLASS_PANE, 1, "&c&lLOCKED", "&fUnlock by opening crates.");
          }

          menu.setItem(i, is);
          p.updateInventory();
        }
      }
    }.runTaskAsynchronously(plugin);
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      String title = ChatColor.stripColor(event.getInventory().getTitle()).replace(" ", "");

      if (title.startsWith("Hats>>Page")) {
        event.setCancelled(true);

        int i = 0;

        if (event
            .getCurrentItem()
            .getItemMeta()
            .getDisplayName()
            .equals(MessageUtils.colorize("&eReturn to Cosmetics"))) {
          CosmeticMenu.openMenu(player);
          return;
        }

        int pageNumber = Integer.parseInt(title.split("Page")[1]);

        if (event
            .getCurrentItem()
            .getItemMeta()
            .getDisplayName()
            .equals(MessageUtils.colorize("&cReset Hat"))) {
          if (player.getInventory().getHelmet() != null) {
            player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
            MessageUtils.sendMessage(
                player, MessageUtils.ERROR_COLOR + "You have removed your hat cosmetic.", true);
          } else {
            MessageUtils.sendMessage(
                player, MessageUtils.ERROR_COLOR + "You do not have a hat enabled.", true);
          }
          return;
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MessageUtils.colorize("&aPrevious Page"))) {
          if (pageNumber == 1) {
            MenuUtils.displayGUIError(
                event.getInventory(),
                event.getSlot(),
                event.getCurrentItem(),
                ItemUtils.createItem(Material.BARRIER, 1, "&cThis is the first page!"),
                3);
            return;
          } else {
            openMenu(player, pageNumber - 1);
            return;
          }
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MessageUtils.colorize("&aNext Page"))) {
          double pages = (double) CosmeticHandler.getTotals(player).get("hats") / 21;

          if (pageNumber == MenuUtils.roundUp(pages)) {
            MenuUtils.displayGUIError(
                event.getInventory(),
                event.getSlot(),
                event.getCurrentItem(),
                ItemUtils.createItem(Material.BARRIER, 1, "&cThis is the last page!"),
                3);
            return;
          } else {
            openMenu(player, pageNumber + 1);
            return;
          }
        } else {

          for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("HAT")) {
              if (ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())
                  .equalsIgnoreCase(
                      ChatColor.stripColor(
                          cosmetic.getItemStack().getItemMeta().getDisplayName()))) {

                player.closeInventory();

                player.getInventory().setHelmet(cosmetic.getItemStack());

                MessageUtils.sendMessage(
                    player,
                    MessageUtils.MAIN_COLOR
                        + "You have set your hat as "
                        + MessageUtils.SECOND_COLOR
                        + MessageUtils
                        .friendlyify(cosmetic.getCosmeticIdentifier().replace("_", " ")),
                    true);

                break;
              }
            }
          }
        }
      }
    }
  }
}
