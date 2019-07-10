package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class AnimalCannon extends Gadget implements Listener {

  private final TLHub plugin;

  public AnimalCannon(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Animal Cannon");
    setDisplayName(getRarity().getColor() + "Animal Cannon");
    setLore(Arrays.asList("", "&7&oBe careful, animal rights activists might be", "&7&owatching from afar.", ""));
    setPermissionNode("hub.cosmetics.gadgets.animal_cannon");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.EGG, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    Egg egg = player.launchProjectile(Egg.class);
    egg.setMetadata("AnimalCannon", new FixedMetadataValue(plugin, "AnimalCannonEgg"));

    new Cooldown(player.getUniqueId(), plugin.getName() + getName() + "Cooldown", getCooldown()).start();
  }

  @Override
  public void registerExtraListeners() {
    Bukkit.getPluginManager().registerEvents(this, plugin);
  }

  //  @EventHandler
//  public void gadgetUse(PlayerInteractEvent event) {
//    Player player = event.getPlayer();
//
//    String gadgetName = "ANIMAL_CANNON";
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
//        MessageUtils.sendMessage(player, MessageUtils.ERROR_COLOR + "You must wait " +
//            Cooldown.getTimeLeft(player.getUniqueId(), gadgetName)
//            + (Cooldown.getTimeLeft(player.getUniqueId(), gadgetName) > 1 ? " seconds"
//            : " second") +
//            " before doing that again.", true);
//        return;
//      }
//
//      ItemStack is2 = inHand.clone();
//      is2.setAmount(1);
//      Item i = player.getWorld().dropItem(player.getLocation(), is2);
//      i.setVelocity(player.getLocation().clone().add(0.0D, 1.5D, 0.0D).getDirection().normalize());
//      i.setPickupDelay(5000);
//
//      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
//        i.remove();
//        spawnAnimals(i.getLocation());
//      }, 20);
//
//      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
//    }
//
//
//  }

  @EventHandler
  public void onEggHit(ProjectileHitEvent event) {
    if (!(event.getEntity() instanceof Egg)) {
      return;
    }

    if (!event.getEntity().hasMetadata("AnimalCannon")) {
      return;
    }

    spawnAnimals(event.getEntity().getLocation());
  }

  private void spawnAnimals(Location location) {
    List<EntityType> animals = new ArrayList<>();
    int diameter = 5;
    animals.add(EntityType.PIG);
    animals.add(EntityType.COW);
    animals.add(EntityType.SHEEP);
    animals.add(EntityType.CHICKEN);
    animals.add(EntityType.RABBIT);
    animals.add(EntityType.WOLF);
    animals.add(EntityType.OCELOT);
    animals.add(EntityType.HORSE);
    animals.add(EntityType.DONKEY);
    animals.add(EntityType.MULE);

    List<Entity> spawned = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
      Location newLocation = location.add(new Vector(Math.random() - 0.5, 0, Math.random() - 0.5).multiply(diameter));
      spawned.add(location.getWorld().spawnEntity(newLocation, animals.get(new Random().nextInt(10))));
    }

    location.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, location, 1);
    location.getWorld().playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);

    new BukkitRunnable() {

      @Override
      public void run() {
        for (Entity e : spawned) {
          e.remove();
        }
      }
    }.runTaskLaterAsynchronously(plugin, 20 * 7);
  }


}
