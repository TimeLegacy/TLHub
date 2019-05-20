package net.timelegacy.tlhub.cosmetics.particleeffects;

import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class AngelWings {

  private static TLHub plugin = TLHub.getPlugin();

  static boolean x = true;
  static boolean o;
  private static boolean[][] shape = {
      {o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
      {o, x, x, x, x, o, o, o, o, o, o, o, x, x, x, x, o, o},
      {o, o, x, x, x, x, x, o, o, o, x, x, x, x, x, o, o, o},
      {o, o, o, x, x, x, x, x, x, x, x, x, x, x, o, o, o, o},
      {o, o, o, o, x, x, x, x, x, x, x, x, x, o, o, o, o, o},
      {o, o, o, o, x, x, x, x, o, x, x, x, x, o, o, o, o, o},
      {o, o, o, o, o, x, x, x, o, x, x, x, o, o, o, o, o, o},
      {o, o, o, o, o, x, x, o, o, o, x, x, o, o, o, o, o, o},
      {o, o, o, o, x, x, o, o, o, o, o, x, x, o, o, o, o, o}
  };

  public static Vector rotateAroundAxisY(Vector v, double angle) {
    double x, z, cos, sin;
    cos = Math.cos(angle);
    sin = Math.sin(angle);
    x = v.getX() * cos + v.getZ() * sin;
    z = v.getX() * -sin + v.getZ() * cos;
    return v.setX(x).setZ(z);
  }

  public static Vector getBackVector(Location loc) {
    final float newZ = (float) (loc.getZ() + (1 * Math.sin(Math.toRadians(loc.getYaw() + 90))));
    final float newX = (float) (loc.getX() + (1 * Math.cos(Math.toRadians(loc.getYaw() + 90))));
    return new Vector(newX - loc.getX(), 0, newZ - loc.getZ());
  }

  public static void particleRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

      for (Player p : Bukkit.getOnlinePlayers()) {
        if (CosmeticHandler.particleEnabled(p, "ANGELWINGS")) {
          Location location = p.getLocation();

          double space = 0.2;
          double defX = location.getX() - (space * shape[0].length / 2) + space;
          double x = defX;
          double y = location.clone().getY() + 2;
          double angle = -((location.getYaw() + 180) / 60);
          angle += (location.getYaw() < -180 ? 3.25 : 2.985);

          for (boolean[] aShape : shape) {
            for (boolean anAShape : aShape) {
              if (anAShape) {

                Location target = location.clone();
                target.setX(x);
                target.setY(y);

                Vector v = target.toVector().subtract(location.toVector());
                Vector v2 = getBackVector(location);
                v = rotateAroundAxisY(v, angle);
                v2.setY(0).multiply(-0.2);

                location.add(v);
                location.add(v2);
                for (int k = 0; k < 3; k++) {
                  ParticleUtils.display(255, 255, 255, location);
                }
                location.subtract(v2);
                location.subtract(v);
              }
              x += space;
            }
            y -= space;
            x = defX;
          }
        }
      }

    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }


}
