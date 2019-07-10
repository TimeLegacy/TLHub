package net.timelegacy.tlhub.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerVisibilityListener implements Listener {

  private final TLHub plugin;

  private List<UUID> visibility = new ArrayList<>();

  public PlayerVisibilityListener(TLHub plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerInteractItemEvent(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    ItemStack item = event.getItem();

    if (item == null) {
      return;
    }

    if (item.getType() == Material.AIR) {
      return;
    }

    if (!item.hasItemMeta()) {
      return;
    }

    if (!(event.getAction() == Action.RIGHT_CLICK_AIR) && !(event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
      return;
    }

    if (item.getItemMeta().getDisplayName().equalsIgnoreCase(MessageUtils.colorize("&ePlayer Visibility &aEnabled &8{&7Right Click&8}"))
        && item.getType().equals(Material.BLAZE_ROD)) {
      event.setCancelled(true);

      if (Cooldown.hasCooldown(player.getUniqueId(), "playerVisibility")) {
        player.sendMessage(MessageUtils.colorize("&cWait 3 seconds between uses."));
        return;
      }

      visibility.add(player.getUniqueId());

      if (visibility.contains(player.getUniqueId())) {
        hidePlayers(player);
        ItemStack is1 = ItemUtils.createItem(Material.STICK, "&ePlayer Visibility &cDisabled &8{&7Right Click&8}");
        player.getInventory().setItem(8, is1);
      }

      new Cooldown(player.getUniqueId(), "playerVisibility", 3).start();
      return;
    }

    if (item.getItemMeta().getDisplayName().equalsIgnoreCase(MessageUtils.colorize("&ePlayer Visibility &cDisabled &8{&7Right Click&8}"))
        && item.getType().equals(Material.STICK)) {
      event.setCancelled(true);

      if (Cooldown.hasCooldown(player.getUniqueId(), "playerVisibility")) {
        player.sendMessage(MessageUtils.colorize("&cWait 3 seconds between uses."));
        return;
      }

      if (visibility.contains(player.getUniqueId())) {
        showPlayers(player);
        ItemStack is1 = ItemUtils.createItem(Material.BLAZE_ROD, "&ePlayer Visibility &aEnabled &8{&7Right Click&8}");
        player.getInventory().setItem(8, is1);
      }

      new Cooldown(player.getUniqueId(), "playerVisibility", 3).start();
    }
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    for (UUID uuid : visibility) {
      Bukkit.getPlayer(uuid).hidePlayer(plugin, event.getPlayer());
    }
  }

  @EventHandler
  public void onLeave(PlayerQuitEvent event) {
    visibility.remove(event.getPlayer().getUniqueId());
  }

  private void showPlayers(Player player) {
    for (Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
      player.showPlayer(plugin, onlinePlayers);
    }
  }

  private void hidePlayers(Player player) {
    for (Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
      player.hidePlayer(plugin, onlinePlayers);
    }
  }

}
