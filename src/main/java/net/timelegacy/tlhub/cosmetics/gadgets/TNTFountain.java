package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.Random;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class TNTFountain implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    String gadgetName = "TNT_FOUNTAIN";
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
        MessageUtils.sendMessage(
            player, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
                .getTimeLeft(player.getUniqueId(), gadgetName)
                + (Cooldown.getTimeLeft(player.getUniqueId(), gadgetName) > 1 ? " seconds"
                : " second") +
                " before doing that again.", true);
        return;
      }

      Block b = getTargetBlock(player, 6);

      new BukkitRunnable() {
        int step = 0;

        public void run() {
          ++this.step;

          if (this.step <= 15) {
            final TNTPrimed entityTnt = b.getLocation().getWorld().spawn(b.getLocation().add(0.0, 0.25, 0.0), TNTPrimed.class);
            entityTnt.setMetadata(plugin.getName(), new FixedMetadataValue(plugin, true));
            entityTnt.setVelocity(
                new Vector(
                    (new Random().nextDouble() - 0.5) * 0.7,
                    1.25,
                    (new Random().nextDouble() - 0.5) * 0.7));
            return;
          }

          this.cancel();
        }
      }.runTaskTimer(plugin, 0L, 8L);

      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
    }

  }

  private Block getTargetBlock(final Player player, final int range) {
    try {
      return player.getTargetBlock(null, range);
    } catch (IllegalStateException e) {
      return null;
    }
  }


}
