package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SixHat extends Hat {

  public SixHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Six Hat");
    setDisplayName(getRarity().getColor() + "'6' Hat");
    setPermissionNode("hub.cosmetics.hats.six");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZiN2ViOTU3YmNhNjY3OGNkMGI2M2Q4NGVhN2JmMjhiZjY3ZWI4YWIzZjhmNjViZWI0NjFlMjM2ZjQyOWEifX19");
  }

}
