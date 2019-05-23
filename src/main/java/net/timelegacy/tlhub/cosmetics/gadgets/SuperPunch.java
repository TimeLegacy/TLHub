package net.timelegacy.tlhub.cosmetics.gadgets;

import net.timelegacy.tlhub.TLHub;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SuperPunch implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void onSuperPunchInteract(EntityDamageByEntityEvent e) {
    if (!(e.getDamager() instanceof Player)) {
      return;
    }

    if (!(e.getEntity() instanceof Player)) {
      return;
    }

    String gadgetName = "SUPER_PUNCH";

    Player player = (Player) e.getDamager();

    ItemStack inHand = player.getInventory().getItemInMainHand();

    if (!inHand.hasItemMeta()) {
      return;
    }

    if (!player.getInventory().getItemInMainHand().hasItemMeta()) {
      return;
    }

    if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
        .contains(gadgetName.replace("_", " ").toLowerCase())) {
      return;
    }

    Player target = (Player) e.getEntity();

    e.setCancelled(true);
    e.setDamage(0);

    target.teleport(target.getLocation().add(0, 0.5, 0));
    target.setVelocity(player.getLocation().getDirection().multiply(9));
  }


}
