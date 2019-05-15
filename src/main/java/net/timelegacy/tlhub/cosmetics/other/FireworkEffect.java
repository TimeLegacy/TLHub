package net.timelegacy.tlhub.cosmetics.other;

import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class FireworkEffect implements Listener {

  private CosmeticHandler cosmeticHandler = TLHub.getInstance().cosmetics;

  public void fireworkEffect(Player p) {
    TLHub.getInstance().core.fireworkUtils.spawnFirework(p.getLocation(), 1);
  }

  @EventHandler
  public void onSneak(PlayerToggleSneakEvent e) {
    Player p = e.getPlayer();

    if (e.isSneaking()) {
      if (TLHub.getInstance().cosmetics.particleEnabled(p, "FIREWORK")) {
        if (p.isOnGround()) {
          if (cosmeticHandler.hasCooldown(p, "FIREWORK")) {
            TLHub.getInstance().core.messageUtils.sendMessage(p,
                TLHub.getInstance().core.messageUtils.ERROR_COLOR
                    + "You must wait before doing that again.",
                true);

          } else {
            cosmeticHandler.addCooldown(p, 10, "FIREWORK");
            fireworkEffect(p);
          }
        } else {
          TLHub.getInstance().core.messageUtils.sendMessage(p,
              TLHub.getInstance().core.messageUtils.ERROR_COLOR
                  + "You must be on the ground to do that.",
              true);
        }
      }
    }
  }

}
