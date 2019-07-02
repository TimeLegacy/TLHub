package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ZeroHat extends Hat {

  public ZeroHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Zero Hat");
    setDisplayName(getRarity().getColor() + "'0' Hat");
    setPermissionNode("hub.cosmetics.hats.zero");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjA0ZmE1ZWNiY2M4NDM4MDc5NzcyMjFhMWJiNGI1MjNhMjNjZjUxODA5MGYyYTY4MmFmNTJkMzNlOWIwNjQifX19");
  }

}
