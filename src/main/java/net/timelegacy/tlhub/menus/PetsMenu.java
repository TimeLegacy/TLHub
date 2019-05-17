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

public class PetsMenu implements Listener {

  private TLHub lobby = TLHub.getInstance();

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      if (event.getInventory().getTitle().equals("Pet Menu")) {
        event.setCancelled(true);

        int i = 0;

        if (event.getCurrentItem().getType() == Material.BARRIER) {
          if (lobby.cosmetics.hasPet(p)) {
            lobby.cosmetics.removePet(p);
            lobby.core.messageUtils.sendMessage(p,
                lobby.core.messageUtils.ERROR_COLOR + "You have removed your current pet.", true);
          } else {
            lobby.core.messageUtils.sendMessage(p,
                lobby.core.messageUtils.ERROR_COLOR + "You do not have a pet enabled.",
                true);
          }
        } else {

          for (Cosmetic cosmetic : lobby.cosmetics.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("PET")) {
              if (event.getCurrentItem().getItemMeta()
                  .equals(cosmetic.getItemStack().getItemMeta())) {
                if (lobby.cosmetics.hasPet(p)) {
                  lobby.cosmetics.removePet(p);
                }

                lobby.cosmetics.setPet(p, cosmetic.getCosmeticIdentifier());

                p.closeInventory();

                lobby.core.messageUtils
                    .sendMessage(p, lobby.core.messageUtils.MAIN_COLOR + "You have set your pet as "
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

    Inventory menu = Bukkit.createInventory(p, 54, "Pet Menu");

    menu.setItem(49,
        lobby.core.itemUtils.createItem(Material.BARRIER, 1, (byte) 0, "&cRemove your pet!",
            "&fClick here to remove your pet."));

    int i = 0;

    for (Cosmetic cosmetic : lobby.cosmetics.getCosmetics()) {
      if (cosmetic.getCosmeticType().equalsIgnoreCase("PET")) {
        i = CosmeticMenu.getI(p, menu, i, cosmetic, lobby);

      }
    }

    p.openInventory(menu);

  }
}
