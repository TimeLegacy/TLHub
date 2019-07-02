package net.timelegacy.tlhub.cosmetics.particles;

import java.util.Collections;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class BloodHelix extends Particle {

  private final TLHub plugin;

  public BloodHelix(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Blood Helix");
    setDisplayName(getRarity().getColor() + "Blood Helix");
    setLore(Collections.singletonList("&7Show me your blood bending."));
    setPermissionNode("hub.cosmetics.particles.blood_helox");

    setItem(ItemUtils.createItem(Material.REDSTONE, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void registerRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
      double i = 0;

      for (Player player : Bukkit.getOnlinePlayers()) {
        if (!CosmeticHandler.particleEnabled(player, getName())) {
          return;
        }

        Location location = player.getLocation();
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
          ParticleUtils.display(255, 0, 0, location.add(v));
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
          ParticleUtils.display(255, 0, 0, location2.add(v));
          location2.subtract(v);
          location2.add(0, 0.12d, 0);
          radius2 -= 0.044f;
        }
        i += 0.05;
      }
    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }
}
