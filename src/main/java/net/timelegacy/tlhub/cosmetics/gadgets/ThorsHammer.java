package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.Arrays;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class ThorsHammer extends Gadget {

  private final TLHub plugin;

  public ThorsHammer(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Thor's Hammer");
    setDisplayName(getRarity().getColor() + "Thor's Hammer");
    setLore(Arrays.asList("", "&7&oSummon the power of the god of", "&7&othunder himself with this gadget!", ""));
    setPermissionNode("hub.cosmetics.gadgets.thors_hammer");
    setCooldown(5);

    setItem(ItemUtils.createItemNoAttrib(Material.IRON_AXE, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    player.setVelocity(player.getLocation().getDirection().normalize().multiply(4));

//    new BukkitRunnable() {
//
//      @Override
//      public void run() {
//        player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
//
//        for (int i = 0; i < 50; i++) {
//          player.getWorld().strikeLightningEffect(player.getEyeLocation());
//        }
//      }
//    }.runTaskLaterAsynchronously(plugin, 20 * 3);

    new Cooldown(player.getUniqueId(), plugin.getName() + getName() + "Cooldown", getCooldown()).start();
  }

//  @EventHandler
//  public void gadgetUse(PlayerInteractEvent event) {
//    Player player = event.getPlayer();
//
//    String gadgetName = "THOR_HAMMER";
//
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
////          TTA_Methods.sendTitle(player, "&eSUMMONING THE GODS...", 20, 20, 20, "", 20, 20, 20);
//
//      new BukkitRunnable() {
//
//        @Override
//        public void run() {
//          player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
//
//          for (int i = 0; i < 50; i++) {
//            player.getWorld().strikeLightningEffect(player.getEyeLocation());
//          }
//        }
//      }.runTaskLaterAsynchronously(plugin, 20 * 3);
//
//      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
//    }
//
//  }

}
