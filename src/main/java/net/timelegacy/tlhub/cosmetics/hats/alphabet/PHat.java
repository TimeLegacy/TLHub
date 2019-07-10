package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PHat extends Hat {

  public PHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("P Hat");
    setDisplayName(getRarity().getColor() + "'P' Hat");
    setPermissionNode("hub.cosmetics.hats.p");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ1YjJlZGQ5ZWM2OWEzNTBhODY3ZGIwZTViMGI4NzU1MWFmZjQ5OGE4OGUwMWUyYmQ2YTAzNmZmNGQzOSJ9fX0=");
  }

}
