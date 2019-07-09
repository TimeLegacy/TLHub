package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PaintballGun extends Gadget implements Listener {

  private final TLHub plugin;

  private List<Location> activeBlocks = new ArrayList<>();

  public PaintballGun(TLHub plugin) {
    this.plugin = plugin;

    setRarity(Rarity.COMMON);
    setName("Paintball Gun");
    setDisplayName(getRarity().getColor() + "Paintball Gun");
    setLore(Arrays.asList("", "&7&oThe world was meant to be painted.", "&7&oHow will you design it?", ""));
    setPermissionNode("hub.cosmetics.gadgets.paintball_gun");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.DIAMOND_HORSE_ARMOR, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(PlayerInteractEvent event) {
    Player player = event.getPlayer();

    Snowball snowball = player.launchProjectile(Snowball.class);
    snowball.setMetadata("paintball", new FixedMetadataValue(plugin, "Paintball"));

    player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1F, 2F);

    new Cooldown(player.getUniqueId(), plugin.getName() + getName() + "Cooldown", getCooldown()).start();
  }

  @Override
  public void registerExtraListeners() {
    Bukkit.getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onPaintballHit(ProjectileHitEvent event) {
    if (!(event.getEntity() instanceof Snowball)) {
      return;
    }

    if (!event.getEntity().hasMetadata("paintball")) {
      return;
    }

    List<Material> ignoredBlocks = new ArrayList<>();
    ignoredBlocks.add(Material.AIR);
    ignoredBlocks.add(Material.BARRIER);
    ignoredBlocks.add(Material.WATER);
    ignoredBlocks.add(Material.LAVA);

    // Portals
    ignoredBlocks.add(Material.NETHER_PORTAL);
    ignoredBlocks.add(Material.END_PORTAL);

    ignoredBlocks.add(Material.LADDER);
    ignoredBlocks.add(Material.RAIL);

    // Buttons
    ignoredBlocks.add(Material.OAK_BUTTON);
    ignoredBlocks.add(Material.SPRUCE_BUTTON);
    ignoredBlocks.add(Material.BIRCH_BUTTON);
    ignoredBlocks.add(Material.JUNGLE_BUTTON);
    ignoredBlocks.add(Material.DARK_OAK_BUTTON);
    ignoredBlocks.add(Material.ACACIA_BUTTON);

    // Pressure Plates
    ignoredBlocks.add(Material.OAK_PRESSURE_PLATE);
    ignoredBlocks.add(Material.SPRUCE_PRESSURE_PLATE);
    ignoredBlocks.add(Material.BIRCH_PRESSURE_PLATE);
    ignoredBlocks.add(Material.JUNGLE_PRESSURE_PLATE);
    ignoredBlocks.add(Material.DARK_OAK_PRESSURE_PLATE);
    ignoredBlocks.add(Material.ACACIA_PRESSURE_PLATE);
    ignoredBlocks.add(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
    ignoredBlocks.add(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);

    // Carpets
    ignoredBlocks.add(Material.RED_CARPET);
    ignoredBlocks.add(Material.ORANGE_CARPET);
    ignoredBlocks.add(Material.YELLOW_CARPET);
    ignoredBlocks.add(Material.LIME_CARPET);
    ignoredBlocks.add(Material.GREEN_CARPET);
    ignoredBlocks.add(Material.LIGHT_BLUE_CARPET);
    ignoredBlocks.add(Material.CYAN_CARPET);
    ignoredBlocks.add(Material.BLUE_CARPET);
    ignoredBlocks.add(Material.PINK_CARPET);
    ignoredBlocks.add(Material.MAGENTA_CARPET);
    ignoredBlocks.add(Material.PURPLE_CARPET);
    ignoredBlocks.add(Material.BROWN_CARPET);
    ignoredBlocks.add(Material.WHITE_CARPET);
    ignoredBlocks.add(Material.LIGHT_GRAY_CARPET);
    ignoredBlocks.add(Material.GRAY_CARPET);
    ignoredBlocks.add(Material.BLACK_CARPET);

    ignoredBlocks.add(Material.WALL_SIGN);
    ignoredBlocks.add(Material.SIGN);
    ignoredBlocks.add(Material.ITEM_FRAME);

    // Stairs
    ignoredBlocks.add(Material.COBBLESTONE_STAIRS);
    ignoredBlocks.add(Material.SANDSTONE_STAIRS);
    ignoredBlocks.add(Material.BRICK_STAIRS);

    // Slabs
    ignoredBlocks.add(Material.STONE_SLAB);
    ignoredBlocks.add(Material.STONE_BRICK_SLAB);
    ignoredBlocks.add(Material.BRICK_SLAB);

    // Foliage
    ignoredBlocks.add(Material.ROSE_BUSH);
    ignoredBlocks.add(Material.DANDELION);
    ignoredBlocks.add(Material.ALLIUM);
    ignoredBlocks.add(Material.LILAC);
    ignoredBlocks.add(Material.WHITE_TULIP);
    ignoredBlocks.add(Material.RED_TULIP);
    ignoredBlocks.add(Material.ORANGE_TULIP);
    ignoredBlocks.add(Material.PINK_TULIP);
    ignoredBlocks.add(Material.OXEYE_DAISY);
    ignoredBlocks.add(Material.AZURE_BLUET);

    List<BlockState> blockStates = new ArrayList<>();

    for (Block block : getInRadius(event.getEntity().getLocation().getBlock(), 2.5).keySet()) {
      if (ignoredBlocks.contains(block.getType())) {
        continue;
      }

      if (activeBlocks.contains(block.getLocation())) {
        continue;
      }

      double random = Math.random();
      if (random > 0.85D) {
        continue;
      }

      blockStates.add(block.getState());

      block.setType(Material.TERRACOTTA);
      activeBlocks.add(block.getLocation());
    }

    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
      for (BlockState blockState : blockStates) {
        blockState.update(true);
        activeBlocks.remove(blockState.getLocation());
      }
    }, 80L);
  }

  private static HashMap<Block, Double> getInRadius(Block block, double dR) {
    HashMap<Block, Double> blockList = new HashMap<>();
    int iR = (int) dR + 1;

    for (int x = -iR; x <= iR; x++) {
      for (int z = -iR; z <= iR; z++) {
        for (int y = -iR; y <= iR; y++) {
          Block curBlock = block.getRelative(x, y, z);

          double offset = block.getLocation().toVector().subtract(curBlock.getLocation().toVector()).length();

          if (offset <= dR) {
            blockList.put(curBlock, 1.0D - offset / dR);
          }
        }
      }
    }

    return blockList;
  }

}
