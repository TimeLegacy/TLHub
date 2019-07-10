package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class IHat extends Hat {

  public IHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("I Hat");
    setDisplayName(getRarity().getColor() + "'I' Hat");
    setPermissionNode("hub.cosmetics.hats.i");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM3Y2EwZDZkNTZmYjNmMzllN2RhMWMwMTVkZDM5ZjFkZGZjNDU3MjI2OTdlNzhmOGExYTYyZWIyYjFmZiJ9fX0=");
  }

}
