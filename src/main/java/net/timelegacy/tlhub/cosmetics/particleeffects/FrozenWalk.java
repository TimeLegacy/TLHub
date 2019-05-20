package net.timelegacy.tlhub.cosmetics.particleeffects;

import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class FrozenWalk {

  private static TLHub plugin = TLHub.getPlugin();

  public static Vector getLeftVector(Location loc) {
    final float newX = (float) (loc.getX() + (1 * Math.cos(Math.toRadians(loc.getYaw() + 0))));
    final float newZ = (float) (loc.getZ() + (1 * Math.sin(Math.toRadians(loc.getYaw() + 0))));
    return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
  }

  public static Vector getRightVector(Location loc) {
    final float newX = (float) (loc.getX() + (-1 * Math.cos(Math.toRadians(loc.getYaw() + 0))));
    final float newZ = (float) (loc.getZ() + (-1 * Math.sin(Math.toRadians(loc.getYaw() + 0))));
    return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
  }

  public static void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

      // swap this with snow walk to and make this one spawn snow then revert it after using packets

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (CosmeticHandler.particleEnabled(p, "FROZENWALK")) {
          Vector vectorLeft = getLeftVector(p.getLocation()).normalize().multiply(0.15);
          Vector vectorRight = getRightVector(p.getLocation()).normalize().multiply(0.15);
          Location locationLeft = p.getLocation().add(vectorLeft);
          Location locationRight = p.getLocation().add(vectorRight);
          locationLeft.setY(p.getLocation().getY());
          locationRight.setY(p.getLocation().getY());

          ParticleUtils.display(Particle.FIREWORKS_SPARK, locationLeft);
          ParticleUtils.display(Particle.FIREWORKS_SPARK, locationRight);
        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }


}
