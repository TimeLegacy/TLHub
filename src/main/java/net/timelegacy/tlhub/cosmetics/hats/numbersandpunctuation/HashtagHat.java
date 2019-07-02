package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class HashtagHat extends Hat {

  public HashtagHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Hashtag Hat");
    setDisplayName(getRarity().getColor() + "'#' Hat");
    setPermissionNode("hub.cosmetics.hats.hashtag");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IyYzA2ZTM4ODIzN2VmYTE0MjQ2NDIzNjUzZWYxMjlmNmJkYjdkOGQ5OGRhYTE0MGQzNTk1YmNlZWJlNCJ9fX0=");
  }

}
