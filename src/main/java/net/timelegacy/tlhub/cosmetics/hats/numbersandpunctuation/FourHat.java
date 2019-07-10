package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class FourHat extends Hat {

  public FourHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Four Hat");
    setDisplayName(getRarity().getColor() + "'4' Hat");
    setPermissionNode("hub.cosmetics.hats.four");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjliYTgwMjliMjgyNTRiNmFlZjUzOTczMzMxMzhmYTVkMGFiYmY0YzdkZWE5ZTY2N2RhZWQ4NTg3M2Y0NSJ9fX0=");
  }

}
