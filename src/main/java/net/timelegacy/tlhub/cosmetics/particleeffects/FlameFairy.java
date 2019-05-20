package net.timelegacy.tlhub.cosmetics.particleeffects;

import java.util.Random;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class FlameFairy {

  private static double randomDouble(double min, double max) {
    return Math.random() < 0.5 ? ((1 - Math.random()) * (max - min) + min)
        : (Math.random() * (max - min) + min);
  }

  public static void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      Vector targetDirection = new Vector(1, 0, 0);

      double noMoveTime = 0, movementSpeed = 0.2d;

      Random random = new Random();

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (CosmeticHandler.particleEnabled(p, "FLAMEFAIRY")) {

          Location target = p.getEyeLocation().add(Math.random() * 6 - 3, Math.random() * 1.5,
              Math.random() * 6 - 3);

          Location currentLocation = p.getEyeLocation();

          double distanceBtw = p.getEyeLocation().distance(currentLocation);
          double distTarget;

          distTarget = currentLocation.distance(target);

          if (random.nextDouble() > 0.98) {
            noMoveTime = System.currentTimeMillis() + randomDouble(0, 2000);
          }

          if (p.getEyeLocation().distance(currentLocation) < 3) {
            movementSpeed = noMoveTime > System.currentTimeMillis()
                ? Math.max(0, movementSpeed - 0.0075)
                : Math.min(0.1, movementSpeed + 0.0075);
          } else {
            noMoveTime = 0;
            movementSpeed = Math.min(0.15 + distanceBtw * 0.05, movementSpeed + 0.02);
          }

          targetDirection
              .add(target.toVector().subtract(currentLocation.toVector()).multiply(0.2));

          if (targetDirection.length() < 1) {
            movementSpeed = targetDirection.length() * movementSpeed;
          }

          targetDirection = targetDirection.normalize();

          if (distTarget > 0.1) {
            currentLocation.add(targetDirection.clone().multiply(movementSpeed));
          }

          ParticleUtils.display(Particle.LAVA, currentLocation);
          ParticleUtils.display(Particle.FLAME, currentLocation);

        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

}
