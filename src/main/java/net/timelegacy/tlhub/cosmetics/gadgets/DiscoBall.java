package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DiscoBall extends Gadget {

  private final TLHub plugin;

  public DiscoBall(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Disco Ball");
    setDisplayName(getRarity().getColor() + "Disco Ball");
    setLore(Arrays.asList("", "&7&oIt's party time anytime with", "&7&othis gadget!", ""));
    setPermissionNode("hub.cosmetics.gadgets.disco_ball");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.PURPLE_STAINED_GLASS, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    Location loc = player.getLocation().add(0, 5, 0).clone();

    Block originalBlock = loc.getBlock();
    BlockData originalBlockData = originalBlock.getBlockData();
    BlockState originalBlockState = originalBlock.getState();
    Material originalMaterial = originalBlock.getType();

    new BukkitRunnable() {
      int i = 0;
      Block block = loc.getBlock();

      List<Material> glass = Arrays
          .asList(Material.PURPLE_STAINED_GLASS, Material.MAGENTA_STAINED_GLASS,
              Material.RED_STAINED_GLASS, Material.PINK_STAINED_GLASS,
              Material.BLUE_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS, Material.CYAN_STAINED_GLASS,
              Material.ORANGE_STAINED_GLASS, Material.YELLOW_STAINED_GLASS,
              Material.LIME_STAINED_GLASS);

      @Override
      public void run() {
        i++;

        block.getWorld().spawnParticle(Particle.NOTE, block.getLocation().add(
            new Random().nextDouble(),
            new Random().nextDouble(),
            new Random().nextDouble()),
            1);

        block.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,
            block.getLocation().getX(),
            block.getLocation().getY(),
            block.getLocation().getZ(),
            5,
            1D,
            1D,
            1D,
            0.1D);
        // <AMOUNT> <OFFSET X> <OFFSET Y> <OFFSET Z> <SPEED>
        block.setType(glass.get(new Random().nextInt(glass.size())));

        if (i >= 100) {
          originalBlock.setType(originalMaterial);
          originalBlockState.setBlockData(originalBlockData);
          originalBlockState.update();
          cancel();
        }
      }
    }.runTaskTimer(plugin, 1, 4);

    //do gadget shit here

    //new Cooldown(player.getUniqueId(), getDisplayName(), getCooldown()).start();
  }

//  @EventHandler
//  public void gadgetUse(PlayerInteractEvent event) {
//    Player player = event.getPlayer();
//
//    String gadgetName = "DISCO_BALL";
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
//      Location loc = player.getLocation().add(0, 5, 0).clone();
//
//      Block originalBlock = loc.getBlock();
//      BlockData originalBlockData = originalBlock.getBlockData();
//      BlockState originalBlockState = originalBlock.getState();
//      Material originalMaterial = originalBlock.getType();
//
//      new BukkitRunnable() {
//        int i = 0;
//        Block block = loc.getBlock();
//
//        List<Material> glass = Arrays
//            .asList(Material.PURPLE_STAINED_GLASS, Material.MAGENTA_STAINED_GLASS,
//                Material.RED_STAINED_GLASS, Material.PINK_STAINED_GLASS,
//                Material.BLUE_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS, Material.CYAN_STAINED_GLASS,
//                Material.ORANGE_STAINED_GLASS, Material.YELLOW_STAINED_GLASS,
//                Material.LIME_STAINED_GLASS);
//
//        @Override
//        public void run() {
//          i++;
//
//          block.getWorld().spawnParticle(Particle.NOTE, block.getLocation().add(
//              new Random().nextDouble(),
//              new Random().nextDouble(),
//              new Random().nextDouble()),
//              1);
//
//          block.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,
//              block.getLocation().getX(),
//              block.getLocation().getY(),
//              block.getLocation().getZ(),
//              5,
//              1D,
//              1D,
//              1D,
//              0.1D);
//          // <AMOUNT> <OFFSET X> <OFFSET Y> <OFFSET Z> <SPEED>
//          block.setType(glass.get(new Random().nextInt(glass.size())));
//
//          if (i >= 100) {
//            originalBlock.setType(originalMaterial);
//            originalBlockState.setBlockData(originalBlockData);
//            originalBlockState.update();
//            cancel();
//          }
//        }
//      }.runTaskTimer(plugin, 1, 4);
//
//      //do gadget shit here
//
//      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
//    }
//  }

}
