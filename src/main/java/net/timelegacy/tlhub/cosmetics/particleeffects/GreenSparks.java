package net.timelegacy.tlhub.cosmetics.particleeffects;

import java.util.Random;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class GreenSparks {

  private static Random random = new Random();
  int step;

  public static byte getRandomColor() {
    float f = random.nextFloat();
    if (f > 0.98) {
      return (byte) 2;
    } else if (f > 0.49) {
      return (byte) 1;
    } else {
      return (byte) 15;
    }
  }

  public void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "GREENSPARKS")) {
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
            TLHub.getInstance().core.particleUtils.display(Particle.VILLAGER_HAPPY, center);
          }
          step++;
        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

}