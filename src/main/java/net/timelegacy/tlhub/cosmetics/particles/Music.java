package net.timelegacy.tlhub.cosmetics.particles;

import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class Music {

  private static TLHub plugin = TLHub.getPlugin();

  public static void particleRunnable() {
    Bukkit.getScheduler()
        .scheduleSyncRepeatingTask(
            plugin,
            () -> {
              for (Player p : Bukkit.getOnlinePlayers()) {
                if (CosmeticHandler.particleEnabled(p, "MUSIC")) {
                  ParticleUtils.display(Particle.NOTE, p.getEyeLocation().add(0, 1, 0));
                }
              }
            },
            0,
            2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }
}
