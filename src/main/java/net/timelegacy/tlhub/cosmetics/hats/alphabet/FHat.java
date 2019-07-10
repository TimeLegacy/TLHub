package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class FHat extends Hat {

  public FHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("F Hat");
    setDisplayName(getRarity().getColor() + "'F' Hat");
    setPermissionNode("hub.cosmetics.hats.f");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTk1OTJjYWQ5MjRkNzBhMWY0YWYyNzM4ZDQ5MjJlMWFiZGM0ODdkZmY2OGMwNzI3ZDM3ZWQ5YjJhYjY0MDcxIn19fQ==");
  }

}
