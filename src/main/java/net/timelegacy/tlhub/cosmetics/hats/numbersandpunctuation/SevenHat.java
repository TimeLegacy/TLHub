package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SevenHat extends Hat {

  public SevenHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Seven Hat");
    setDisplayName(getRarity().getColor() + "'7' Hat");
    setPermissionNode("hub.cosmetics.hats.seven");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQ4NzgyODg3NDM0MTIxYTdjZmZkNTQzZDgyNzI4MmY3MzcyODg1MWM0ZTMxMzdkYzM2MzdmODJiMzczYSJ9fX0=");
  }

}
