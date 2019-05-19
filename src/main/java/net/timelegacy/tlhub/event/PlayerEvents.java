package net.timelegacy.tlhub.event;

import net.timelegacy.tlcore.TLCore;
import net.timelegacy.tlcore.handler.Rank;
import net.timelegacy.tlcore.utils.SkullCreator;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Vector;

public class PlayerEvents implements Listener {

  TLHub lobby = TLHub.getInstance();

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player p = event.getPlayer();

    World world = p.getWorld();
    Rank r = lobby.core.rankHandler.getRank(p.getName());
    if (r.getPriority() >= 7) {
      Bukkit.broadcastMessage(lobby.core.messageUtils
          .c(r.getMainColor() + p.getName() + r.getCoColor() + " has joined the server."));
      p.setAllowFlight(true);
      p.setFlying(true);
    }

    p.setHealthScale(20);

    Location spawn = lobby.spawn;
    Location lookloc = new Location(world, 0.5, 118.5, 13.5);
    Vector dirBetweenLocations = lookloc.toVector().subtract(spawn.toVector());
    spawn.setDirection(dirBetweenLocations);

    p.teleport(spawn);

    p.setGameMode(GameMode.ADVENTURE);

    p.setScoreboard(lobby.scoreboardHandler.scoreBoard(p));

    hotBarItems(p);

    if (Bukkit.getOnlinePlayers().size() >= 1) {
      lobby.playersOnline = true;
    }
    lobby.core.serverHandler.setOnlinePlayers(lobby.core.serverHandler.getServerUID(),
        Bukkit.getOnlinePlayers().size());

  }

  public void hotBarItems(Player p) {

    p.getInventory().setItem(0, lobby.core.itemUtils.createItem(Material.ENCHANTING_TABLE, 1,
        "&eCosmetics &8{&7Right Click&8}",
        "&7Open Cosmetics to utilize all your",
        "&7favorite features.",
        "&aUnlocked&7: &8(&7" + lobby.cosmetics.getTotal(p) + "/" + lobby.cosmetics.getCosmetics()
            .size() + "&8)"));
    p.getInventory().setItem(1, lobby.core.itemUtils.createItem(Material.BEACON, 1,
        "&eLobby Selector &8{&7Right Click&8}", "&7Right click to select", "&7a lobby to join."));
    p.getInventory().setItem(4, lobby.core.itemUtils.createItem(Material.ENDER_CHEST, 1,
        "&eServer Selector &8{&7Right Click&8}", "&7Right click to select", "&7a server to join."));
    p.getInventory()
        .setItem(7, lobby.core.itemUtils.createItem(SkullCreator.itemFromUuid(p.getUniqueId()), 1,
            "&eYour Profile &8{&7Right Click&8}", "&7Right click to view your",
            "&7profile and alter your user", "&7specific settings."));
    p.getInventory().setItem(8, lobby.core.itemUtils.createItem(Material.BLAZE_ROD, 1,
        "&ePlayer Visibility &aEnabled &8{&7Right Click&8}", "&7Right click to no longer",
        "&7view other players."));
    p.getInventory().setHeldItemSlot(4);

    p.updateInventory();

  }

  @EventHandler
  public void onMove(PlayerMoveEvent e) {
    if (e.getPlayer().getLocation().getY() <= 10) {
      Location spawn = lobby.spawn;
      Location lookloc = new Location(e.getPlayer().getWorld(), 41.5, 62.0, 1005.5);
      Vector dirBetweenLocations = lookloc.toVector().subtract(spawn.toVector());
      spawn.setDirection(dirBetweenLocations);

      e.getPlayer().teleport(spawn);

      TLCore.getInstance().messageUtils.sendMessage(e.getPlayer(),
          lobby.core.messageUtils.MAIN_COLOR + "You have been saved from the depths of the world!",
          true);
    }

  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    Player p = event.getPlayer();

    lobby.core.serverHandler.setOnlinePlayers(lobby.core.serverHandler.getServerUID(),
        Bukkit.getOnlinePlayers().size() - 1);

    if (Bukkit.getOnlinePlayers().size() < 1) {
      lobby.playersOnline = false;
    }
  }

  @EventHandler(ignoreCancelled = false, priority = EventPriority.HIGHEST)
  public void onBlockPlace(BlockPlaceEvent event) {
    Player p = event.getPlayer();
    Rank r = lobby.core.rankHandler.getRank(p.getName());

    if (r.getPriority() >= 9) {
      event.setCancelled(false);
    } else {
      event.setCancelled(true);
    }
  }

  @EventHandler(ignoreCancelled = false, priority = EventPriority.HIGHEST)
  public void onBlockBreak(BlockBreakEvent event) {
    Player p = event.getPlayer();
    Rank r = lobby.core.rankHandler.getRank(p.getName());

    if (r.getPriority() >= 9) {
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
}