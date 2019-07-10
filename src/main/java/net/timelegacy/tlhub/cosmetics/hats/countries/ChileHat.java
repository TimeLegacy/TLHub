package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ChileHat extends Hat {

  public ChileHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Chile Hat");
    setDisplayName(getRarity().getColor() + "Chile Hat");
    setPermissionNode("hub.cosmetics.hats.chile");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWQxZGRkYzY2NTYxNGM5ZjY0ODdiYTljNjY2ZGE3NTc5NTYxNTg5YTQ5NGVmNzQ0YWFmOGY0Zjg4YTE2In19fQ==");
  }

}
