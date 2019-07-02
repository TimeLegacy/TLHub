package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class JHat extends Hat {

  public JHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("J Hat");
    setDisplayName(getRarity().getColor() + "'J' Hat");
    setPermissionNode("hub.cosmetics.hats.j");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjgxZDJjMWE1YTU5YjU3NTM1OTQ4MmE4YTMzODU0Y2QzYjE2MzRkZDU0YzQ1YzRjYTFjYTEwZTg2MDdkNDcifX19");
  }

}
