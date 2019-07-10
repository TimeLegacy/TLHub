package net.timelegacy.tlhub.cosmetics.particles;

import java.util.Collections;
import java.util.Random;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class GreenSparks extends net.timelegacy.tlhub.cosmetics.particles.Particle {

  private final TLHub plugin;

  private static int step;
  private Random random = new Random();

  public GreenSparks(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Green Sparks");
    setDisplayName(getRarity().getColor() + "Green Sparks");
    setLore(Collections.singletonList("&7These sparks just hit different."));
    setPermissionNode("hub.cosmetics.particles.green_sparks");

    setItem(ItemUtils.createItem(Material.GRASS, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void registerRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
      for (Player player : Bukkit.getOnlinePlayers()) {
        if (!CosmeticHandler.particleEnabled(player, getName())) {
          return;
        }

        if (step > 360) {
          step = 0;
        }

        Location center = player.getEyeLocation().add(0, 0.6, 0);
        double inc = (2 * Math.PI) / 20;
        double angle = step * inc;
        double x = Math.cos(angle) * 1.1f;
        double z = Math.sin(angle) * 1.1f;
        center.add(x, 0, z);
        for (int i = 0; i < 15; i++) {
          ParticleUtils.display(Particle.VILLAGER_HAPPY, center);
        }

        step++;
      }
    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

  public byte getRandomColor() {
    float f = random.nextFloat();
    if (f > 0.98) {
      return (byte) 2;
    } else if (f > 0.49) {
      return (byte) 1;
    } else {
      return (byte) 15;
    }
  }
}
