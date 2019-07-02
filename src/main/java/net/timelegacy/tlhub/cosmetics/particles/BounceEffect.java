package net.timelegacy.tlhub.cosmetics.particles;

import java.util.Collections;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BounceEffect extends net.timelegacy.tlhub.cosmetics.particles.Particle implements Listener {

  private final TLHub plugin;

  public BounceEffect(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Bounce");
    setDisplayName(getRarity().getColor() + "Bounce");
    setLore(Collections.singletonList("&7Bouncy Bouncy! (Shift to activate)"));
    setPermissionNode("hub.cosmetics.particles.bounce");

    setItem(ItemUtils.createItemNoAttrib(Material.DIAMOND_BOOTS, getDisplayName(), getLore(), getName()));
  }

  @EventHandler
  public void onSneak(PlayerToggleSneakEvent event) {
    Player player = event.getPlayer();

    if (!player.isSneaking()) {
      return;
    }

    if (!CosmeticHandler.particleEnabled(player, "BOUNCE")) {
      return;
    }

    if (!player.isOnGround()) {
      MessageUtils.sendMessage(player, MessageUtils.ERROR_COLOR + "You must be on the ground to do that.", true);
      return;
    }

    if (Cooldown.hasCooldown(player.getUniqueId(), "BOUNCE")) {
      MessageUtils.sendMessage(player, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
          .getTimeLeft(player.getUniqueId(), "BOUNCE")
          + (Cooldown.getTimeLeft(player.getUniqueId(), "BOUNCE") > 1 ? " seconds" : " second") +
          " before doing that again.", true);
      return;
    }

    new Cooldown(player.getUniqueId(), "BOUNCE", 3).start();
    bounceEffect(player);
  }

  private void bounceEffect(Player player) {
    new BukkitRunnable() {
      double t = Math.PI / 2;
      Location loc = player.getLocation();

      public void run() {
        t = t + 0.1 * Math.PI;
        for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
          double x = t * Math.cos(theta);
          double y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 0.5;
          double z = t * Math.sin(theta);
          loc.add(x, y, z);

          ParticleUtils.display(Particle.FIREWORKS_SPARK, loc);

          loc.subtract(x, y, z);

          theta = theta + Math.PI / 32;

          x = t * Math.cos(theta);
          y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 0.5;
          z = t * Math.sin(theta);
          loc.add(x, y, z);

          ParticleUtils.display(Particle.SPELL_WITCH, loc);

          loc.subtract(x, y, z);
        }

        if (t > 5) {
          this.cancel();
        }
      }
    }.runTaskTimer(plugin, 0, 1);

    player.setVelocity(new Vector(0, 1, 0));
  }
}
