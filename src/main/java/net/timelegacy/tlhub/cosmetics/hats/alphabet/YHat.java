package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class YHat extends Hat {

  public YHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("Y Hat");
    setDisplayName(getRarity().getColor() + "'Y' Hat");
    setPermissionNode("hub.cosmetics.hats.y");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTZlMmVmNDRhOWExYmY1MmViY2NiZTMxODNmOTllYmQxYmFmYmIyNGYyZDU1NWRmZThmYmQyYTMxMDQ5ODc0NSJ9fX0=");
  }

}
