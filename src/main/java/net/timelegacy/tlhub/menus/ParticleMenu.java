package net.timelegacy.tlhub.menus;

import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cosmetic;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

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
              }
            }
          }

        }
      }
    }
  }

  @SuppressWarnings("deprecation")
  public void openMenu(Player p) {

    Inventory menu = Bukkit.createInventory(p, 54, "Particle Menu");

    menu.setItem(49,
        lobby.core.itemUtils.createItem(Material.BARRIER, 1, (byte) 0, "&cClear your effect!",
            "&fClick here to remove your effect."));

    int i = 0;

    for (Cosmetic cosmetic : lobby.cosmetics.getCosmetics()) {
      if (cosmetic.getCosmeticType().equalsIgnoreCase("PARTICLE")) {
        i = CosmeticMenu.getI(p, menu, i, cosmetic, lobby);

      }
    }

    p.openInventory(menu);

  }

}
