package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class NeptuneHat extends Hat {

  public NeptuneHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Neptune Hat");
    setDisplayName(getRarity().getColor() + "Neptune Hat");
    setPermissionNode("hub.cosmetics.hats.neptune");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdkNjZmOTM5MDlhNmQ0NjQxYzY1MzA4MmUwNDc0OTY5MWRlODJjZjc3MjMyYmQyMGFiMzJhZGY0ZiJ9fX0=");
  }

}
