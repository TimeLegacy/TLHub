package net.timelegacy.tlhub.crates;

import org.bukkit.inventory.ItemStack;

public class Prize {

  private String prizePermission;
  private String prizeType;
  private String prizeRarity;
  private ItemStack itemStack;

  Prize(ItemStack itemStack, String permission, String type, String rarity) {
    this.itemStack = itemStack;
    this.prizePermission = permission;
    this.prizeType = type;
    this.prizeRarity = rarity;
  }

  public String getPrizePermission() {
    return prizePermission;
  }

  public String getPrizeType() {
    return prizeType;
  }

  public String getPrizeRarity() {
    return prizeRarity;
  }

  public ItemStack getItemStack() {
    return itemStack;
  }
}