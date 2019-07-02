package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class TwoHat extends Hat {

  public TwoHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Two Hat");
    setDisplayName(getRarity().getColor() + "'2' Hat");
    setPermissionNode("hub.cosmetics.hats.two");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM3YjlkMWQyNzVlM2UxZTZmMmFkYmU1YTc4Mzg5ZDI2ZWZlZDBiYzJmZGFlYmMyNzUzOGExMTJhNGFjYzc3In19fQ==");
  }

}
