package net.timelegacy.tlhub.cosmetics.particles;

import java.util.List;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.inventory.ItemStack;

public class Particle {

  private Rarity rarity;

  private ItemStack item;
  private String name;
  private String displayName;
  private List<String> lore;

  private String permissionNode;

  public Particle() {

  }

  public Particle(Rarity rarity, ItemStack item, String name, String displayName, List<String> lore, String permissionNode) {
    this.rarity = rarity;
    this.item = item;
    this.name = name;
    this.displayName = displayName;
    this.lore = lore;
    this.permissionNode = permissionNode;
  }

  public void registerRunnable() {

  }

  public Rarity getRarity() {
    return rarity;
  }

  public void setRarity(Rarity rarity) {
    this.rarity = rarity;
  }

  public ItemStack getItem() {
    return item;
  }

  public void setItem(ItemStack item) {
    this.item = item;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
