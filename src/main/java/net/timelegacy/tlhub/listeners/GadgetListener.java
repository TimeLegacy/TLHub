package net.timelegacy.tlhub.listeners;

import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.gadgets.Gadget;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class GadgetListener implements Listener {

  private final TLHub plugin;

  public GadgetListener(TLHub plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    ItemStack is = event.getItem();

    if (is == null) {
      return;
    }

    if (is.getType() == Material.AIR) {
      return;
    }

    if (!is.hasItemMeta()) {
      return;
    }

    if (!is.getItemMeta().hasDisplayName()) {
      return;
    }

    if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    Player player = event.getPlayer();

    if (player.getInventory().getHeldItemSlot() != 5) {
      return;
    }

    if (player.getInventory().getItemInMainHand() == null) {
      return;
    }

    for (Gadget gadget : plugin.getCosmeticHandler().getGadgets()) {
      if (is.getItemMeta().getLocalizedName().equals(gadget.getName())) {
        event.setCancelled(true);
        gadget.doAbility(event);
        break;
      }
    }

  }

  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent event) {
    System.out.println("Damage Pass 1");

    if (!(event.getDamager() instanceof Player)) {
      return;
    }

    System.out.println("Damage Pass 2");

    if (!(event.getEntity() instanceof Player)) {
      return;
    }

    System.out.println("Damage Pass 3");

    Player player = (Player) event.getDamager();

    ItemStack is = player.getInventory().getItemInMainHand();

    if (is == null) {
      return;
    }

    System.out.println("Damage Pass 4");

    if (is.getType() == Material.AIR) {
      return;
    }

    System.out.println("Damage Pass 5");

    if (!is.hasItemMeta()) {
      return;
    }

    System.out.println("Damage Pass 6");

    if (!is.getItemMeta().hasDisplayName()) {
      return;
    }

    System.out.println("Damage Pass 7");

    for (Gadget gadget : plugin.getCosmeticHandler().getGadgets()) {
      if (gadget.getName().contains(MessageUtils.replaceColors(is.getItemMeta().getDisplayName()))) {
        event.setCancelled(true);
        gadget.doAbility(event);
        break;
      }
    }

    System.out.println("Damage Pass 8");
  }

}
