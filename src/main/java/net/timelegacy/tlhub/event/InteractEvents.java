package net.timelegacy.tlhub.event;

import net.timelegacy.tlcore.menus.profile.ProfileMenu;
import net.timelegacy.tlhub.TLHub;
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

  private final TLHub plugin;

  public InteractEvents(TLHub plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onOpenMenu(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

      if (player.getInventory().getItemInMainHand() != null) {
        Material inHand = player.getInventory().getItemInMainHand().getType();
        if (inHand == Material.ENCHANTING_TABLE) {
          event.setCancelled(true);

          new CosmeticMenu(plugin).openMenu(player);
        } else if (inHand == Material.TROPICAL_FISH) {
          event.setCancelled(true);

          MainMenu.openMenu(player);
        }

        if (inHand == Material.PLAYER_HEAD) {
          event.setCancelled(true);

          ProfileMenu.openMenu(player);
        }

        // TODO - Make gadgets hook into this part.
      }
    }
  }

  @EventHandler
  public void onEntityDamage(EntityDamageEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void catchFire(EntityCombustEvent event) {
    event.setCancelled(true);
  }
}
