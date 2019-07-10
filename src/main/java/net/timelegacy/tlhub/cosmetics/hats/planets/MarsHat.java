package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MarsHat extends Hat {

  public MarsHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Mars Hat");
    setDisplayName(getRarity().getColor() + "Mars Hat");
    setPermissionNode("hub.cosmetics.hats.mars");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzc3ZDYxNmJjNDRhYzliMzczMGZlZDQ3ZjI5YTM3OGY4OGExNjcyOGM2NzA0OGMxYTM4N2QyMjllMWNiYSJ9fX0=");
  }

}
