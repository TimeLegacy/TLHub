package net.timelegacy.tlhub.cosmetics.particles;

import java.util.Collections;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MathUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Cone extends Particle {

  private final TLHub plugin;

  public Cone(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Cone");
    setDisplayName(getRarity().getColor() + "Cone");
    setLore(Collections.singletonList("&7Cone... head?"));
    setPermissionNode("hub.cosmetics.particles.cone");

    setItem(ItemUtils.createItem(Material.HOPPER, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void registerRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
      for (Player player : Bukkit.getOnlinePlayers()) {
        if (!CosmeticHandler.particleEnabled(player, getName())) {
          return;
        }

        Location location = player.getEyeLocation().add(0, 0.3, 0);
        float radius = 0.25f;
        drawCircle(radius + 0.1f, -0.05f, location);
        for (float f = 0; f <= 0.4f; f += 0.1f) {
          if (radius >= 0) {
            drawCircle(radius, f, location);
            radius -= 0.09f;
          }
        }

      }
    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

  private void drawCircle(float radius, float height, Location location) {
    int particles = 12;
    for (int i = 0; i < particles; i++) {
      double inc = (2 * Math.PI) / particles;
      float angle = (float) (i * inc);
      float x = MathUtils.cos(angle) * radius;
      float z = MathUtils.sin(angle) * radius;
      location.add(x, height, z);
      ParticleUtils.display(255, 255, 255, location);
      location.subtract(x, height, z);
    }
  }
}
