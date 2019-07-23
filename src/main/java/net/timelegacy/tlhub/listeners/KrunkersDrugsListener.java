package net.timelegacy.tlhub.listeners;

import net.timelegacy.tlcore.datatype.AABB3D;
import net.timelegacy.tlcore.datatype.Polyhedron;
import net.timelegacy.tlcore.datatype.Zone;
import net.timelegacy.tlhub.handler.DiscoveriesHandler;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KrunkersDrugsListener implements Listener {

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
      return;
    }

    if (event.getHand() != EquipmentSlot.HAND) {
      return;
    }

    Zone[] list = DiscoveriesHandler.getDiscoveries();

    if (list.length == 0) {
      return;
    }

    boolean temp = false;

    for (Zone zone : list) {
      if (!zone.getShortName().equalsIgnoreCase("krunkershouse")) {
        continue;
      }

      if (Polyhedron.isInside(zone.getBoundingBoxes(), AABB3D.getPlayersAABB(event.getPlayer()))) {
        temp = true;
        break;
      }
    }

    if (!temp) {
      return;
    }

    if (event.getClickedBlock() == null) {
      return;
    }

    if (event.getClickedBlock().getType() == Material.POPPY) {
      event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 5, 1));
      return;
    }

    if (event.getClickedBlock().getType() == Material.AZURE_BLUET) {
      event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 5, 1));
      return;
    }

    if (event.getClickedBlock().getType() == Material.OXEYE_DAISY) {
      event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20 * 5, 1));
      return;
    }

  }

}
