package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class HorseHat extends Hat {

  public HorseHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Horse Hat");
    setDisplayName(getRarity().getColor() + "Horse Hat");
    setPermissionNode("hub.cosmetics.hats.horse");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmU3OGM0NzYyNjc0ZGRlOGIxYTVhMWU4NzNiMzNmMjhlMTNlN2MxMDJiMTkzZjY4MzU0OWIzOGRjNzBlMCJ9fX0=");
  }

}
