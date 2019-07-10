package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class DuckHat extends Hat {

  public DuckHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Duck Hat");
    setDisplayName(getRarity().getColor() + "Duck Hat");
    setPermissionNode("hub.cosmetics.hats.duck");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQ5YTZlMjA5NWViNDEyYWM3MzRlMTZhMTBiZDJlZjI3NjZmYjA2YTIzYWIyNzdjZmI5MDc0YmNkMDI1YWViMCJ9fX0=");
  }

}
