package net.timelegacy.tlhub.menus;

import java.util.ArrayList;
import java.util.List;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cosmetic;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleMenu implements Listener {

  TLHub lobby = TLHub.getInstance();

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      if (event.getInventory().getTitle().equals("Particle Menu")) {
        event.setCancelled(true);

        int i = 0;

        if (event.getCurrentItem().getType() == Material.BARRIER) {
          if (lobby.cosmetics.hasParticle(p)) {
            lobby.cosmetics.removeParticle(p);
            lobby.core.messageUtils.sendMessage(p,
                lobby.core.messageUtils.ERROR_COLOR + "You have removed your current cosmetic.",
                true);
          } else {
            lobby.core.messageUtils.sendMessage(p,
                lobby.core.messageUtils.ERROR_COLOR + "You do not have a cosmetic enabled.",
                true);
          }
        } else {

          for (Cosmetic cosmetic : lobby.cosmetics.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("PARTICLE")) {
              if (event.getCurrentItem().getType() == cosmetic.getItemStack().getType()) {
                lobby.cosmetics.setParticle(p, cosmetic.getCosmeticIdentifier());

                p.closeInventory();

                lobby.core.messageUtils.sendMessage(p,
                    lobby.core.messageUtils.MAIN_COLOR + "You have set your cosmetic as "
                        + lobby.core.messageUtils.SECOND_COLOR + lobby.core.messageUtils
                        .friendlyify(cosmetic.getCosmeticIdentifier()), true);

                break;
              }
            }
          }

        }
      }
    }
  }

  @SuppressWarnings("deprecation")
  public void openMenu(Player p, int page) {

    Inventory menu = Bukkit.createInventory(p, 54, "Particle Menu");

    int start = (page * 21) - 21;
    int forgotten = 0;

    for (int i = 10; i <= 34; i++) {
      if (i == 17 || i == 18 || i == 26 || i == 27) {
        forgotten++;
        continue;
      }

      int current = ((i - 10) + start) - forgotten;

      ItemStack is;
      is = lobby.core.itemUtils.createItem(Material.RED_STAINED_GLASS_PANE, 1, "&cLoading...");
      menu.setItem(i, is);
    }

    //TODO fix

    // Row 5
    /*menu.setItem(39, ItemUtils.createItem(Material.ARROW, Utils.color("&aPrevious Page")));
    menu.setItem(40, ItemUtils.createItem(Material.RED_STAINED_GLASS, Utils.color("&cReset Trail")));
    menu.setItem(41, ItemUtils.createItem(Material.ARROW, Utils.color("&aNext Page")));*/

    // Row 6
    //menu.setItem(49, ItemUtils.createItem(Material.ENCHANTING_TABLE, Utils.color("&eReturn to Cosmetics")));

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

          List<Cosmetic> particles = new ArrayList<>();
          for (Cosmetic cosmetic : lobby.cosmetics.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("PARTICLE")) {
              particles.add(cosmetic);
            }
          }

          int current = ((i - 10) + start) - forgotten;

          if (current >= particles.size()) {
            continue;
          }

          ItemStack itemStack = particles.get(current).getItemStack();
          ItemStack is = itemStack.clone();
          ItemMeta ism = is.getItemMeta();

          if (lobby.core.perkHandler.hasPerk(p, particles.get(current).getPerkPerm())) {
            ism.getLore().add(lobby.core.messageUtils.c("&a&lUNLOCKED"));
          } else {
            is = lobby.core.itemUtils.createItem(Material.RED_STAINED_GLASS_PANE, 1, "&c&lLOCKED",
                "&fUnlock by opening crates.");
          }

          is.setItemMeta(ism);

          //todo check if player has one and make it glow to show they have it enabled.

          menu.setItem(i, is);
          p.updateInventory();
        }
      }
    }.runTaskAsynchronously(TLHub.getInstance());


  }


}
