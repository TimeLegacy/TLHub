package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class PaintballGun implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  private static HashMap<Block, Double> getInRadius(Block block, double dR) {
    HashMap<Block, Double> blockList = new HashMap<>();
    int iR = (int) dR + 1;

    for (int x = -iR; x <= iR; x++) {
      for (int z = -iR; z <= iR; z++) {
        for (int y = -iR; y <= iR; y++) {
          Block curBlock = block.getRelative(x, y, z);

          double offset = block.getLocation().toVector().subtract(curBlock.getLocation().toVector())
              .length();

          if (offset <= dR) {
            blockList.put(curBlock, 1.0D - offset / dR);
          }
        }
      }
    }

    return blockList;
  }

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    String gadgetName = "PAINTBALL_GUN";
    ItemStack is = event.getItem();

    if (is == null) {
      return;
    }

    if (is.getType() == Material.AIR) {
      return;
    }

    if (!is.hasItemMeta()) {
      return;
    }

    if (!is.getItemMeta().hasDisplayName()) {
      return;
    }

    if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }

    if (player.getInventory().getItemInMainHand() == null) {
      return;
    }

    ItemStack inHand = player.getInventory().getItemInMainHand();

    if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
        .contains(gadgetName.replace("_", " ").toLowerCase())) {
      event.setCancelled(true);

      if (Cooldown.hasCooldown(player.getUniqueId(), gadgetName)) {
        MessageUtils.sendMessage(
            player, MessageUtils.ERROR_COLOR + "You must wait " + Cooldown
                .getTimeLeft(player.getUniqueId(), gadgetName)
                + (Cooldown.getTimeLeft(player.getUniqueId(), gadgetName) > 1 ? " seconds"
                : " second") +
                " before doing that again.", true);
        return;
      }

      Snowball snowball = player.launchProjectile(Snowball.class);
      snowball.setMetadata("paintball", new FixedMetadataValue(plugin, "Paintball"));

      player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 2F);

      new Cooldown(player.getUniqueId(), gadgetName, 5).start();
    }

  }

  @EventHandler
  public void onPaintballHit(ProjectileHitEvent e) {
    if (!(e.getEntity() instanceof Snowball)) {
      return;
    }

    if (!e.getEntity().hasMetadata("paintball")) {
      return;
    }

    List<Material> ignoredBlocks = new ArrayList<>();
    ignoredBlocks.add(Material.AIR);
    ignoredBlocks.add(Material.BARRIER);
    ignoredBlocks.add(Material.NETHER_PORTAL);
    ignoredBlocks.add(Material.END_PORTAL);
    ignoredBlocks.add(Material.CRAFTING_TABLE);
    ignoredBlocks.add(Material.CHEST);
    ignoredBlocks.add(Material.ENDER_CHEST);
    ignoredBlocks.add(Material.ENCHANTING_TABLE);
    ignoredBlocks.add(Material.END_PORTAL_FRAME);
    ignoredBlocks.add(Material.FURNACE);
    ignoredBlocks.add(Material.CAULDRON);
    ignoredBlocks.add(Material.HOPPER);
    ignoredBlocks.add(Material.ANVIL);
    ignoredBlocks.add(Material.LADDER);
    ignoredBlocks.add(Material.LEGACY_CARPET);
    ignoredBlocks.add(Material.LEGACY_STAINED_CLAY);
    ignoredBlocks.add(Material.COBBLESTONE_WALL);
    ignoredBlocks.add(Material.REDSTONE_LAMP);
    ignoredBlocks.add(Material.LEGACY_BED_BLOCK);
    ignoredBlocks.add(Material.RAIL);
    ignoredBlocks.add(Material.POWERED_RAIL);
    ignoredBlocks.add(Material.ACTIVATOR_RAIL);
    ignoredBlocks.add(Material.DETECTOR_RAIL);
    ignoredBlocks.add(Material.LEGACY_WOOD_BUTTON);
    ignoredBlocks.add(Material.STONE_BUTTON);
    ignoredBlocks.add(Material.LEGACY_WOOD_PLATE);
    ignoredBlocks.add(Material.LEGACY_STONE_PLATE);
    ignoredBlocks.add(Material.LEGACY_IRON_PLATE);
    ignoredBlocks.add(Material.LEGACY_GOLD_PLATE);
    ignoredBlocks.add(Material.LEGACY_LONG_GRASS);
    ignoredBlocks.add(Material.LEGACY_DOUBLE_PLANT);
    ignoredBlocks.add(Material.LEGACY_RED_ROSE);
    ignoredBlocks.add(Material.LEGACY_YELLOW_FLOWER);
    ignoredBlocks.add(Material.DEAD_BUSH);
    ignoredBlocks.add(Material.COBWEB);
    ignoredBlocks.add(Material.RED_MUSHROOM);
    ignoredBlocks.add(Material.BROWN_MUSHROOM);
    ignoredBlocks.add(Material.WATER);
    ignoredBlocks.add(Material.LEGACY_STATIONARY_WATER);
    ignoredBlocks.add(Material.LAVA);
    ignoredBlocks.add(Material.LEGACY_STATIONARY_LAVA);
    ignoredBlocks.add(Material.FLOWER_POT);
    ignoredBlocks.add(Material.SUGAR_CANE);
    ignoredBlocks.add(Material.CACTUS);
    ignoredBlocks.add(Material.LEGACY_SOIL);
    ignoredBlocks.add(Material.LEGACY_CROPS);
    ignoredBlocks.add(Material.WHEAT);
    ignoredBlocks.add(Material.POTATO);
    ignoredBlocks.add(Material.CARROT);
    ignoredBlocks.add(Material.BEETROOTS);
    ignoredBlocks.add(Material.PUMPKIN_STEM);
    ignoredBlocks.add(Material.MELON_STEM);
    ignoredBlocks.add(Material.FIRE);
    ignoredBlocks.add(Material.WALL_SIGN);
    ignoredBlocks.add(Material.SIGN);
    ignoredBlocks.add(Material.LEGACY_BANNER);
    ignoredBlocks.add(Material.LEGACY_STANDING_BANNER);
    ignoredBlocks.add(Material.LEGACY_WALL_BANNER);
    ignoredBlocks.add(Material.ITEM_FRAME);
    ignoredBlocks.add(Material.LEGACY_SKULL);
    ignoredBlocks.add(Material.TORCH);
    ignoredBlocks.add(Material.REDSTONE_TORCH);
    ignoredBlocks.add(Material.REDSTONE_WALL_TORCH);
    ignoredBlocks.add(Material.LEGACY_TRAP_DOOR);
    ignoredBlocks.add(Material.IRON_TRAPDOOR);
    ignoredBlocks.add(Material.IRON_BARS);
    ignoredBlocks.add(Material.LEGACY_FENCE);
    ignoredBlocks.add(Material.SPRUCE_FENCE);
    ignoredBlocks.add(Material.BIRCH_FENCE);
    ignoredBlocks.add(Material.JUNGLE_FENCE);
    ignoredBlocks.add(Material.ACACIA_FENCE);
    ignoredBlocks.add(Material.DARK_OAK_FENCE);
    ignoredBlocks.add(Material.LEGACY_FENCE_GATE);
    ignoredBlocks.add(Material.SPRUCE_FENCE_GATE);
    ignoredBlocks.add(Material.BIRCH_FENCE_GATE);
    ignoredBlocks.add(Material.JUNGLE_FENCE_GATE);
    ignoredBlocks.add(Material.ACACIA_FENCE_GATE);
    ignoredBlocks.add(Material.DARK_OAK_FENCE_GATE);

    List<BlockState> locations = new ArrayList<>();

    for (Block block : getInRadius(e.getEntity().getLocation().getBlock(), 2.5).keySet()) {
      if (ignoredBlocks.contains(block.getType())) {
        continue;
      }

      double random = Math.random();
      if (random > 0.85D) {
        continue;
      }

      if (block.getType() != Material.LEGACY_STAINED_CLAY) {
        locations.add(block.getState());
      }

      block.setType(Material.LEGACY_STAINED_CLAY);
    }

    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
        new BukkitRunnable() {
          public void run() {
            for (BlockState bs : locations) {
              Location loc = bs.getLocation();
              Block b = loc.getBlock();

              b.setType(bs.getType());
              //b.setData(bs.getData().getData());
            }
          }
        }, 80L);
  }



}
