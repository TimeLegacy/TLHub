package net.timelegacy.tlhub.cosmetics.particleeffects;

import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class Walks {

  public static void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (CosmeticHandler.particleEnabled(p, "SNOWWALK")) {

          ParticleUtils
              .display(Particle.CLOUD, p.getEyeLocation().add(0, -1.5, 0), 10, 0);


        }
        if (CosmeticHandler.particleEnabled(p, "FIREWALK")) {

          ParticleUtils
              .display(Particle.FLAME, p.getEyeLocation().add(0, -1.5, 0), 100, 0);


        }
        if (CosmeticHandler.particleEnabled(p, "PORTALWALK")) {

          ParticleUtils
              .display(Particle.PORTAL, p.getEyeLocation().add(0, -1.5, 0), 1000, 0);


        }
        if (CosmeticHandler.particleEnabled(p, "CRITICALWALK")) {

          ParticleUtils
              .display(Particle.CRIT, p.getEyeLocation().add(0, -1.5, 0), 100, 0);


        }
        if (CosmeticHandler.particleEnabled(p, "MAGICWALK")) {

          ParticleUtils
              .display(Particle.SPELL_WITCH, p.getEyeLocation().add(0, -1.5, 0), 100, 0);


        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }
}
