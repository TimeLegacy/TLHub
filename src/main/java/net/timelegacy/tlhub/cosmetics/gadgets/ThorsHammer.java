package net.timelegacy.tlhub.cosmetics.gadgets;

import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ThorsHammer implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    String gadgetName = "THOR_HAMMER";

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

//          TTA_Methods.sendTitle(player, "&eSUMMONING THE GODS...", 20, 20, 20, "", 20, 20, 20);

      new BukkitRunnable() {

        @Override
        public void run() {
          player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);

          for (int i = 0; i < 50; i++) {
            player.getWorld().strikeLightningEffect(player.getEyeLocation());
          }
        }
      }.runTaskLaterAsynchronously(plugin, 20 * 3);

      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
    }

  }

}
