package net.timelegacy.tlhub.cosmetics.particles;

import net.timelegacy.tlcore.utils.MathUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SantaHat {

  private static int particles = 12;

  private static TLHub plugin = TLHub.getPlugin();

  public static void particleRunnable() {
    Bukkit.getScheduler()
        .scheduleSyncRepeatingTask(
            plugin,
            () -> {
              for (Player p : Bukkit.getOnlinePlayers()) {
                if (CosmeticHandler.particleEnabled(p, "SANTAHAT")) {
                  Location location = p.getEyeLocation().add(0, 0.3, 0);
                  float radius = 0.25f;
                  drawCircle(radius + 0.1f, -0.05f, location, false);
                  for (int i = 0; i < 5; i++) {
                    double x = MathUtils.randomDouble(-0.05, 0.05);
                    double z = MathUtils.randomDouble(-0.05, 0.05);
                    location.add(x, 0.46f, z);
                    ParticleUtils.display(255, 255, 255, location);
                    location.subtract(x, 0.46f, z);
                  }
                  for (float f = 0; f <= 0.4f; f += 0.1f) {
                    if (radius >= 0) {
                      drawCircle(radius, f, location, true);
                      radius -= 0.09f;
                    }
                  }
                }
              }
            },
            0,
            2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

  private static void drawCircle(float radius, float height, Location location, boolean red) {
    for (int i = 0; i < particles; i++) {
      double inc = (2 * Math.PI) / particles;
      float angle = (float) (i * inc);
      float x = MathUtils.cos(angle) * radius;
      float z = MathUtils.sin(angle) * radius;
      location.add(x, height, z);
      ParticleUtils.display(255, red ? 0 : 255, red ? 0 : 255, location);
      location.subtract(x, height, z);
    }
  }
}
