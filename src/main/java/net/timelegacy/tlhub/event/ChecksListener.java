package net.timelegacy.tlhub.event;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldLoadEvent;

public class ChecksListener implements Listener {

  private static void hideAdvancementsFor(World world) {
    world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
  }

  /* Hide advancements for new worlds */
  @EventHandler
  public void onWorldLoad(WorldLoadEvent event) {
    hideAdvancementsFor(event.getWorld());
  }

  @EventHandler
  public void onBlockFromTo(BlockFromToEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onBlockIgnite(BlockIgniteEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onBlockBurn(BlockBurnEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onBlockPhysics(BlockPhysicsEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onLeavesDecay(LeavesDecayEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onBlockForm(BlockFormEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onEntityBlockForm(EntityBlockFormEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void EntityChangeBlockEvent(EntityChangeBlockEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onBlockSpread(BlockSpreadEvent event) {
    event.setCancelled(true);
  }

  @EventHandler
  public void onExplode(EntityExplodeEvent event) {
    event.setYield(0);
    event.setCancelled(true);
  }

  @EventHandler
  public void onEntityDeath(EntityDeathEvent e) {
    e.getDrops().clear();
    e.setDroppedExp(0);
  }

  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent e) {
    e.getDrops().clear();
    e.setDroppedExp(0);
    e.setKeepInventory(true);
  }

  @EventHandler
  public void onPlayerFoodLevelChange(FoodLevelChangeEvent e) {
    e.setFoodLevel(20);
    e.setCancelled(true);
  }

  @EventHandler
  public void onPlayerDropItem(PlayerDropItemEvent e) {
    if (!e.getPlayer().isOp()) {
      e.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerDamageEntity(EntityDamageByEntityEvent e) {
    if (e.getDamager() instanceof TNTPrimed) {
      e.setDamage(0);
      e.setCancelled(true);
      return;
    }

    if (e.getDamager() instanceof Player) {
      e.setDamage(0);
      e.setCancelled(true);
    }
  }

  @EventHandler
  public void onEvent(EntityDamageEvent e) {
    if (e.getCause() == DamageCause.FIRE || e.getCause() == DamageCause.FIRE_TICK) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.LAVA) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.PROJECTILE) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.BLOCK_EXPLOSION) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.MAGIC) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.ENTITY_EXPLOSION) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.FALL) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.DROWNING) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.CONTACT) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.FLY_INTO_WALL) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.SUFFOCATION) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.STARVATION) {
      e.setCancelled(true);
    }
    if (e.getCause() == DamageCause.CRAMMING) {
      e.setCancelled(true);
    }
  }

  @EventHandler
  public void onWeatherChange(WeatherChangeEvent e) {
    e.setCancelled(true);
    e.getWorld().setWeatherDuration(0);
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent e) {
    if (!e.getPlayer().isOp()) {
      e.setCancelled(true);
    }
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent e) {
    if (!e.getPlayer().isOp()) {
      e.setCancelled(true);
    }
  }

  @EventHandler
  public void onPortalTouch(PlayerPortalEvent event) {
    event.getPlayer().performCommand("");
  }

}
