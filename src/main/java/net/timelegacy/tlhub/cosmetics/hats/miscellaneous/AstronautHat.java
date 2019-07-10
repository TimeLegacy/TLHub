package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class AstronautHat extends Hat {

  public AstronautHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Astronaut Hat");
    setDisplayName(getRarity().getColor() + "Astronaut Hat");
    setPermissionNode("hub.cosmetics.hats.astronaut");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTRmNTNmM2Q5OTZlYjYzMDNhYmM5OGI0MmY0YWYwZTdmOTQ1OWM4MGE4ODZkMWM2YWFjMjVlOGFiMDMzZjM3NiJ9fX0=");
  }

}
