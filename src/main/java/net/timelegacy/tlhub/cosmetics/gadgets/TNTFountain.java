package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.Arrays;
import java.util.Random;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class TNTFountain extends Gadget implements Listener {

  private final TLHub plugin;

  public TNTFountain(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("TNT Fountain");
    setDisplayName(getRarity().getColor() + "TNT Fountain");
    setLore(Arrays.asList("", "&7&oIt's about time something was created to", "&7&oplease the demolitionist in me.", ""));
    setPermissionNode("hub.cosmetics.gadgets.tnt_fountain");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.TNT, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    Block block = getTargetBlock(player, 6);

    new BukkitRunnable() {
      int step = 0;

      public void run() {
        ++this.step;

        if (this.step <= 15) {
          TNTPrimed entityTnt = block.getLocation().getWorld().spawn(block.getLocation().add(0.0, 0.25, 0.0), TNTPrimed.class);
          entityTnt.setYield(0F);
          entityTnt.setMetadata(plugin.getName(), new FixedMetadataValue(plugin, true));
          entityTnt.setVelocity(new Vector(
              (new Random().nextDouble() - 0.5) * 0.7,
              1.25,
              (new Random().nextDouble() - 0.5) * 0.7));
          return;
        }

        this.cancel();
      }
    }.runTaskTimer(plugin, 0L, 8L);

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
//    String gadgetName = "TNT_FOUNTAIN";
//    ItemStack is = event.getItem();
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
//      Block b = getTargetBlock(player, 6);
//
//      new BukkitRunnable() {
//        int step = 0;
//
//        public void run() {
//          ++this.step;
//
//          if (this.step <= 15) {
//            final TNTPrimed entityTnt = b.getLocation().getWorld().spawn(b.getLocation().add(0.0, 0.25, 0.0), TNTPrimed.class);
//            entityTnt.setMetadata(plugin.getName(), new FixedMetadataValue(plugin, true));
//            entityTnt.setVelocity(
//                new Vector(
//                    (new Random().nextDouble() - 0.5) * 0.7,
//                    1.25,
//                    (new Random().nextDouble() - 0.5) * 0.7));
//            return;
//          }
//
//          this.cancel();
//        }
//      }.runTaskTimer(plugin, 0L, 8L);
//
//      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
//    }
//
//  }

  @EventHandler
  public void onEntityExplode(EntityExplodeEvent event) {
    if (!event.getEntity().hasMetadata(plugin.getName())) {
      return;
    }

    event.setCancelled(true);
  }

  private Block getTargetBlock(final Player player, final int range) {
    try {
      return player.getTargetBlock(null, range);
    } catch (IllegalStateException e) {
      return null;
    }
  }


}
