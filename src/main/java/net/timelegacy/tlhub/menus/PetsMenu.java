package net.timelegacy.tlhub.menus;

import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cosmetic;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PetsMenu implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @SuppressWarnings("deprecation")
  public static void openMenu(Player p) {

    Inventory menu = Bukkit.createInventory(p, 54, "Pet Menu");

    menu.setItem(49,
        ItemUtils.createItem(Material.BARRIER, 1, (byte) 0, "&cRemove your pet!",
            "&fClick here to remove your pet."));

    int i = 0;

    for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
      if (cosmetic.getCosmeticType().equalsIgnoreCase("PET")) {
        i = CosmeticMenu.getI(p, menu, i, cosmetic, plugin);

      }
    }

    p.openInventory(menu);

  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (event.getCurrentItem() != null) {

      if (event.getInventory().getTitle().equals("Pet Menu")) {
        event.setCancelled(true);

        int i = 0;

        if (event.getCurrentItem().getType() == Material.BARRIER) {
          if (CosmeticHandler.hasPet(p)) {
            CosmeticHandler.removePet(p);
            MessageUtils.sendMessage(p,
                MessageUtils.ERROR_COLOR + "You have removed your current pet.", true);
          } else {
            MessageUtils.sendMessage(p,
                MessageUtils.ERROR_COLOR + "You do not have a pet enabled.",
                true);
          }
        } else {

          for (Cosmetic cosmetic : CosmeticHandler.getCosmetics()) {
            if (cosmetic.getCosmeticType().equalsIgnoreCase("PET")) {
              if (event.getCurrentItem().getItemMeta()
                  .equals(cosmetic.getItemStack().getItemMeta())) {
                if (CosmeticHandler.hasPet(p)) {
                  CosmeticHandler.removePet(p);
                }

                CosmeticHandler.setPet(p, cosmetic.getCosmeticIdentifier());

                p.closeInventory();

                MessageUtils
                    .sendMessage(p, MessageUtils.MAIN_COLOR + "You have set your pet as "
                        + MessageUtils.SECOND_COLOR + MessageUtils
                        .friendlyify(cosmetic.getCosmeticIdentifier()), true);
              }
            }
          }

        }
      }
    }
  }
}
