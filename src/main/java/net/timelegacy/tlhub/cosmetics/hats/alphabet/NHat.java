package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class NHat extends Hat {

  public NHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("N Hat");
    setDisplayName(getRarity().getColor() + "'N' Hat");
    setPermissionNode("hub.cosmetics.hats.n");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjBhMGI4M2JlOGM5ODFjYzljODdmM2Y5Y2FlNDU1ZGUzYTdiMTY4NGIwY2M1ZTUwN2IyMzdlMDQzODYxNCJ9fX0=");
  }

}
