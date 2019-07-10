package net.timelegacy.tlhub.cosmetics.particles;

import java.util.Collections;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class RainCloud extends net.timelegacy.tlhub.cosmetics.particles.Particle {

  private final TLHub plugin;

  public RainCloud(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Rain Cloud");
    setDisplayName(getRarity().getColor() + "Rain Cloud");
    setLore(Collections.singletonList("&7It rained today..."));
    setPermissionNode("hub.cosmetics.particles.rain_cloud");

    setItem(ItemUtils.createItem(Material.WATER_BUCKET, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void registerRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
      for (Player player : Bukkit.getOnlinePlayers()) {
        if (!CosmeticHandler.particleEnabled(player, getName())) {
          return;
        }

        ParticleUtils.display(Particle.CLOUD, player.getEyeLocation().add(0, 1, 0), 10, 0);
        ParticleUtils.display(Particle.WATER_DROP, player.getEyeLocation().add(0, 1, 0));
      }
    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }
}
