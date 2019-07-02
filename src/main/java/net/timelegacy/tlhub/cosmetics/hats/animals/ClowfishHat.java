package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ClowfishHat extends Hat {

  public ClowfishHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Clownfish Hat");
    setDisplayName(getRarity().getColor() + "Clownfish Hat");
    setPermissionNode("hub.cosmetics.hats.clownfish");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTI1MTBiMzAxYjA4ODYzOGVjNWM4NzQ3ZTJkNzU0NDE4Y2I3NDdhNWNlNzAyMmM5YzcxMmVjYmRjNWY2ZjA2NSJ9fX0=");
  }

}
