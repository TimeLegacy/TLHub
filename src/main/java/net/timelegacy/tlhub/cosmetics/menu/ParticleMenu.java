package net.timelegacy.tlhub.cosmetics.menu;

import java.util.Collections;
import java.util.List;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlcore.handler.RankHandler;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MenuUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.cosmetics.particles.Particle;
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

public class ParticleMenu implements Listener {

  private final TLHub plugin;

  public ParticleMenu(TLHub plugin) {
    this.plugin = plugin;
  }

  public void openMenu(Player player, int page) {
    Inventory menu = Bukkit.createInventory(player, 54, MessageUtils.colorize("&8&lParticles >> &8&nPage " + page));

    // TODO fix

    // Row 5
    menu.setItem(39, ItemUtils.createItem(Material.ARROW, 1, "&aPrevious Page"));
    menu.setItem(40, ItemUtils.createItem(Material.RED_STAINED_GLASS, 1, "&cReset Particle"));
    menu.setItem(41, ItemUtils.createItem(Material.ARROW, 1, "&aNext Page"));

    // Row 6
    menu.setItem(49, ItemUtils.createItem(Material.ENCHANTING_TABLE, 1, "&eReturn to Cosmetics"));

    player.openInventory(menu);

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

//          List<Cosmetic> particles = new ArrayList<>();
//          for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
//            if (cosmetic.getCosmeticType().equalsIgnoreCase("PARTICLE")) {
//              particles.add(cosmetic);
//            }
//          }
//
//          int current = ((i - 10) + start) - forgotten;
//
//          if (current >= particles.size()) {
//            continue;
//          }

          int current = ((i - 10) + start) - forgotten;

          if (current >= plugin.getCosmeticHandler().getParticles().size()) {
            continue;
          }

          Particle particle = plugin.getCosmeticHandler().getParticles().get(current);

          ItemStack itemStack = particle.getItem();
          ItemStack is = itemStack.clone();

          if (player.hasPermission(particle.getPermissionNode()) || RankHandler.getRank(player.getUniqueId()).getPriority() >= 9) {
            ItemMeta ism = is.getItemMeta();
            List<String> lore = ism.getLore();
            if (CosmeticHandler.particleEnabled(player, particle.getName())) {
              ism.addEnchant(Enchantment.DURABILITY, 1, true);
              lore.add(MessageUtils.colorize("&a&lENABLED!"));
            } else {
              lore.add(MessageUtils.colorize("&a&lUNLOCKED"));
            }

            ism.setLore(lore);
            is.setItemMeta(ism);
          } else {
            is = ItemUtils.createItem(Material.RED_STAINED_GLASS_PANE, "&c&lLOCKED",
                Collections.singletonList("&fUnlock by opening crates."));
          }

          menu.setItem(i, is);
          player.updateInventory();
        }
      }
    }.runTaskAsynchronously(plugin);
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

    String title = ChatColor.stripColor(event.getInventory().getTitle()).replace(" ", "");

    if (title.startsWith("Particles>>Page")) {
      event.setCancelled(true);

      if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MessageUtils.colorize("&eReturn to Cosmetics"))) {
        new CosmeticMenu(plugin).openMenu(player);
        return;
      }

      int pageNumber = Integer.parseInt(title.split("Page")[1]);

      if (event.getCurrentItem().getItemMeta().getDisplayName().equals(MessageUtils.colorize("&cReset Particle"))) {
        if (CosmeticHandler.hasParticle(player)) {
          CosmeticHandler.removeParticle(player);
          MessageUtils.sendMessage(
              player, MessageUtils.ERROR_COLOR + "You have removed your particle cosmetic.", true);
        } else {
          MessageUtils.sendMessage(
              player, MessageUtils.ERROR_COLOR + "You do not have a particle enabled.", true);
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
        double pages = (double) plugin.getCosmeticHandler().getParticles().size() / 21;

        if (pageNumber == MenuUtils.roundUp(pages)) {
          MenuUtils.displayGUIError(
              event.getInventory(),
              event.getSlot(),
              event.getCurrentItem(),
              ItemUtils.createItem(Material.BARRIER, 1, "&cThis is the last page!"),
              3);
        } else {
          openMenu(player, pageNumber + 1);
        }

        return;
      }

      for (Particle particle : plugin.getCosmeticHandler().getParticles()) {
        if (event.getCurrentItem().getItemMeta().getLocalizedName().equals(particle.getName())) {
          CosmeticHandler.setParticle(player, particle.getName());
          MessageUtils.sendMessage(player, "&eYou have set your active particle as " + particle.getDisplayName(), false);
          player.updateInventory();
          player.closeInventory();
          break;
        }
      }

//      for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
//        if (cosmetic.getCosmeticType().equalsIgnoreCase("PARTICLE")) {
//          if (event.getCurrentItem().getType() == cosmetic.getItemStack().getType()) {
//            CosmeticHandler.setParticle(player, cosmetic.getCosmeticIdentifier());
//
//            player.closeInventory();
//
//            MessageUtils.sendMessage(
//                player,
//                MessageUtils.MAIN_COLOR
//                    + "You have set your cosmetic as "
//                    + MessageUtils.SECOND_COLOR
//                    + MessageUtils
//                    .friendlyify(cosmetic.getCosmeticIdentifier().replace("_", " ")),
//                true);
//
//            break;
//          }
//        }
//      }

    }

  }
}
