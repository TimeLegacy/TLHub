package net.timelegacy.tlhub.cosmetics.gadgets;

import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class SheepBomb implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    String gadgetName = "SHEEP_BOMB";
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

          new BukkitRunnable() {
            double time = 3.0;

            @Override
            public void run() {
              World world = p.getWorld();
              Sheep sheep = world.spawn(p.getLocation(), Sheep.class);
              sheep.setNoDamageTicks(100000);
              sheep.setMetadata("NOSHEAR4U", new FixedMetadataValue(plugin, "NOSHEAR4U"));
              sheep.setVelocity(p.getEyeLocation().getDirection().multiply(0.7D));

              new BukkitRunnable() {
                boolean red = true;

                @Override
                public void run() {
                  if (time < 0.5) {
                    world.spawnParticle(Particle.EXPLOSION_HUGE, sheep.getLocation(), 2);
                    world.playSound(sheep.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
                    sheep.remove();
                    cancel();
                    return;
                  }

                  if (red) {
                    sheep.setColor(DyeColor.RED);
                  } else {
                    sheep.setColor(DyeColor.WHITE);
                  }

                  world.playSound(sheep.getLocation(), Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, 1,
                      1);

                  red = !red;
                  time -= 0.2;
                }
              }.runTaskTimer(plugin, 0, 5);
            }
          }.runTaskLater(plugin, 1);

          new Cooldown(
              p.getUniqueId(),
              gadgetName,
              5)
              .start();
        }
      }
    }
  }

}
