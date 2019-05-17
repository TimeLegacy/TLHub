package net.timelegacy.tlhub.cosmetics.particleeffects;

import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class BloodHelix {

  public void particleRunnable() {

    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), () -> {

      double i = 0;

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (TLHub.getInstance().cosmetics.particleEnabled(p, "BLOODHELIX")) {
          Location location = p.getLocation();
          Location location2 = location.clone();
          double radius = 1.1d;
          double radius2 = 1.1d;
          double particles = 100;

          for (int step = 0; step < 100; step += 4) {
            double interval = (2 * Math.PI) / particles;
            double angle = step * interval + i;
            Vector v = new Vector();
            v.setX(Math.cos(angle) * radius);
            v.setZ(Math.sin(angle) * radius);
            TLHub.getInstance().core.particleUtils.display(255, 0, 0, location.add(v));
            location.subtract(v);
            location.add(0, 0.12d, 0);
            radius -= 0.044f;
          }
          for (int step = 0; step < 100; step += 4) {
            double interval = (2 * Math.PI) / particles;
            double angle = step * interval + i + 3.5;
            Vector v = new Vector();
            v.setX(Math.cos(angle) * radius2);
            v.setZ(Math.sin(angle) * radius2);
            TLHub.getInstance().core.particleUtils.display(255, 0, 0, location.add(v));
            location2.subtract(v);
            location2.add(0, 0.12d, 0);
            radius2 -= 0.044f;
          }
          i += 0.05;
        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

}
