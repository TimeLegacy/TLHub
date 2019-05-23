package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.ArrayList;
import java.util.List;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BatLauncher implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    String gadgetName = "BAT_LAUNCHER";

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

          Vector direction = p.getEyeLocation().getDirection();

          Bat bat1 =
              (Bat)
                  p
                      .getWorld()
                      .spawnEntity(
                          p.getLocation().add(0, 1, 0).setDirection(direction), EntityType.BAT);
          Bat bat2 =
              (Bat)
                  p
                      .getWorld()
                      .spawnEntity(
                          p.getLocation().add(0, 1, 0).setDirection(direction), EntityType.BAT);
          Bat bat3 =
              (Bat)
                  p
                      .getWorld()
                      .spawnEntity(
                          p.getLocation().add(0, 1, 0).setDirection(direction), EntityType.BAT);
          Bat bat4 =
              (Bat)
                  p
                      .getWorld()
                      .spawnEntity(
                          p.getLocation().add(0, 1, 0).setDirection(direction), EntityType.BAT);
          Bat bat5 =
              (Bat)
                  p
                      .getWorld()
                      .spawnEntity(
                          p.getLocation().add(0, 1, 0).setDirection(direction), EntityType.BAT);
          Bat bat6 =
              (Bat)
                  p
                      .getWorld()
                      .spawnEntity(
                          p.getLocation().add(0, 1, 0).setDirection(direction), EntityType.BAT);

          List<Bat> bats = new ArrayList<>();
          bats.add(bat1);
          bats.add(bat2);
          bats.add(bat3);
          bats.add(bat4);
          bats.add(bat5);
          bats.add(bat6);

          direction.multiply(2);

          for (Bat bat : bats) {
            bat.setVelocity(direction);
          }

          new BukkitRunnable() {

            @Override
            public void run() {
              bat1.remove();
              bat2.remove();
              bat3.remove();
              bat4.remove();
              bat5.remove();
              bat6.remove();
            }
          }.runTaskLaterAsynchronously(plugin, 20 * 7);

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
