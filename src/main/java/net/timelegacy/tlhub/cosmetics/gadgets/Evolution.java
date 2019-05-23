package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.HashMap;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Evolution implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  private int timer = 0;
  private HashMap<Player, Entity> entityHashMap = new HashMap<>();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    String gadgetName = "EVOLUTION";

    if (event.getAction() == Action.RIGHT_CLICK_AIR
        || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

      if (p.getInventory().getItemInMainHand() != null) {
        ItemStack inHand = p.getInventory().getItemInMainHand();

        if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
            .contains(gadgetName.replace("_", " ").toLowerCase())) {
          event.setCancelled(true);

          if (Cooldown.hasCooldown(p.getUniqueId(), gadgetName)) {
            MessageUtils.sendMessage(
                p, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
                    .getTimeLeft(p.getUniqueId(), gadgetName)
                    + (Cooldown.getTimeLeft(p.getUniqueId(), gadgetName) > 1 ? " seconds"
                    : " second") +
                    " before doing that again.", true);
            return;
          }

          animateVillager(p);

          new Cooldown(
              p.getUniqueId(),
              gadgetName,
              5)
              .start();
        }
      }
    }
  }

  public void animateVillager(Player player) {
    // get 5 blocks away from player eye location

    Location location = player.getLocation();

    ArmorStand armorStand = location.getWorld()
        .spawn(location.clone().add(0, 1, 0), ArmorStand.class);
    armorStand.setInvulnerable(true);
    armorStand.setVisible(false);
    armorStand.setGravity(false);
    armorStand.setAI(false);

    timer = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
        new Runnable() {
          int i = 0;
          int repeat = 0;

          public void run() {

            if (repeat < 2) {
              switch (i) {
                case 0:
                  // System.out.println(i);

                  Villager villagerBaby = location.getWorld().spawn(location, Villager.class);
                  villagerBaby.setBaby();
                  spawnMob(armorStand, villagerBaby, player);

                  location.getWorld().spawnParticle(Particle.LAVA, location, 1);
                  i++;

                  break;
                case 1:
                  // System.out.println(i);

                  Villager villager = location.getWorld().spawn(location, Villager.class);
                  villager.setAdult();
                  spawnMob(armorStand, villager, player);

                  location.getWorld().spawnParticle(Particle.LAVA, location, 1);

                  i++;

                  break;
                case 2:
                  // System.out.println(i);

                  ZombieVillager zombieVillager = location.getWorld()
                      .spawn(location, ZombieVillager.class);
                  spawnMob(armorStand, zombieVillager, player);

                  location.getWorld().spawnParticle(Particle.LAVA, location, 1);

                  i++;

                  break;
                default:
                  i = 0;
                  repeat++;
                  // System.out.println(i + " - " + repeat);

                  ZombieVillager vZ = (ZombieVillager) entityHashMap.get(player);
                  vZ.damage(Integer.MAX_VALUE);

                  location.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, location, 1);
                  break;
              }

              armorStand.setVelocity(new Vector(1.2, -1.2, -1.2));
            } else {
              Bukkit.getScheduler().cancelTask(timer);
              for (Entity e : armorStand.getPassengers()) {
                e.remove();
              }
              armorStand.remove();
              entityHashMap.remove(player);

              // System.out.println(i + " - cancel - " + repeat);
            }
          }
        }, 0, 20 * 1); // 20 ticks = 1 second. So 5 * 20 = 100 which is 5 seconds
    //}
  }

  public void spawnMob(ArmorStand armorStand, Entity mob, Player player) {
    entityHashMap.remove(player);
    entityHashMap.put(player, mob);

    for (Entity e : armorStand.getPassengers()) {
      e.remove();
    }

    armorStand.addPassenger(mob);
  }



}
