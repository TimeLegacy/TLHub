package net.timelegacy.tlhub.crates;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlcore.utils.FlyingItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.gadgets.Gadget;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class MiniCrateFinderListener implements Listener {

  private final TLHub plugin;
  private Map<Location, String> minicrates = new HashMap<>();

  public MiniCrateFinderListener(TLHub plugin) {
    this.plugin = plugin;

    for (String s : plugin.getConfig().getConfigurationSection("minicrates").getKeys(false)) {
      Location location = new Location(
          Bukkit.getWorld("world"),
          plugin.getConfig().getDouble("minicrates." + s + ".x"),
          plugin.getConfig().getDouble("minicrates." + s + ".y"),
          plugin.getConfig().getDouble("minicrates." + s + ".z"));
      minicrates.put(location, s);
    }
  }

  public void startRunnable() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
      if (minicrates.isEmpty()) {
        return;
      }

      if (!(Bukkit.getOnlinePlayers().size() >= 1)) {
        return;
      }

      for (Location loc : minicrates.keySet()) {
        for (Entity entity : loc.getWorld().getNearbyEntities(loc, 25, 25, 25)) {
          if (entity.getType() != EntityType.PLAYER) {
            continue;
          }

          Player player = (Player) entity;
          if (PerkHandler.hasPerk(player.getUniqueId(), "hub.minicrates." + minicrates.get(loc))) {
            return;
          }

          Location location = loc.clone().add(
              0.5,
              1.0,
              0.5);

          for (int i = 0; i < 10; i++) {
            ParticleUtils.display(Particle.VILLAGER_HAPPY, location);
          }
        }
      }
    }, 0, 5 * 20);
  }

//  public void beaconShower() {
//    HashMap<Entity, Location> entityLocationHashMap = getBeacons();
//    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
//      if (!(Bukkit.getOnlinePlayers().size() >= 1)) {
//        return;
//      }
//
//      for (Map.Entry<Entity, Location> locationEntry : entityLocationHashMap.entrySet()) {
//        for (Entity entity : locationEntry.getKey().getNearbyEntities(25, 25, 25)) {
//          if (entity.getType() != EntityType.PLAYER) {
//            continue;
//          }
//
//          Player player = (Player) entity;
//          if (PerkHandler.hasPerk(player.getUniqueId(), "hub.minicrates." + locationEntry.getKey().getCustomName())) {
//            return;
//          }
//
//          Location location = locationEntry.getValue().clone().add(
//              locationEntry.getValue().getX() > 0 ? 0.5 : -0.5,
//              4.0,
//              locationEntry.getValue().getZ() > 0 ? 0.5 : -0.5);
//          for (int i = 0; i < 20; i++) {
//            ParticleUtils.display(Particle.VILLAGER_HAPPY, location);
//          }
//
//        }
//
//        for (Entity entity : locationEntry.getKey().getNearbyEntities(8, 8, 8)) {
//          if (entity.getType() != EntityType.PLAYER) {
//            continue;
//          }
//
//          Player player = (Player) entity;
//          System.out.println(locationEntry.getKey().getCustomName());
//          if (PerkHandler.hasPerk(player.getUniqueId(), "hub.minicrates." + locationEntry.getKey().getCustomName())) {
//            return;
//          }
//
//          player.sendMessage(MessageUtils.colorize("&7A MiniCrate is nearby!"));
//
////          if (!player.hasPermission("hub.minicrates." + locationEntry.getKey().getCustomName())) {
////            player.sendMessage(MessageUtils.colorize("&7A MiniCrate is nearby!"));
////          }
//        }
//      }
//    }, 0, 5 * 20); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
//  }

  private HashMap<Entity, Location> getBeacons() {
    HashMap<Entity, Location> beacons = new HashMap<>();

    for (String s : plugin.getConfig().getConfigurationSection("minicrates").getKeys(false)) {
      Location location = new Location(
          Bukkit.getWorld("world"),
          plugin.getConfig().getDouble("minicrates." + s + ".x"),
          plugin.getConfig().getDouble("minicrates." + s + ".y"),
          plugin.getConfig().getDouble("minicrates." + s + ".z"));

      ArmorStand armorStand = Bukkit.getWorld("world").spawn(location, ArmorStand.class);
      armorStand.setVisible(false);
      armorStand.setCustomName(s);
      armorStand.setCustomNameVisible(false);
      armorStand.teleport(armorStand.getLocation().clone().subtract(0, 3, 0));
      armorStand.setGravity(false);
      armorStand.setInvulnerable(true);

      beacons.put(armorStand, armorStand.getLocation());
    }

    return beacons;
  }

  public void unloadMiniCrates() {
    for (Map.Entry<Entity, Location> locationEntry : getBeacons().entrySet()) {
      locationEntry.getKey().remove();
    }
  }

  /**
   * Mini Crates work by; When a player gets close to one they have not unlocked yet, it will display a beacon `like`
   * effect. When the player clicks it... it does fancy particle thing yada yada... And they get one of the outfits that
   * they don't have yet.
   */
  @EventHandler
  public void onInteract(PlayerInteractEvent event) {
    if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
      return;
    }

    if (event.getClickedBlock() == null || event.getClickedBlock().getType().equals(Material.AIR)) {
      return;
    }

    Block block = event.getClickedBlock();

    if (!block.getType().equals(Material.PLAYER_HEAD)) {
      return;
    }

    Skull skull = (Skull) block.getState();

    EquipmentSlot slot = event.getHand();
    if (slot.equals(EquipmentSlot.HAND)) { // If the event is fired by HAND (main hand)
      // Do stuff

      /*System.out.println(" x:" + block.getX() + " y:" + block.getY() + " z:" + block.getZ());
      plugin.getConfig().set("minicrates." + plugin.getConfig().getInt("minicratecount") + ".x", block.getX());
      plugin.getConfig().set("minicrates." + plugin.getConfig().getInt("minicratecount") + ".y", block.getY());
      plugin.getConfig().set("minicrates." + plugin.getConfig().getInt("minicratecount") + ".z", block.getZ());
      plugin.getConfig().set("minicratecount", plugin.getConfig().getInt("minicratecount") + 1);

      plugin.saveConfig();*/
      boolean canUse = false;
      String crateNum = "0";

      if (plugin.getConfig().getConfigurationSection("minicrates") == null) {
        System.out.println("Configuration Section `minicrates` doesn't exist!");
        return;
      }

      Player player = event.getPlayer();

      for (String s : plugin.getConfig().getConfigurationSection("minicrates").getKeys(false)) {
        // TODO change to check if DOESNT have permission

        Location l1 = new Location(Bukkit.getWorld("world"), skull.getX(), skull.getY(), skull.getZ());
        Location l2 = new Location(
            Bukkit.getWorld("world"),
            plugin.getConfig().getInt("minicrates." + s + ".x"),
            plugin.getConfig().getInt("minicrates." + s + ".y"),
            plugin.getConfig().getInt("minicrates." + s + ".z"));

        System.out.println(l1.getX() + " " + l1.getY() + " " + l1.getZ());
        System.out.println(l2.getX() + " " + l2.getY() + " " + l2.getZ());

        if (l1.getX() == l2.getX() && l1.getY() == l2.getY() && l1.getZ() == l2.getZ()) {
          if (!PerkHandler.hasPerk(player.getUniqueId(), "lobby.minicrates." + s)) {
            canUse = true;
            crateNum = s;
            break;
          }
        }
      }

      if (!canUse) {
        player.sendMessage(MessageUtils.colorize("&cYou've already unlocked this MiniCrate!"));
        return;
      }

      Pair<Gadget, String> gadget = getRandomGadget();
      player.sendMessage(
          MessageUtils.colorize("&aYou found a " + gadget.getLeft().getItem().getItemMeta().getDisplayName()));

      PerkHandler.addPerk(player.getUniqueId(), "lobby.minicrates." + crateNum);
      PerkHandler.addPerk(player.getUniqueId(), gadget.getLeft().getPermissionNode());

      player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, (float) 1.0);
      ParticleUtils.display(Particle.EXPLOSION_NORMAL, skull.getLocation());

      Location location = new Location(
          Bukkit.getWorld("world"),
          plugin.getConfig().getInt("minicrates." + crateNum + ".x"),
          plugin.getConfig().getInt("minicrates." + crateNum + ".y"),
          plugin.getConfig().getInt("minicrates." + crateNum + ".z"));

      animateItem(player, location, gadget.getLeft().getItem());

      //animation(minicrateLocation, outfit.getLeft());
      //ParticleEffects.EXPLODE.display(0, 0, 0, 1, 10, skull.getLocation(), player);
    }
  }

  private int task;

  public void animateItem(Player player, Location location, ItemStack itemStack) {

    Location teleported = location.clone().clone().add(0.5, 0.5, 0.5);

    FlyingItemUtils flyingItem = new FlyingItemUtils();
    flyingItem.setText(itemStack.getItemMeta().getDisplayName());
    flyingItem.setItemStack(itemStack);
    flyingItem.setLocation(teleported);
    flyingItem.spawn();

    //  2 = left 0 = middle, 1 = right
    task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
      int timer;

      @Override
      public void run() {
        // TODO - make faster?
        timer++;

        System.out.println(timer);
        if (timer == 20) {
          flyingItem.remove();

          Bukkit.getScheduler().cancelTask(task);

          Bukkit.getServer().getScheduler().cancelTask(task);
        }
      }
    }, 0, 5);
  }


  private void animation(Location location, Gadget gadget) {
    ArmorStand as = location.getWorld().spawn(location, ArmorStand.class);

    as.setBasePlate(false);
    as.setVisible(false);
    as.setArms(false);
    as.setInvulnerable(true);
    as.setCanPickupItems(false);
    as.setHelmet(gadget.getItem());

    as.setCustomName(MessageUtils.colorize(gadget.getDisplayName()));
    as.setCustomNameVisible(true);

    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
      @Override
      public void run() {
        as.remove();
      }
    }, 20 * 5);
  }

  private Pair<Gadget, String> getRandomGadget() {
    plugin.getCosmeticHandler().getGadgets();

    Random random = new Random();
    int gadgetN = random.nextInt(plugin.getCosmeticHandler().getGadgets().size());
    Gadget gadget = plugin.getCosmeticHandler().getGadgets().get(gadgetN);

    return Pair.of(gadget, gadget.getPermissionNode());
  }

  private void launchFirework(Location loc, double d) {
    Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
    FireworkMeta fwm = fw.getFireworkMeta();
    FireworkEffect.Builder b = FireworkEffect.builder();

    if (d > 0.95) {
      b.with(FireworkEffect.Type.BURST);
      b.flicker(false);
      b.withColor(Arrays.asList(
          Color.RED,
          Color.ORANGE,
          Color.YELLOW,
          Color.GREEN,
          Color.BLUE,
          Color.PURPLE,
          Color.WHITE));
      b.withFade(Arrays.asList(
          Color.RED,
          Color.ORANGE,
          Color.YELLOW,
          Color.GREEN,
          Color.BLUE,
          Color.PURPLE,
          Color.WHITE));
      fwm.setPower(3);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.85) {
      b.with(FireworkEffect.Type.BALL_LARGE);
      b.flicker(false);
      b.withColor(Arrays.asList(
          Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.WHITE));
      b.withFade(Arrays.asList(Color.GREEN, Color.BLUE));
      fwm.setPower(3);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.75) {
      b.with(FireworkEffect.Type.STAR);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.GREEN, Color.PURPLE, Color.TEAL, Color.LIME));
      b.withFade(Arrays.asList(Color.LIME, Color.TEAL));
      fwm.setPower(3);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.65) {
      b.with(FireworkEffect.Type.BURST);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.OLIVE, Color.RED, Color.YELLOW, Color.PURPLE));
      b.withFade(Arrays.asList(Color.OLIVE, Color.RED));
      fwm.setPower(3);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.55) {
      b.with(FireworkEffect.Type.BURST);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.GREEN, Color.AQUA, Color.GRAY));
      b.withFade(Arrays.asList(Color.GREEN, Color.AQUA, Color.GRAY));
      fwm.setPower(2);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.45) {
      b.with(FireworkEffect.Type.BURST);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.BLUE, Color.PURPLE, Color.FUCHSIA));
      b.withFade(Arrays.asList(Color.BLUE, Color.PURPLE, Color.FUCHSIA));
      fwm.setPower(2);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.35) {
      b.with(FireworkEffect.Type.BALL_LARGE);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.WHITE, Color.ORANGE, Color.YELLOW));
      b.withFade(Arrays.asList(Color.WHITE, Color.ORANGE, Color.YELLOW));
      fwm.setPower(2);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.25) {
      b.with(FireworkEffect.Type.BALL);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.BLACK, Color.WHITE, Color.GRAY));
      b.withFade(Arrays.asList(Color.BLACK, Color.WHITE, Color.GRAY));
      fwm.setPower(2);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.15) {
      b.with(FireworkEffect.Type.STAR);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.WHITE, Color.BLUE));
      b.withFade(Arrays.asList(Color.WHITE, Color.BLUE));
      fwm.setPower(1);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else if (d > 0.05) {
      b.with(FireworkEffect.Type.BURST);
      b.flicker(false);
      b.withColor(Arrays.asList(Color.ORANGE, Color.RED));
      b.withFade(Arrays.asList(Color.ORANGE, Color.RED));
      fwm.setPower(1);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    } else {
      b.with(FireworkEffect.Type.BALL);
      b.flicker(false);
      b.withColor(Collections.singletonList(Color.RED));
      b.withFade(Arrays.asList(Color.RED, Color.WHITE));
      fwm.setPower(1);
      fwm.addEffect(b.build());
      fw.setFireworkMeta(fwm);
    }

    new BukkitRunnable() {
      @Override
      public void run() {
        fw.detonate();
      }
    }.runTaskLater(plugin, 1);
  }
}