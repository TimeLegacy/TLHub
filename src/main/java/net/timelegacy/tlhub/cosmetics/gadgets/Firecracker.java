package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.ArrayList;
import java.util.UUID;
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

public class Firecracker implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  private ArrayList<UUID> pickup = new ArrayList<>();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player player = event.getPlayer();

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

    if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    if (player.getInventory().getItemInMainHand() == null) {
      return;
    }

    ItemStack inHand = player.getInventory().getItemInMainHand();

    if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
        .contains(gadgetName.replace("_", " ").toLowerCase())) {
      event.setCancelled(true);

      if (Cooldown.hasCooldown(player.getUniqueId(), gadgetName)) {
        MessageUtils.sendMessage(
            player, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
                .getTimeLeft(player.getUniqueId(), gadgetName)
                + (Cooldown.getTimeLeft(player.getUniqueId(), gadgetName) > 1 ? " seconds"
                : " second") +
                " before doing that again.", true);
        return;
      }

      ItemStack is2 = inHand.clone();
      is2.setAmount(1);
      Item i = player.getWorld().dropItem(player.getLocation(), is2);
      i.setVelocity(player.getLocation().clone().add(0.0D, 1.5D, 0.0D).getDirection().normalize());
      pickup.add(i.getUniqueId());

      new BukkitRunnable() {

        @Override
        public void run() {
          if (i.isDead()) {
            cancel();
          }

          i.getWorld().spawnParticle(Particle.FLAME,
              i.getLocation().getX(), i.getLocation().getY() + 0.3, i.getLocation().getZ(),
              1,
              0D,
              0D,
              0D,
              0D);

        }
      }.runTaskTimerAsynchronously(plugin, 0, 1);

      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
          new Runnable() {
            public void run() {
              i.remove();

              FireworkUtils.spawnFirework(i.getLocation(), 1);
            }
          }, 3 * 20);

      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
    }

  }

  @EventHandler
  public void onPlayerPickupItem(PlayerPickupItemEvent event) {
    if (pickup.contains(event.getItem().getUniqueId())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onItemDespawn(ItemDespawnEvent event) {
    if (pickup.contains(event.getEntity().getUniqueId())) {
      event.setCancelled(true);
    }
  }


}
