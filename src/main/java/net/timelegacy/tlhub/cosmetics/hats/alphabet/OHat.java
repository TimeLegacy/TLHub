package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class OHat extends Hat {

  public OHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("O Hat");
    setDisplayName(getRarity().getColor() + "'O' Hat");
    setPermissionNode("hub.cosmetics.hats.o");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZmMzYzY2I5ZjIwYjNlNDgxMDkzMmMzM2I3MTVlZjk3YzFjYzdkZjYxYzgzODcxOWI1ZjcyMjAxMzgxZTgifX19");
  }

}
