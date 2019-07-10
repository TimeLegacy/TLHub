package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ZHat extends Hat {

  public ZHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("Z Hat");
    setDisplayName(getRarity().getColor() + "'Z' Hat");
    setPermissionNode("hub.cosmetics.hats.z");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTBhZGY1YzI5NzQzM2ZmMWZlMTIyMTUyMWQ5ZWE2MjE5MTYzMjcwNzI2ZDg4MTk0Mzg4MjI0NzI5MzMyMyJ9fX0=");
  }

}
