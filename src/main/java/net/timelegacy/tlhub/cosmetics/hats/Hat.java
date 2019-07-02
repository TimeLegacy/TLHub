package net.timelegacy.tlhub.cosmetics.hats;

import java.util.List;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;
import org.bukkit.inventory.ItemStack;

public class Hat {

  private Rarity rarity;
  private Category category;

  private ItemStack item;
  private String name;
  private String displayName;
  private List<String> lore;

  private String textureValue;

  private String permissionNode;

  public Hat() {

  }

  public Hat(Rarity rarity, Category category, ItemStack item, String name, String displayName, List<String> lore, String permissionNode, String textureValue) {
    this.category = category;
    this.rarity = rarity;
    this.item = item;
    this.name = name;
    this.displayName = displayName;
    this.lore = lore;
    this.permissionNode = permissionNode;
    this.textureValue = textureValue;
  }

  public Rarity getRarity() {
    return rarity;
  }

  public void setRarity(Rarity rarity) {
    this.rarity = rarity;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public ItemStack getItem() {
    return ItemUtils.createNMSSkullItem(ItemUtils.createSkullItem("player", displayName), textureValue, name);
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

  public String getTextureValue() {
    return textureValue;
  }

  public void setTextureValue(String textureValue) {
    this.textureValue = textureValue;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
