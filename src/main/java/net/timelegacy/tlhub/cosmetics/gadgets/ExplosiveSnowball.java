package net.timelegacy.tlhub.cosmetics.gadgets;

import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
    Player player = event.getPlayer();

    String gadgetName = "EXPLOSIVE_SNOWBALL";
    ItemStack is = event.getItem();

    if (is == null) {
      return;
    }

    if (is.getType() == Material.AIR) {
      return;
    }

    if (!is.hasItemMeta()) {
      return;
    }

    if (!is.getItemMeta().hasDisplayName()) {
      return;
    }

    if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    if (player.getInventory().getItemInMainHand() == null) {
      return;
    }

    ItemStack inHand = player.getInventory().getItemInMainHand();

    if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
        .contains(gadgetName.replace("_", " ").toLowerCase())) {
      event.setCancelled(true);

      if (Cooldown.hasCooldown(player.getUniqueId(), gadgetName)) {
        MessageUtils.sendMessage(player, MessageUtils.ERROR_COLOR + "You must wait " +
            Cooldown.getTimeLeft(player.getUniqueId(), gadgetName)
            + (Cooldown.getTimeLeft(player.getUniqueId(), gadgetName) > 1 ? " seconds"
            : " second") +
            " before doing that again.", true);
        return;
      }

      Snowball snowball = player.launchProjectile(Snowball.class);
      snowball.setMetadata("explosiveSnowball",
          new FixedMetadataValue(plugin, "ExplosiveSnowball"));

      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
    }

  }

  @EventHandler
  public void onExplosiveSnowballHit(ProjectileHitEvent event) {
    if (!(event.getEntity() instanceof Snowball)) {
      return;
    }

    if (!event.getEntity().hasMetadata("explosiveSnowball")) {
      return;
    }

    event.getEntity().getWorld().playSound(event.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
    event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation(), 1);
  }

}
