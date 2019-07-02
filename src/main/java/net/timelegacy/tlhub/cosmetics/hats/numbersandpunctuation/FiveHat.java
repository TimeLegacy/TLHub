package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class FiveHat extends Hat {

  public FiveHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Five Hat");
    setDisplayName(getRarity().getColor() + "'5' Hat");
    setPermissionNode("hub.cosmetics.hats.five");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDI0NmFjNjc2MjBkM2I1MjE3YzQ5ZDljMzAxNzNhMzc5M2Q0ZDQxZjRmMjUxYzlmNjIzMmVlYzc1YTc0In19fQ==");
  }

}
