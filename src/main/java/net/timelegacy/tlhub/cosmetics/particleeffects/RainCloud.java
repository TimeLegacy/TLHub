package net.timelegacy.tlhub.cosmetics.particleeffects;

import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class RainCloud {

  public void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "RAINCLOUD")) {

          TLHub.getInstance().core.particleUtils
              .display(Particle.CLOUD, p.getEyeLocation().add(0, 1, 0), 10, 0);
          TLHub.getInstance().core.particleUtils
              .display(Particle.WATER_DROP, p.getEyeLocation().add(0, 1, 0));

        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

}
