package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SaturnHat extends Hat {

  public SaturnHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Saturn Hat");
    setDisplayName(getRarity().getColor() + "Saturn Hat");
    setPermissionNode("hub.cosmetics.hats.saturn");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjY1Y2QzYTI0ZjE5MzM3MWVlYmFjOWE3MWM0OGY0MDhhOTM1YWZjNGI0MzVmMWZiN2I5ODQzZTY1ODcyOThmIn19fQ==");
  }

}
