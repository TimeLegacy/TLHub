package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.enums.Rarity;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class HeadRider extends Gadget {

  private final TLHub plugin;

  public HeadRider(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Head Rider");
    setDisplayName(getRarity().getColor() + "Head Rider");
    setLore(Arrays.asList("", "&7&oRide players", "&7&ojust for the fun of it.", ""));
    setPermissionNode("hub.cosmetics.gadgets.head_rider");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.SADDLE, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEntityEvent event) {
    Player player = event.getPlayer();
    Player rightClicked = (Player) event.getRightClicked();

    if (getTopPlayer(player) == rightClicked) {
      return;
    }

    getTopPlayer(player).addPassenger(rightClicked);

    new Cooldown(player.getUniqueId(), plugin.getName() + getName() + "Cooldown", getCooldown()).start();
  }

//  private void gadgetUse(PlayerInteractEntityEvent event) {
//    Player p = event.getPlayer();
//
//    String gadgetName = "HEAD_RIDER";
//    ItemStack is = event.getPlayer().getItemOnCursor();
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
//    if (!(event.getRightClicked() instanceof Player)) {
//      return;
//    }
//
//    Player rightClicked = (Player) event.getRightClicked();
//
//    if (p.getInventory().getItemInMainHand() != null) {
//      ItemStack inHand = p.getInventory().getItemInMainHand();
//
//      if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
//          .contains(gadgetName.replace("_", " ").toLowerCase())) {
//        event.setCancelled(true);
//
//        if (Cooldown.hasCooldown(p.getUniqueId(), gadgetName)) {
//          MessageUtils.sendMessage(
//              p, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
//                  .getTimeLeft(p.getUniqueId(), gadgetName)
//                  + (Cooldown.getTimeLeft(p.getUniqueId(), gadgetName) > 1 ? " seconds" : " second")
//                  +
//                  " before doing that again.", true);
//          return;
//        }
//
//        if (getTopPlayer(p) == rightClicked) {
//          return;
//        }
//
//        getTopPlayer(p).addPassenger(rightClicked);
//
//        //do gadget shit here
//
//        new Cooldown(p.getUniqueId(), gadgetName, 5).start();
//      }
//    }
//  }

  @EventHandler
  public void onPunchInteract(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof Player)) {
      return;
    }

    if (!(event.getEntity() instanceof Player)) {
      return;
    }

    String gadgetName = "HEAD_RIDER";

    Player player = (Player) event.getDamager();
    ItemStack inHand = player.getInventory().getItemInMainHand();

    if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
        .contains(gadgetName.replace("_", " ").toLowerCase())) {
      event.setCancelled(true);

      if (Cooldown.hasCooldown(player.getUniqueId(), gadgetName)) {
        MessageUtils.sendMessage(
            player,
            MessageUtils.ERROR_COLOR
                + "You must wait "
                + Cooldown.getTimeLeft(player.getUniqueId(), gadgetName)
                + (Cooldown.getTimeLeft(player.getUniqueId(), gadgetName) > 1 ? " seconds"
                : " second")
                + " before doing that again.",
            true);
        return;
      }

      Player target = (Player) event.getEntity();
      List<Player> list = new ArrayList<>();
      if (!getAllOnPlayer(list, player).getLeft().contains(target)) {
        return;
      }

      event.setCancelled(true);
      event.setDamage(0);

      for (Player p : getAllOnPlayer(list, player).getLeft()) {
        p.teleport(p.getLocation().add(0, 0.5, 0));
        p.setVelocity(player.getLocation().getDirection().multiply(3));
      }
    }
  }

  private Player getTopPlayer(Player p) {
    if (p.getPassengers().size() > 0) {
      for (Entity e : p.getPassengers()) {
        if (e instanceof Player) {
          return getTopPlayer((Player) e);
        }
      }
    }

    return p;
  }

  private Pair<List<Player>, Player> getAllOnPlayer(List<Player> list, Player p) {
    if (p.getPassengers().size() > 0) {
      for (Entity e : p.getPassengers()) {
        if (e instanceof Player) {
          list.add((Player) e);
          return Pair.of(list, getAllOnPlayer(list, (Player) e).getRight());
        }
      }
    }

    return Pair.of(list, p);
  }


}
