package net.timelegacy.tlhub.crates;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlcore.utils.ParticleUtils;
import net.timelegacy.tlhub.TLHub;
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

  public TLHub plugin;

  public MiniCrateFinderListener(TLHub plugin) {
    this.plugin = plugin;
  }

  public void beaconShower() {
    HashMap<Entity, Location> entityLocationHashMap = getBeacons();
    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
      public void run() {
        if (!(Bukkit.getOnlinePlayers().size() >= 1)) {
          return;
        }

        for (Map.Entry<Entity, Location> locationEntry : entityLocationHashMap.entrySet()) {
          for (Entity entity : locationEntry.getKey().getNearbyEntities(25, 25, 25)) {
            if (entity.getType() != EntityType.PLAYER) {
              return;
            }

            Player player = (Player) entity;
            if (!player.hasPermission("hub.minicrates." + locationEntry.getKey().getCustomName())) {
              Location location = locationEntry.getValue().clone().add(
                  locationEntry.getValue().getX() > 0 ? 0.5 : -0.5,
                  4.0,
                  locationEntry.getValue().getZ() > 0 ? 0.5 : -0.5);
              for (int i = 0; i < 20; i++) {
                ParticleUtils.display(Particle.VILLAGER_HAPPY, location);
//                    ParticleEffects.VILLAGER_HAPPY.display(
//                        0, 0, 0, 1, 10, location.add(0, 0.1, 0), player);

              }
            }
          }

          for (Entity entity : locationEntry.getKey().getNearbyEntities(8, 8, 8)) {
            if (entity.getType() != EntityType.PLAYER) {
              return;
            }

            Player player = (Player) entity;
            System.out.println(locationEntry.getKey().getCustomName());
            if (!player.hasPermission("hub.minicrates." + locationEntry.getKey().getCustomName())) {
              player.sendMessage(MessageUtils.colorize("&7A MiniCrate is nearby!"));
            }
          }
        }
      }

    }, 0, 5 * 20); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
  }

  public HashMap<Entity, Location> getBeacons() {
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
    Player player = event.getPlayer();
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

      for (String s : plugin.getConfig().getConfigurationSection("minicrates").getKeys(false)) {
        // TODO change to check if DOESNT have permission

        Location l2 = new Location(
            Bukkit.getWorld("world"),
            plugin.getConfig().getInt("minicrates." + s + ".x"),
            plugin.getConfig().getInt("minicrates." + s + ".y"),
            plugin.getConfig().getInt("minicrates." + s + ".z"));
        Location l1 = new Location(Bukkit.getWorld("world"), skull.getX(), skull.getY(), skull.getZ());

        System.out.println(l1.getX() + " " + l1.getY() + " " + l1.getZ());
        System.out.println(l2.getX() + " " + l2.getY() + " " + l2.getZ());

        if (l1.getX() == l2.getX() && l1.getY() == l2.getY() && l1.getZ() == l2.getZ()) {
          if (!player.hasPermission("hub.minicrates." + s)) {
            System.out.println("hub.minicrates." + s + " <----- can use");
            canUse = true;
            crateNum = s;

            break;
          }
        }
      }

      if (canUse) {
        Pair<ItemStack, String> outfit = getRandomOutfit(player);
        player.sendMessage(MessageUtils.colorize("&aYou found a " + outfit.getLeft().getItemMeta().getDisplayName()));

        PerkHandler.addPerk(player.getUniqueId(), "LOBBY.MINICRATES." + crateNum);

        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, (float) 1.0);
        ParticleUtils.display(Particle.EXPLOSION_NORMAL, skull.getLocation());
        //ParticleEffects.EXPLODE.display(0, 0, 0, 1, 10, skull.getLocation(), player);

        canUse = false;
      } else {
        player.sendMessage(MessageUtils.colorize("&cYou've already unlocked this MiniCrate!"));
      }
    }
  }

  public Pair<ItemStack, String> getRandomOutfit(Player player) {

    //CosmeticHandler.getCosmetics().get(12);

    // user
//    Random random = new Random();
//    int outfitn = random.nextInt(Outfits.values().length);
//    int piece = random.nextInt(3);
//
//    Outfits.Outfit outfit = Outfits.Outfit.values()[outfitn];
//
//    String permission;
//    ItemStack is;
//    switch (piece) {
//      default:
//        permission = outfit.getOutfitPermissions().getHelmetPermission();
//        is = outfit.getHelmet();
//        break;
//      case 1:
//        permission = outfit.getOutfitPermissions().getChestplatePermission();
//        is = outfit.getChestplate();
//        break;
//      case 2:
//        permission = outfit.getOutfitPermissions().getLeggingsPermission();
//        is = outfit.getLeggings();
//        break;
//      case 3:
//        permission = outfit.getOutfitPermissions().getBootsPermission();
//        is = outfit.getBoots();
//        break;
//    }
//
//    if (LuckPerms.getApi()
//        .getUser(p.getUniqueId())
//        .getPermissions()
//        .contains(LuckPerms.getApi().buildNode(permission).build())) {
//      return getRandomOutfit(p);
//    }
//
//    return Pair.of(is, permission);
    return null;
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