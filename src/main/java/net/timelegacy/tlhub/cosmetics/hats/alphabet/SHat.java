package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SHat extends Hat {

  public SHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("S Hat");
    setDisplayName(getRarity().getColor() + "'S' Hat");
    setPermissionNode("hub.cosmetics.hats.s");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjk0NmFmMzg4YTQxYTEzNDI1ZDFmODJkYTliZDEyYjZmOTY1YmM3MGE5YjNmODRlNDVkNjBkNjE3MzFjZDY4In19fQ==");
  }

}
