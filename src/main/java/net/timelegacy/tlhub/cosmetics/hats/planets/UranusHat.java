package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class UranusHat extends Hat {

  public UranusHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Uranus Hat");
    setDisplayName(getRarity().getColor() + "Uranus Hat");
    setPermissionNode("hub.cosmetics.hats.uranus");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWE2ZGQ3NWY0MWU0MjY4ZTBhMTI2OTA1MDkwN2FhNjc0NmZmZDM3YTRhOTI5ZTczMjUyNDY0MmMzMzZiYyJ9fX0=");
  }

}
