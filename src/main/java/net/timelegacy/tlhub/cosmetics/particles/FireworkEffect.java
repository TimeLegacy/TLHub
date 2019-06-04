package net.timelegacy.tlhub.cosmetics.particles;

import net.timelegacy.tlcore.utils.FireworkUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class FireworkEffect implements Listener {

  public void fireworkEffect(Player player) {
    FireworkUtils.spawnFirework(player.getLocation(), 1);
  }

  @EventHandler
  public void onSneak(PlayerToggleSneakEvent event) {
    Player player = event.getPlayer();

    if (!player.isSneaking()) {
      return;
    }

    if (!CosmeticHandler.particleEnabled(player, "FIREWORK")) {
      return;
    }

    if (!player.isOnGround()) {
      MessageUtils.sendMessage(player, MessageUtils.ERROR_COLOR + "You must be on the ground to do that.", true);
      return;
    }

    if (Cooldown.hasCooldown(player.getUniqueId(), "FIREWORK")) {
      MessageUtils.sendMessage(player, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
          .getTimeLeft(player.getUniqueId(), "FIREWORK")
          + (Cooldown.getTimeLeft(player.getUniqueId(), "FIREWORK") > 1 ? "seconds" : "second")
          +
          " before doing that again.", true);
      return;
    }

    new Cooldown(player.getUniqueId(), "FIREWORK", 3).start();
    fireworkEffect(player);
  }
}
