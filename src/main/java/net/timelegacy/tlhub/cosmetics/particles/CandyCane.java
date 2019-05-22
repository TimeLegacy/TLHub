package net.timelegacy.tlhub.cosmetics.particles;

import java.util.Random;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class CandyCane {

  private static Random random = new Random();
  private static int step;

  private static TLHub plugin = TLHub.getPlugin();

  public static void particleRunnable() {
    Bukkit.getScheduler()
        .scheduleSyncRepeatingTask(
            plugin,
            () -> {
              for (Player p : Bukkit.getOnlinePlayers()) {
                if (CosmeticHandler.particleEnabled(p, "CANDYCANE")) {
                  if (step > 360) {
                    step = 0;
                  }
                  Location center = p.getEyeLocation().add(0, 0.6, 0);
                  double inc = (2 * Math.PI) / 20;
                  double angle = step * inc;
                  double x = Math.cos(angle) * 1.1f;
                  double z = Math.sin(angle) * 1.1f;
                  center.add(x, 0, z);
                  for (int i = 0; i < 15; i++) {
                    ParticleUtils.display(Particle.REDSTONE, center);
                  }
                  ParticleUtils.display(Particle.FIREWORKS_SPARK, center);
                  step++;
                }
              }
            },
            0,
            2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }
}
