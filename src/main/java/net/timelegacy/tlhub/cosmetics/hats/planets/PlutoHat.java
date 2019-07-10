package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PlutoHat extends Hat {

  public PlutoHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Pluto Hat");
    setDisplayName(getRarity().getColor() + "Pluto Hat");
    setPermissionNode("hub.cosmetics.hats.pluto");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjgxNzlhZjE4YjE2OWY2ODQzYTZkNzE3Y2M4MzkzNDNlYzEwMjExNzY3NWJiZGQxM2Y3ZjIxNTNmNDRlOTRhIn19fQ==");
  }

}
