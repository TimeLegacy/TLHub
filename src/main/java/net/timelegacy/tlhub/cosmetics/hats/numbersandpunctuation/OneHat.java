package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class OneHat extends Hat {

  public OneHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("One Hat");
    setDisplayName(getRarity().getColor() + "'1' Hat");
    setPermissionNode("hub.cosmetics.hats.one");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDgzN2E2ZDIyMjAxM2RiNGYxM2JkOTA0OWIxZDZlZjE1OTI1MDhkZGE3MDU3NDIwYjk1NDcyNjM3NWFkZTEifX19");
  }

}
