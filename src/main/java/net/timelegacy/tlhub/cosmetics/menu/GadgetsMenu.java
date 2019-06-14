package net.timelegacy.tlhub.cosmetics.menu;

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

public class GadgetsMenu implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  public static void openMenu(Player p, int page) {
    Inventory menu = Bukkit.createInventory(p, 54, MessageUtils.colorize("&8&lGadgets >> &8&nPage " + page));

    // Row 5
    menu.setItem(39, ItemUtils.createItem(Material.ARROW, 1, "&aPrevious Page"));
    menu.setItem(40, ItemUtils.createItem(Material.RED_STAINED_GLASS, 1, "&cReset Gadget"));
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

          List<Cosmetic> gadgets = new ArrayList<>();
          for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("GADGET")) {
              gadgets.add(cosmetic);
            }
          }

          int current = ((i - 10) + start) - forgotten;

          if (current >= gadgets.size()) {
            continue;
          }

          ItemStack itemStack = gadgets.get(current).getItemStack();
          ItemStack is = itemStack.clone();

          if (PerkHandler.hasPerk(p.getUniqueId(), gadgets.get(current).getPerkPerm()) || RankHandler.getRank(p.getUniqueId()).getPriority() >= 9) {
            ItemMeta ism = is.getItemMeta();
            List<String> lore = ism.getLore() == null ? new ArrayList<>() : ism.getLore();
            if (p.getInventory().getItem(5) != null &&
                ChatColor.stripColor(p.getInventory().getItem(5).getItemMeta().getDisplayName())
                    .equals(ChatColor.stripColor(
                        gadgets.get(current).getItemStack().getItemMeta().getDisplayName()))) {
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
    Player p = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      String title = ChatColor.stripColor(event.getInventory().getTitle()).replace(" ", "");

      if (title.startsWith("Gadgets>>Page")) {
        event.setCancelled(true);

        int i = 0;

        if (event
            .getCurrentItem()
            .getItemMeta()
            .getDisplayName()
            .equals(MessageUtils.colorize("&eReturn to Cosmetics"))) {
          CosmeticMenu.openMenu(p);
          return;
        }

        int pageNumber = Integer.parseInt(title.split("Page")[1]);

        if (event
            .getCurrentItem()
            .getItemMeta()
            .getDisplayName()
            .equals(MessageUtils.colorize("&cReset Gadget"))) {
          if (p.getInventory().getItem(5) != null) {

            p.getInventory().setItem(5, new ItemStack(Material.AIR, 1));
            p.updateInventory();

            MessageUtils.sendMessage(
                p, MessageUtils.ERROR_COLOR + "You have removed your gadget cosmetic.", true);
          } else {
            MessageUtils.sendMessage(
                p, MessageUtils.ERROR_COLOR + "You do not have a gadget enabled.", true);
          }
          return;
        }

        if (event
            .getCurrentItem()
            .getItemMeta()
            .getDisplayName()
            .equals(MessageUtils.colorize("&aPrevious Page"))) {
          if (pageNumber == 1) {
            MenuUtils
                .displayGUIError(
                event.getInventory(),
                event.getSlot(),
                event.getCurrentItem(),
                ItemUtils.createItem(Material.BARRIER, 1, "&cThis is the first page!"),
                3);
            return;
          } else {
            openMenu(p, pageNumber - 1);
            return;
          }
        }

        if (event
            .getCurrentItem()
            .getItemMeta()
            .getDisplayName()
            .equals(MessageUtils.colorize("&aNext Page"))) {
          double pages = (double) CosmeticHandler.getTotals(p).get("gadgets") / 21;

          if (pageNumber == MenuUtils.roundUp(pages)) {
            MenuUtils.displayGUIError(
                event.getInventory(),
                event.getSlot(),
                event.getCurrentItem(),
                ItemUtils.createItem(Material.BARRIER, 1, "&cThis is the last page!"),
                3);
            return;
          } else {
            openMenu(p, pageNumber + 1);
            return;
          }
        } else {

          for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("GADGET")) {
              if (ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())
                  .equalsIgnoreCase(
                      ChatColor.stripColor(
                          cosmetic.getItemStack().getItemMeta().getDisplayName()))) {
                ItemStack item = ItemUtils.createItem(cosmetic.getItemStack().getType(),
                    1, "&e" + ChatColor
                        .stripColor(cosmetic.getItemStack().getItemMeta().getDisplayName())
                        + " &8{&7Right Click&8}");

                p.getInventory().setItem(5, item);
                p.updateInventory();

                p.closeInventory();

                MessageUtils.sendMessage(
                    p,
                    MessageUtils.MAIN_COLOR
                        + "You have set your gadget as "
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
