package net.timelegacy.tlhub.cosmetics.gadgets;

import net.timelegacy.tlcore.utils.FireworkUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

public class Firecracker implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  private ArrayList<UUID> pickup = new ArrayList<>();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    String gadgetName = "FIRECRACKER";
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
    if (event.getAction() == Action.RIGHT_CLICK_AIR
        || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

      if (p.getInventory().getItemInMainHand() != null) {
        ItemStack inHand = p.getInventory().getItemInMainHand();

        if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
            .contains(gadgetName.replace("_", " ").toLowerCase())) {
          event.setCancelled(true);

          if (Cooldown.hasCooldown(p.getUniqueId(), gadgetName)) {
            MessageUtils.sendMessage(
                p, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
                    .getTimeLeft(p.getUniqueId(), gadgetName)
                    + (Cooldown.getTimeLeft(p.getUniqueId(), gadgetName) > 1 ? " seconds"
                    : " second") +
                    " before doing that again.", true);
            return;
          }

          ItemStack is2 = inHand.clone();
          is2.setAmount(1);
          Item i = p.getWorld().dropItem(p.getLocation(), is2);
          i.setVelocity(p.getLocation().clone().add(0.0D, 1.5D, 0.0D).getDirection().normalize());
          pickup.add(i.getUniqueId());

          new BukkitRunnable() {

            @Override
            public void run() {
              if (!i.isDead()) {
                i.getWorld()
                    .spawnParticle(
                        Particle.FLAME,
                        i.getLocation().getX(),
                        i.getLocation().getY() + 0.3,
                        i.getLocation().getZ(),
                        1,
                        0D,
                        0D,
                        0D,
                        0D);
              } else {
                cancel();
              }
            }
          }.runTaskTimerAsynchronously(plugin, 0, 1);

          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
              new Runnable() {
                public void run() {
                  i.remove();

                  FireworkUtils.spawnFirework(i.getLocation(), 1);
                }
              },
              3 * 20);

          new Cooldown(
              p.getUniqueId(),
              gadgetName,
              5)
              .start();
        }
      }
    }
  }

  @EventHandler
  public void onPlayerPickupItem(PlayerPickupItemEvent e) {
    if (pickup.contains(e.getItem().getUniqueId())) {
      e.setCancelled(true);
    }
  }

  @EventHandler
  public void onItemDespawn(ItemDespawnEvent e) {
    if (pickup.contains(e.getEntity().getUniqueId())) {
      e.setCancelled(true);
    }
  }


}
