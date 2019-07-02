package net.timelegacy.tlhub.cosmetics.gadgets;

import java.util.List;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Gadget {

  private Rarity rarity;

  private ItemStack item;
  private String name;
  private String displayName;
  private List<String> lore;

  private String permissionNode;
  private int cooldown;

  public Gadget() {

  }

  public Gadget(Rarity rarity, ItemStack item, String name, String displayName, List<String> lore, int cooldown, String permissionNode) {
    this.rarity = rarity;
    this.item = item;
    this.name = name;
    this.displayName = displayName;
    this.lore = lore;
    this.cooldown = cooldown;
    this.permissionNode = permissionNode;
  }


  public void doAbility(PlayerInteractEvent event) {

  }

  public void doAbility(EntityDamageByEntityEvent event) {

  }

  public void doAbility(PlayerInteractEntityEvent event) {

  }

  public void registerExtraListeners() {

  }

  public ItemStack getItem() {
    return item;
  }

  public void setItem(ItemStack item) {
    this.item = item;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public List<String> getLore() {
    return lore;
  }

  public void setLore(List<String> lore) {
    this.lore = lore;
  }

  public String getPermissionNode() {
    return permissionNode;
  }

  public void setPermissionNode(String permissionNode) {
    this.permissionNode = permissionNode;
  }

  public int getCooldown() {
    return cooldown;
  }

  public void setCooldown(int cooldown) {
    this.cooldown = cooldown;
  }

  public Rarity getRarity() {
    return rarity;
  }

  public void setRarity(Rarity rarity) {
    this.rarity = rarity;
  }
}
