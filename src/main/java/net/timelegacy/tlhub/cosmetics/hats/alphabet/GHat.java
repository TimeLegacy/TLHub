package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class GHat extends Hat {

  public GHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("G Hat");
    setDisplayName(getRarity().getColor() + "'G' Hat");
    setPermissionNode("hub.cosmetics.hats.g");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTFiZmVlODAxMGM2ODBhOTYxYmM4M2EyNWE1NGE1ODY1YjI0NGI2ZDFjYjdkYzc1YjYyMTlhOTM1NTUyOTYifX19");
  }

}
