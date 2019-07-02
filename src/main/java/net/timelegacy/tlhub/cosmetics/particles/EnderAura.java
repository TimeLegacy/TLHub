package net.timelegacy.tlhub.cosmetics.particles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class EnderAura extends net.timelegacy.tlhub.cosmetics.particles.Particle {

  private final TLHub plugin;

  public EnderAura(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Ender Aura");
    setDisplayName(getRarity().getColor() + "Ender Aura");
    setLore(Collections.singletonList("&7Watch out for the slender man!"));
    setPermissionNode("hub.cosmetics.particles.ender_aura");

    setItem(ItemUtils.createItem(Material.ENDER_PEARL, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void registerRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
      for (Player player : Bukkit.getOnlinePlayers()) {
        if (!CosmeticHandler.particleEnabled(player, getName())) {
          return;
        }

        Location center = player.getLocation().add(0, 2, 0);
        World world = center.getWorld();
        double increment = (2 * Math.PI) / 16;
        List<Location> locations = new ArrayList<>();
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
    }, 0, 2L); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }
}
