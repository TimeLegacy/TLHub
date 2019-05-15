package net.timelegacy.tlhub.npcs;

import net.timelegacy.tlhub.TLHub;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ServerGolemNPC implements Listener {

  TLHub lobby = TLHub.getInstance();

  @EventHandler
  public void golem(PlayerInteractEntityEvent event) {

    if (event.getRightClicked() instanceof IronGolem) {
      event.setCancelled(true);

      IronGolem v = (IronGolem) event.getRightClicked();

      String dataValue = v.getMetadata("type").get(0).asString().toUpperCase();

      Player p = event.getPlayer();

      if (lobby.gameMenus.menus.containsKey(dataValue.toUpperCase())) {
        p.openInventory(lobby.gameMenus.getGameMenu(dataValue.toUpperCase()));
      } else {
        lobby.core.messageUtils
            .sendMessage(p, lobby.core.messageUtils.ERROR_COLOR + "This game is coming soon.",
                true);
      }
    }
  }


}
