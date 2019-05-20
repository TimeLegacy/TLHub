package net.timelegacy.tlhub.cosmetics.particleeffects;

import net.timelegacy.tlcore.utils.MathUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Cone {

  private static int particles = 12;

  public static void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (CosmeticHandler.particleEnabled(p, "CONE")) {
          Location location = p.getEyeLocation().add(0, 0.3, 0);
          float radius = 0.25f;
          drawCircle(radius + 0.1f, -0.05f, location);
          for (float f = 0; f <= 0.4f; f += 0.1f) {
            if (radius >= 0) {
              drawCircle(radius, f, location);
              radius -= 0.09f;
            }
          }
        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

  private static void drawCircle(float radius, float height, Location location) {
    for (int i = 0; i < particles; i++) {
      double inc = (2 * Math.PI) / particles;
      float angle = (float) (i * inc);
      float x = MathUtils.cos(angle) * radius;
      float z = MathUtils.sin(angle) * radius;
      location.add(x, height, z);
      ParticleUtils.display(255, 255, 255, location);
      location.subtract(x, height, z);
    }
  }

}
