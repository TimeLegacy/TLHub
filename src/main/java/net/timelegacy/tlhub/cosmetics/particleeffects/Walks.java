package net.timelegacy.tlhub.cosmetics.particleeffects;

import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class Walks {

  public void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "SNOWWALK")) {

          TLHub.getInstance().core.particleUtils
              .display(Particle.CLOUD, p.getEyeLocation().add(0, -1.5, 0), 10, 0);


        }
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "FIREWALK")) {

          TLHub.getInstance().core.particleUtils
              .display(Particle.FLAME, p.getEyeLocation().add(0, -1.5, 0), 100, 0);


        }
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "PORTALWALK")) {

          TLHub.getInstance().core.particleUtils
              .display(Particle.PORTAL, p.getEyeLocation().add(0, -1.5, 0), 1000, 0);


        }
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "CRITICALWALK")) {

          TLHub.getInstance().core.particleUtils
              .display(Particle.CRIT, p.getEyeLocation().add(0, -1.5, 0), 100, 0);


        }
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "MAGICWALK")) {

          TLHub.getInstance().core.particleUtils
              .display(Particle.SPELL_WITCH, p.getEyeLocation().add(0, -1.5, 0), 100, 0);


        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }
}
