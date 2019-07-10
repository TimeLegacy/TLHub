package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ThreeHat extends Hat {

  public ThreeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Three Hat");
    setDisplayName(getRarity().getColor() + "'3' Hat");
    setPermissionNode("hub.cosmetics.hats.three");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmY3ZDMxMzgzYTgwODM4ZDc5YTg3NDVhNDk1ZDFmNjdkMzc2NmEyNjIyY2I1ZjNkYjRhYzM5OTJmN2Y0MTUifX19");
  }

}
