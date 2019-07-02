package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.Arrays;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class ExplosiveSnowball extends Gadget implements Listener {

  private final TLHub plugin;

  public ExplosiveSnowball(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Explosive Snowball");
    setDisplayName(getRarity().getColor() + "Explosive Snowball");
    setLore(Arrays.asList("", "&7&oThese aren't your ordinary snowballs.", "&7&oThey pack an extra punch in them.", ""));
    setPermissionNode("hub.cosmetics.gadgets.explosive_snowball");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.SNOWBALL, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    Snowball snowball = player.launchProjectile(Snowball.class);
    snowball.setMetadata("explosiveSnowball", new FixedMetadataValue(plugin, "ExplosiveSnowball"));
  }

  @Override
  public void registerExtraListeners() {
    Bukkit.getPluginManager().registerEvents(this, plugin);
  }

  //  @EventHandler
//  public void gadgetUse(PlayerInteractEvent event) {
//    Player player = event.getPlayer();
//
//    String gadgetName = "EXPLOSIVE_SNOWBALL";
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
//      Snowball snowball = player.launchProjectile(Snowball.class);
//      snowball.setMetadata("explosiveSnowball", new FixedMetadataValue(plugin, "ExplosiveSnowball"));
//
//      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
//    }
//
//  }

  @EventHandler
  public void onExplosiveSnowballHit(ProjectileHitEvent event) {
    if (!(event.getEntity() instanceof Snowball)) {
      return;
    }

    if (!event.getEntity().hasMetadata("explosiveSnowball")) {
      return;
    }

    event.getEntity().getWorld().playSound(event.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
    event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, event.getEntity().getLocation(), 1);
  }

}
