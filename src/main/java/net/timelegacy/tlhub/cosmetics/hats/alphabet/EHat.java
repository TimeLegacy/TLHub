package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class EHat extends Hat {

  public EHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("E Hat");
    setDisplayName(getRarity().getColor() + "'E' Hat");
    setPermissionNode("hub.cosmetics.hats.e");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2Q2YmI4NTk5NjE3YTExYjRiZmMyYWE1NTc4NmVhNzM3ZWE0NDU4MzdiY2VhNzgyOTRlNWRjYTcxMzhhNjY3In19fQ==");
  }

}
