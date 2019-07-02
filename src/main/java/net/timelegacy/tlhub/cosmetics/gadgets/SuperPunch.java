package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.Arrays;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SuperPunch extends Gadget {

  public SuperPunch() {
    setRarity(Rarity.COMMON);
    setName("Super Punch");
    setDisplayName(getRarity().getColor() + "Super Punch");
    setLore(Arrays.asList("", "&7&oFALCON", "&7&oPUUUUUNNCH", ""));
    setPermissionNode("hub.cosmetics.gadgets.super_punch");
    setCooldown(5);

    setItem(ItemUtils.createItem(Material.SLIME_BALL, getDisplayName(), getLore(), getName()));
  }

  @Override
  public void doAbility(EntityDamageByEntityEvent event) {
    Player player = (Player) event.getDamager();
    Player target = (Player) event.getEntity();

    event.setCancelled(true);
    event.setDamage(0);

    target.teleport(target.getLocation().add(0, 0.5, 0));
    target.setVelocity(player.getLocation().getDirection().multiply(9));
  }

}
