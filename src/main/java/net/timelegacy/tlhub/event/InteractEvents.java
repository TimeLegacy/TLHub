package net.timelegacy.tlhub.event;

import net.timelegacy.tlhub.cosmetics.menu.CosmeticMenu;
import net.timelegacy.tlhub.menus.MainMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvents implements Listener {

  @EventHandler
  public void onOpenMenu(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    if (event.getAction() == Action.RIGHT_CLICK_AIR
        || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

      if (p.getInventory().getItemInMainHand() != null) {
        Material inHand = p.getInventory().getItemInMainHand().getType();
        if (inHand == Material.ENCHANTING_TABLE) {
          event.setCancelled(true);

          CosmeticMenu.openMenu(p);
        } else if (inHand == Material.TROPICAL_FISH) {
          event.setCancelled(true);

          MainMenu.openMenu(p);
        }

        // TODO - Make gadgets hook into this part.
      }
    }
  }

  @EventHandler
  public void onEntityDamage(EntityDamageEvent e) {
    e.setCancelled(true);
  }

  @EventHandler
  public void catchFire(EntityCombustEvent e) {
    e.setCancelled(true);
  }
}
