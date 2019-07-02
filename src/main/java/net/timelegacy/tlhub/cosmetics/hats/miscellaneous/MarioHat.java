package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MarioHat extends Hat {

  public MarioHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Mario Hat");
    setDisplayName(getRarity().getColor() + "Mario Hat");
    setPermissionNode("hub.cosmetics.hats.mario");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTBjMjU0OWE4OTM3MjY5ODhmMzQyOGJlZjc5OTg3NWJhODcxNjg4YWU2NGViMGNmZGM0M2Y3ZDZlMjRjNmMifX19");
  }

}
