package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class EightHat extends Hat {

  public EightHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Eight Hat");
    setDisplayName(getRarity().getColor() + "'8' Hat");
    setPermissionNode("hub.cosmetics.hats.eight");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmJmOWEyZTcxNjkyYWE4NWQwNjRiYWYwNjIyN2ZjMWU1OTMxYTY4MjdmM2E2ZjdiN2UzOGMyNzlmNWU3NTA4NCJ9fX0=");
  }

}
