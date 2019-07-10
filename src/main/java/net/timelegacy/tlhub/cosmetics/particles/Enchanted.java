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

public class Enchanted extends net.timelegacy.tlhub.cosmetics.particles.Particle {

  private final TLHub plugin;

  public Enchanted(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Enchanted");
    setDisplayName(getRarity().getColor() + "Enchanted");
    setLore(Collections.singletonList("&7You're a wizard Harry!"));
    setPermissionNode("hub.cosmetics.particles.enchanted");

    setItem(ItemUtils.createItem(Material.ENCHANTING_TABLE, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void registerRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
      for (Player player : Bukkit.getOnlinePlayers()) {
        if (!CosmeticHandler.particleEnabled(player, getName())) {
          return;
        }

        ParticleUtils.display(Particle.ENCHANTMENT_TABLE, player.getEyeLocation(), 8, 1);
      }
    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

}
