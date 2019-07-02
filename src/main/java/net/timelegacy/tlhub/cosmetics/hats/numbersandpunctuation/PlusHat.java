package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PlusHat extends Hat {

  public PlusHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Plus Hat");
    setDisplayName(getRarity().getColor() + "'+' Hat");
    setPermissionNode("hub.cosmetics.hats.plus");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTIyYTJhNTExY2IyOWRlZmJlNzg1YjhjMjI2NTRmNDZmYzgyNWJhMjUyODZjM2U4OGIzZDg2YjE1YzljIn19fQ==");
  }

}
