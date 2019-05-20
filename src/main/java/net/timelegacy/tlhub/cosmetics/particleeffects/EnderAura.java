package net.timelegacy.tlhub.cosmetics.particleeffects;

import java.util.ArrayList;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class EnderAura {

  public static void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (CosmeticHandler.particleEnabled(p, "ENDERAURA")) {
          Location center = p.getLocation().add(0, 2, 0);
          World world = center.getWorld();
          double increment = (2 * Math.PI) / 16;
          ArrayList<Location> locations = new ArrayList<Location>();
          for (int i = 0; i < 16; i++) {
            double angle = i * increment;
            double x = center.getX() + (0.4 * Math.cos(angle));
            double z = center.getZ() + (0.4 * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
          }
          for (Location l : locations) {
            ParticleUtils.display(Particle.SPELL_WITCH, l);
          }
        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

}
