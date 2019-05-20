package net.timelegacy.tlhub.cosmetics.other;

import net.timelegacy.tlcore.utils.FireworkUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
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
          if (CosmeticHandler.hasCooldown(p, "FIREWORK")) {
            MessageUtils.sendMessage(p,
                MessageUtils.ERROR_COLOR
                    + "You must wait before doing that again.",
                true);

          } else {
            CosmeticHandler.addCooldown(p, 10, "FIREWORK");
            fireworkEffect(p);
          }
        } else {
          MessageUtils.sendMessage(p,
              MessageUtils.ERROR_COLOR
                  + "You must be on the ground to do that.",
              true);
        }
      }
    }
  }

}
