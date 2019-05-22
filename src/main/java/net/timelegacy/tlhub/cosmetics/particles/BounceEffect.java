package net.timelegacy.tlhub.cosmetics.particles;

import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BounceEffect implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  public static void bounceEffect(Player p) {
    final Player player = p;
    new BukkitRunnable() {
      double t = Math.PI / 2;
      Location loc = player.getLocation();

      public void run() {
        t = t + 0.1 * Math.PI;
        for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
          double x = t * Math.cos(theta);
          double y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 0.5;
          double z = t * Math.sin(theta);
          loc.add(x, y, z);

          ParticleUtils.display(Particle.FIREWORKS_SPARK, loc);

          loc.subtract(x, y, z);

          theta = theta + Math.PI / 32;

          x = t * Math.cos(theta);
          y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 0.5;
          z = t * Math.sin(theta);
          loc.add(x, y, z);

          ParticleUtils.display(Particle.FIREWORKS_SPARK, loc);

          loc.subtract(x, y, z);
        }
        if (t > 5) {
          this.cancel();
        }
      }
    }.runTaskTimer(plugin, 0, 1);

    p.setVelocity(new Vector(0, 1, 0));

    // TODO fix
  }

  @EventHandler
  public void onSneak(PlayerToggleSneakEvent e) {
    Player p = e.getPlayer();

    if (e.isSneaking()) {
      if (CosmeticHandler.particleEnabled(p, "BOUNCE")) {
        if (p.isOnGround()) {
          if (CosmeticHandler.hasCooldown(p, "BOUNCE")) {
            MessageUtils.sendMessage(
                p, MessageUtils.ERROR_COLOR + "You must wait before doing that again.", true);

          } else {
            CosmeticHandler.addCooldown(p, 10, "BOUNCE");
            bounceEffect(p);
          }
        } else {
          MessageUtils.sendMessage(
              p, MessageUtils.ERROR_COLOR + "You must be on the ground to do that.", true);
        }
      }
    }
  }
}
