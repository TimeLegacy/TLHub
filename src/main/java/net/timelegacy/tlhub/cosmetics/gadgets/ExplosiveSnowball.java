package net.timelegacy.tlhub.cosmetics.gadgets;

import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class ExplosiveSnowball implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    String gadgetName = "EXPLOSIVE_SNOWBALL";

    if (event.getAction() == Action.RIGHT_CLICK_AIR
        || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

      if (p.getInventory().getItemInMainHand() != null) {
        ItemStack inHand = p.getInventory().getItemInMainHand();

        if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
            .contains(gadgetName.replace("_", " ").toLowerCase())) {
          event.setCancelled(true);

          if (Cooldown.hasCooldown(p.getUniqueId(), gadgetName)) {
            MessageUtils.sendMessage(
                p, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
                    .getTimeLeft(p.getUniqueId(), gadgetName)
                    + (Cooldown.getTimeLeft(p.getUniqueId(), gadgetName) > 1 ? " seconds"
                    : " second") +
                    " before doing that again.", true);
            return;
          }

          Snowball snowball = p.launchProjectile(Snowball.class);
          snowball.setMetadata("explosiveSnowball",
              new FixedMetadataValue(plugin, "ExplosiveSnowball"));

          new Cooldown(
              p.getUniqueId(),
              gadgetName,
              5)
              .start();
        }
      }
    }
  }

  @EventHandler
  public void onExplosiveSnowballHit(ProjectileHitEvent e) {
    if (!(e.getEntity() instanceof Snowball)) {
      return;
    }

    if (!e.getEntity().hasMetadata("explosiveSnowball")) {
      return;
    }

    e.getEntity()
        .getWorld()
        .playSound(e.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
    e.getEntity()
        .getWorld()
        .spawnParticle(Particle.EXPLOSION_LARGE, e.getEntity().getLocation(), 1);
  }


}
