package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PartyPopper implements Listener {

  private static TLHub plugin = TLHub.getPlugin();

  @EventHandler
  public void gadgetUse(PlayerInteractEvent event) {
    Player p = event.getPlayer();

    String gadgetName = "PARTY_POPPER";

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

          new BukkitRunnable() {
            int i = 0;

            @Override
            public void run() {
              i++;

              List<Particle> particleList = new ArrayList<>();
              particleList.add(Particle.FIREWORKS_SPARK);
              particleList.add(Particle.FLAME);
              particleList.add(Particle.SMOKE_LARGE);
              particleList.add(Particle.CRIT);
              particleList.add(Particle.VILLAGER_ANGRY);
              particleList.add(Particle.TOTEM);

              p.getWorld().playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 1);
              p
                  .getWorld()
                  .spawnParticle(
                      particleList.get(new Random().nextInt(6)),
                      p.getLocation().getX(),
                      p.getLocation().getY(),
                      p.getLocation().getZ(),
                      15,
                      1D,
                      1D,
                      1D,
                      0.1D);

              if (i >= 2) {
                p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation(), 1);
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * 5, 1));
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
                cancel();
              }
            }
          }.runTaskTimer(plugin, 0, getRandom());

          new Cooldown(
              p.getUniqueId(),
              gadgetName,
              5)
              .start();
        }
      }
    }
  }

  @EventHandler
  private void onIgnite(BlockIgniteEvent e) {
    if (e.getCause() == IgniteCause.FIREBALL) {
      e.setCancelled(true);
    }
  }

  private int getRandom() {
    int min = 5;
    int max = 15;

    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }


}
