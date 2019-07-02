package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class RHat extends Hat {

  public RHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("R Hat");
    setDisplayName(getRarity().getColor() + "'R' Hat");
    setPermissionNode("hub.cosmetics.hats.r");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFjYTRkNjk1ZTRlN2Y0N2ZhZDU4Y2YzNzFjMmMwZTIxM2ZiM2QxMDIzMjYxMWQ3M2QwNzUzNzRjODk4MCJ9fX0=");
  }

}
