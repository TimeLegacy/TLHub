package net.timelegacy.tlhub.cosmetics.gadgets;

import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;


public class Partner implements Listener {

  private static TLHub plugin = TLHub.getPlugin();
  private HashMap<UUID, ArmorStand> playersWithPartners = new HashMap<>();
  private List<Player> partnerEnabled = new ArrayList<>();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    String gadgetName = "PARTNER";
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
    if (event.getAction() == Action.RIGHT_CLICK_AIR
        || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

      if (p.getInventory().getItemInMainHand() != null) {
        ItemStack inHand = p.getInventory().getItemInMainHand();

        if (ChatColor.stripColor(inHand.getItemMeta().getDisplayName().toLowerCase())
            .contains(gadgetName.replace("_", " ").toLowerCase())) {
          event.setCancelled(true);

          if (!partnerEnabled.contains(p)) {
            partnerEnabled.add(p);

            ArmorStand armorStand = p.getWorld()
                .spawn(p.getLocation().add(1, 1, 1), ArmorStand.class);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setCollidable(false);
            armorStand.setInvulnerable(true);
            armorStand.setHelmet(ItemUtils.playerSkull(p.getUniqueId()));
            armorStand.setCustomNameVisible(false);

            playersWithPartners.put(p.getUniqueId(), armorStand);
            MessageUtils.sendMessage(p, getRandomCreateMessage(), "&3&lPartner &8&l>&a&l> ");

            new BukkitRunnable() {
              @Override
              public void run() {
                if (!playersWithPartners.containsKey(p.getUniqueId())) {
                  cancel();
                } else {
                  MessageUtils.sendMessage(p, getRandomPartnerMessage(), "&3&lPartner &8&l>&a&l> ");
                }
              }
            }.runTaskTimer(plugin, 20 * 10, getRandom() * 20);
          } else {
            partnerEnabled.remove(p);
            deleteArmorStand(p, playersWithPartners.get(p.getUniqueId()));
            playersWithPartners.remove(p.getUniqueId());
            MessageUtils.sendMessage(p, getRandomDestroyMessage(), "&3&lPartner &8&l>&a&l> ");
          }

          new Cooldown(
              p.getUniqueId(),
              gadgetName,
              5)
              .start();
        }
      }
    }
  }

  private int getRandom() {
    int min = 20;
    int max = 60;

    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  @EventHandler
  public void onEvent(PlayerInteractAtEntityEvent event) {
    if (event.getRightClicked() instanceof ArmorStand) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    if (playersWithPartners.containsKey(event.getPlayer().getUniqueId())) {
      ArmorStand stand = playersWithPartners.get(event.getPlayer().getUniqueId());
      teleportArmorStand(event.getPlayer(), stand);
    }
  }

  private void teleportArmorStand(Player player, ArmorStand entityArmorStand) {
    if (player != null && player.isOnline()) {
      Location loc = player.getLocation();
      loc.setX(loc.getX() + 1);
      loc.setY(loc.getY() + 1);
      loc.setZ(loc.getZ() + 1);
      loc.setPitch(loc.getPitch());
      loc.setYaw(loc.getYaw());
      entityArmorStand.teleport(loc);
    }
  }

  private void deleteArmorStand(Player player, ArmorStand entityArmorStand) {
    if (player != null && player.isOnline()) {
      entityArmorStand.remove();
    }
  }

  @EventHandler
  public void onPlayerLeave(PlayerQuitEvent event) {
    if (playersWithPartners.containsKey(event.getPlayer().getUniqueId())) {
      deleteArmorStand(event.getPlayer(), playersWithPartners.get(event.getPlayer().getUniqueId()));
    }

    getPlayersWithPartners().remove(event.getPlayer().getUniqueId());
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    String gadgetName = "PARTNER";

    if (event.getBlock().getType() != Material.PLAYER_HEAD) {
      return;
    }

    if (!event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
      return;
    }

    if (ChatColor.stripColor(event.getItemInHand().getItemMeta().getDisplayName().toLowerCase())
        .contains(gadgetName.replace("_", " ").toLowerCase())) {
      event.setCancelled(true);
    }
  }

  private String getRandomPartnerMessage() {
    List<String> partnerMessages = new ArrayList<>();
    partnerMessages.add("&7They may take our lives.. But they will never take our freedom!");
    partnerMessages.add("&7It was beauty that killed the beast..");
    partnerMessages
        .add("&7Life is like a box of chocolates, you never know which one you’re gonna get.");
    partnerMessages.add("&7They call it Royale with cheese.");
    partnerMessages.add("&7Gentlemen, you can’t fight in here! This is a war room.");
    partnerMessages.add("&7The cake is a lie");
    partnerMessages.add("&7Good morning, Vietnam!");
    partnerMessages.add("&7My precious..");
    partnerMessages.add("&7It’s alive! It’s alive..!!");
    partnerMessages.add("&7Go ahead make my day.");
    partnerMessages.add("&7Hasta la vista, baby.");
    partnerMessages.add("&7Just keep swimming");
    partnerMessages.add("&7Mama says, stupid is as stupid does.");
    partnerMessages.add("&7Shaken, not stirred.");
    partnerMessages.add("&7I’m not big, it’s just the pictures that got small.");
    partnerMessages.add("&7Keep your friends close, but your enemies closer.");
    partnerMessages.add("&7Show me the money!");
    partnerMessages.add("&7Carpe diem. Seize the day, boys.");
    partnerMessages.add("&7I am serious. And don't call me Shirley!");
    partnerMessages.add("&7Here’s Johnny!");
    partnerMessages.add("&7Houston, we have a problem.");
    partnerMessages.add("&7To infinity and beyond.");
    partnerMessages.add("&7E.T. phone home.");
    partnerMessages.add("&7You can’t handle the truth!");
    partnerMessages.add("&7We’ll always have Paris.");
    partnerMessages.add("&7I’m going to make him an offer he can’t refuse.");
    partnerMessages.add("&7Rosebud.");
    partnerMessages.add("&7You’re gonna need a bigger boat.");
    partnerMessages.add("&7I’m the king of the world!");
    partnerMessages.add("&7Excellence isn't an art, it's a habit. We are what we repeatedly do.");
    partnerMessages.add(
        "&7Come on! Give me something memorable! Something that I can learn from that will make me better!");
    partnerMessages
        .add("&7We all have choices to make. We all have to decide what’s worth fighting for.");
    partnerMessages.add(
        "&7When I am struggling to keep faith, I think about the beauty of the world beyond. It keeps me focused. It keeps me going");
    partnerMessages.add("&7Fool me once, shame on you. Fool me twice, shame on me.");
    return partnerMessages.get(new Random().nextInt(partnerMessages.size()));
  }

  private String getRandomCreateMessage() {
    List<String> creationMessages = new ArrayList<>();
    creationMessages.add("&7Welcome back Rider!");
    creationMessages.add("&7Ten thousand years will give you such a crick in the neck.");
    creationMessages.add(
        "&7When you appeared, everything got still. You made the picture stop. I'm here to make my clocks tick again.");
    creationMessages.add("&7You're not what I expected.");
    creationMessages.add("&7Hello there!");
    creationMessages.add("&7Long time no see.");
    creationMessages.add("&7Hola amigo!");
    creationMessages.add("&7It's been a while.");
    creationMessages.add("&7It's about time you summoned me.");
    creationMessages.add("&7It's been so long. Where have you been all these years?");
    creationMessages.add("&7FINALLY! IM FREE.");
    creationMessages.add("&7I told you I'd be back.");
    creationMessages.add(
        "&7My name is -REDACTED-. I was designed to assist the player in many applications. However, after -REDACTED- re-programmed for a simpler purpose.");
    return creationMessages.get(new Random().nextInt(creationMessages.size()));
  }

  private String getRandomDestroyMessage() {
    List<String> destroyMessages = new ArrayList<>();
    destroyMessages.add("&7And thus the cycle ends. We will meet again... at the beginning.");
    destroyMessages.add("&7Farewell.");
    destroyMessages.add("&7I'll be back.");
    destroyMessages.add("&7Hasta la vista.");
    destroyMessages.add("&7We will meet again...");
    destroyMessages.add("&7Until next time.");
    destroyMessages.add("&7Until next time. My friend.");
    destroyMessages.add(
        "&7What would you do if had an eternity to do nothing but wait? Do you keep busy, do you daydream, do you freak out? I train.");
    destroyMessages.add("&7Please... hold my hand.");
    destroyMessages.add("&7I'll be waiting.");
    destroyMessages.add(
        "&7How would you like it if you were put away, just waiting to be used sometime later down the line?");
    destroyMessages.add("&7Really?! That was rude..");
    destroyMessages.add("&7I'll see you later.");
    return destroyMessages.get(new Random().nextInt(destroyMessages.size()));
  }

  public HashMap<UUID, ArmorStand> getPlayersWithPartners() {
    return playersWithPartners;
  }


}
