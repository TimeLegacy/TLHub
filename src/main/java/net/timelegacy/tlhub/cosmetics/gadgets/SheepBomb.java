package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.Arrays;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class SheepBomb extends Gadget {

  private final TLHub plugin;

  public SheepBomb(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Sheep Bomb");
    setDisplayName(getRarity().getColor() + "Sheep Bomb");
    setLore(Arrays.asList("", "&7&oAre you sure that it's supposed to be flashing?", "&7&oUhhh, yes...?", ""));
    setPermissionNode("hub.cosmetics.gadgets.sheep_bomb");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.SHEEP_SPAWN_EGG, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    new BukkitRunnable() {
      double time = 3.0;

      @Override
      public void run() {
        World world = player.getWorld();
        Sheep sheep = world.spawn(player.getLocation(), Sheep.class);
        sheep.setNoDamageTicks(100000);
        sheep.setMetadata("NOSHEAR4U", new FixedMetadataValue(plugin, "NOSHEAR4U"));
        sheep.setVelocity(player.getEyeLocation().getDirection().multiply(0.7D));

        new BukkitRunnable() {
          boolean red = true;

          @Override
          public void run() {
            if (time < 0.5) {
              world.spawnParticle(Particle.EXPLOSION_HUGE, sheep.getLocation(), 2);
              world.playSound(sheep.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
              sheep.remove();
              cancel();
              return;
            }

            if (red) {
              sheep.setColor(DyeColor.RED);
            } else {
              sheep.setColor(DyeColor.WHITE);
            }

            world.playSound(sheep.getLocation(), Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, 1,
                1);

            red = !red;
            time -= 0.2;
          }
        }.runTaskTimer(plugin, 0, 5);
      }
    }.runTaskLater(plugin, 1);

    new Cooldown(player.getUniqueId(), plugin.getName() + getName() + "Cooldown", getCooldown()).start();
  }

//  @EventHandler
//  public void gadgetUse(PlayerInteractEvent event) {
//    Player player = event.getPlayer();
//
//    String gadgetName = "SHEEP_BOMB";
//    ItemStack is = event.getItem();
//
//    if (is == null) {
//      return;
//    }
//
//    if (is.getType() == Material.AIR) {
//      return;
//    }
//
//    if (!is.hasItemMeta()) {
//      return;
//    }
//
//    if (!is.getItemMeta().hasDisplayName()) {
//      return;
//    }
//
//    if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
//      return;
//    }
//
//    if (player.getInventory().getItemInMainHand() == null) {
//      return;
//    }
//
//    ItemStack inHand = player.getInventory().getItemInMainHand();
//
//    if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
//        .contains(gadgetName.replace("_", " ").toLowerCase())) {
//      event.setCancelled(true);
//
//      if (Cooldown.hasCooldown(player.getUniqueId(), gadgetName)) {
//        MessageUtils.sendMessage(
//            player, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
//                .getTimeLeft(player.getUniqueId(), gadgetName)
//                + (Cooldown.getTimeLeft(player.getUniqueId(), gadgetName) > 1 ? " seconds"
//                : " second") +
//                " before doing that again.", true);
//        return;
//      }
//
//      new BukkitRunnable() {
//        double time = 3.0;
//
//        @Override
//        public void run() {
//          World world = player.getWorld();
//          Sheep sheep = world.spawn(player.getLocation(), Sheep.class);
//          sheep.setNoDamageTicks(100000);
//          sheep.setMetadata("NOSHEAR4U", new FixedMetadataValue(plugin, "NOSHEAR4U"));
//          sheep.setVelocity(player.getEyeLocation().getDirection().multiply(0.7D));
//
//          new BukkitRunnable() {
//            boolean red = true;
//
//            @Override
//            public void run() {
//              if (time < 0.5) {
//                world.spawnParticle(Particle.EXPLOSION_HUGE, sheep.getLocation(), 2);
//                world.playSound(sheep.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
//                sheep.remove();
//                cancel();
//                return;
//              }
//
//              if (red) {
//                sheep.setColor(DyeColor.RED);
//              } else {
//                sheep.setColor(DyeColor.WHITE);
//              }
//
//              world.playSound(sheep.getLocation(), Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, 1,
//                  1);
//
//              red = !red;
//              time -= 0.2;
//            }
//          }.runTaskTimer(plugin, 0, 5);
//        }
//      }.runTaskLater(plugin, 1);
//
//      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
//    }
//
//  }

}
