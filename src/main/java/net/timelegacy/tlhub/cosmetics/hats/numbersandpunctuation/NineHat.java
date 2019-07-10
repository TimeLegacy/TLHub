package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class NineHat extends Hat {

  public NineHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Nine Hat");
    setDisplayName(getRarity().getColor() + "'9' Hat");
    setPermissionNode("hub.cosmetics.hats.nine");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzZkNjE2MWM2ZjA0ZGVmNjQ4MWUwM2I0YzI5NzI3OTg4MTZkZGM1MTRhZWY0YjExYzJkN2E1YThmYzlmZSJ9fX0=");
  }

}
