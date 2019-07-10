package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class EarthHat extends Hat {

  public EarthHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Earth Hat");
    setDisplayName(getRarity().getColor() + "Earth Hat");
    setPermissionNode("hub.cosmetics.hats.earth");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTFiMzE4OGZkNDQ5MDJmNzI2MDJiZDdjMjE0MWY1YTcwNjczYTQxMWFkYjNkODE4NjJjNjllNTM2MTY2YiJ9fX0=");
  }

}
