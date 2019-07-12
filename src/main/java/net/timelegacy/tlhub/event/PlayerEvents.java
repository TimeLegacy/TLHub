package net.timelegacy.tlhub.event;

import net.timelegacy.tlcore.datatype.Rank;
import net.timelegacy.tlcore.handler.RankHandler;
import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.handler.DiscoveriesHandler;
import net.timelegacy.tlhub.handler.ScoreboardHandler;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.util.Vector;

public class PlayerEvents implements Listener {

  public static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();

    World world = player.getWorld();
    Rank r = RankHandler.getRank(player.getUniqueId());
    if (r.getPriority() >= 7) {
      player.setAllowFlight(true);
      player.setFlying(true);
    }

    player.setHealthScale(20);
    player.setExp(0);
    player.setLevel(0);

    Location spawn = TLHub.spawn;
    Location lookloc = new Location(world, 0.5, 118.5, 13.5);
    Vector dirBetweenLocations = lookloc.toVector().subtract(spawn.toVector());
    spawn.setDirection(dirBetweenLocations);

    player.teleport(spawn);

    player.setGameMode(GameMode.ADVENTURE);

    DiscoveriesHandler.playerJoin(player);
    ScoreboardHandler.updateEverything(player);

    player.getInventory().clear();
    player.updateInventory();
    hotBarItems(player);

    if (Bukkit.getOnlinePlayers().size() >= 1) {
      TLHub.playersOnline = true;
    }

    ServerHandler.setOnlinePlayers(ServerHandler.getServerUUID(), Bukkit.getOnlinePlayers().size());
  }

  public void hotBarItems(Player player) {
    player.getInventory().setItem(0, ItemUtils.createItem(Material.ENCHANTING_TABLE, 1,
        "&eCosmetics &8{&7Right Click&8}",
        "&7Open Cosmetics to utilize all your",
        "&7favorite features.",
        "&aUnlocked&7: &8(&7"
            + plugin.getCosmeticHandler().getTotals(player).get("player")
            + "/"
            + CosmeticHandler.getCosmetics().size()
            + "&8)"));
    player.getInventory().setItem(1, ItemUtils.createItem(Material.BEACON, 1,
        "&eLobby Selector &8{&7Right Click&8}",
        "&7Right click to select",
        "&7a lobby to join."));
    player.getInventory().setItem(4, ItemUtils.createItem(Material.ENDER_CHEST, 1,
        "&eServer Selector &8{&7Right Click&8}",
        "&7Right click to select",
        "&7a server to join."));
    player.getInventory().setItem(7, ItemUtils.createItem(ItemUtils.playerSkull(player.getUniqueId()), 1,
        "&eYour Profile &8{&7Right Click&8}",
        "&7Right click to view your",
        "&7profile and alter your user",
        "&7specific settings."));
    player.getInventory().setItem(8, ItemUtils.createItem(Material.BLAZE_ROD, 1,
        "&ePlayer Visibility &aEnabled &8{&7Right Click&8}",
        "&7Right click to no longer",
        "&7view other players."));
    player.getInventory().setHeldItemSlot(4);

    player.updateInventory();
  }

  @EventHandler
  public void onMove(PlayerMoveEvent event) {
    if (event.getPlayer().getLocation().getY() <= 10) {
      Location spawn = TLHub.spawn;
      Location lookloc = new Location(event.getPlayer().getWorld(), 41.5, 62.0, 1005.5);
      Vector dirBetweenLocations = lookloc.toVector().subtract(spawn.toVector());
      spawn.setDirection(dirBetweenLocations);

      event.getPlayer().teleport(spawn);

      MessageUtils.sendMessage(event.getPlayer(),
          MessageUtils.MAIN_COLOR + "You have been saved from the depths of the world!", true);
    }

    DiscoveriesHandler.discoveryMagic(event.getPlayer()); // Discovery system logic
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();

    ServerHandler.setOnlinePlayers(ServerHandler.getServerUUID(), Bukkit.getOnlinePlayers().size() - 1);

    if (Bukkit.getOnlinePlayers().size() < 1) {
      TLHub.playersOnline = false;
    }

    DiscoveriesHandler.playerLeave(player);
  }

  @EventHandler(ignoreCancelled = false, priority = EventPriority.HIGHEST)
  public void onBlockPlace(BlockPlaceEvent event) {
    Player player = event.getPlayer();
    Rank rank = RankHandler.getRank(player.getUniqueId());

    if (rank.getPriority() >= 9) {
      event.setCancelled(false);
    } else {
      event.setCancelled(true);
    }
  }

  @EventHandler(ignoreCancelled = false, priority = EventPriority.HIGHEST)
  public void onBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    Rank rank = RankHandler.getRank(player.getUniqueId());

    if (rank.getPriority() >= 9) {
      event.setCancelled(false);
    } else {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onDamage(EntityDamageEvent event) {
    if (event.getCause() == DamageCause.VOID) {
      if (event.getEntity() instanceof Player) {

        event.setCancelled(true);
      }

    } else if (event.getCause() == DamageCause.FALL) {
      if (event.getEntity() instanceof Player) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler(ignoreCancelled = true)
  public void onDamage(EntityDamageByEntityEvent event) {
    if (event.getDamager() instanceof Player) {
      if (((Player) event.getDamager()).getGameMode() == GameMode.CREATIVE) {
        event.setCancelled(false);
      }
    }
  }

  @EventHandler
  public void onDrop(PlayerDropItemEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onPickup(PlayerPickupItemEvent event) {
    event.setCancelled(true);
    event.getItem().remove();
  }

  @EventHandler
  public void onFoodLevelChange(FoodLevelChangeEvent event) {
    event.setFoodLevel(20);
  }

  @EventHandler
  public void onButtonPress(PlayerInteractEvent event) {
    if (event.getAction().equals(Action.PHYSICAL)) {
      if (event.getClickedBlock().getType() == Material.OAK_PRESSURE_PLATE) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onItemHandSwitch(PlayerSwapHandItemsEvent event) {
    event.setCancelled(true);
  }
}
