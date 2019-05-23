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

  public void fireworkEffect(Player p) {
    FireworkUtils.spawnFirework(p.getLocation(), 1);
  }

  @EventHandler
  public void onSneak(PlayerToggleSneakEvent e) {
    Player p = e.getPlayer();

    if (e.isSneaking()) {
      if (CosmeticHandler.particleEnabled(p, "FIREWORK")) {
        if (p.isOnGround()) {
          if (Cooldown.hasCooldown(p.getUniqueId(), "FIREWORK")) {
            MessageUtils.sendMessage(
                p, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
                    .getTimeLeft(p.getUniqueId(), "FIREWORK")
                    + (Cooldown.getTimeLeft(p.getUniqueId(), "FIREWORK") > 1 ? "seconds" : "second")
                    +
                    " before doing that again.", true);

          } else {
            new Cooldown(p.getUniqueId(), "FIREWORK", 3).start();
            fireworkEffect(p);
          }
        } else {
          MessageUtils.sendMessage(
              p, MessageUtils.ERROR_COLOR + "You must be on the ground to do that.", true);
        }
      }
    }
  }
}
