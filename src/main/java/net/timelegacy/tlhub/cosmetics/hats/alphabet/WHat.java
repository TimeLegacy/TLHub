package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class WHat extends Hat {

  public WHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("W Hat");
    setDisplayName(getRarity().getColor() + "'W' Hat");
    setPermissionNode("hub.cosmetics.hats.w");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmY5NGNmYzdiZjQ5ZTQ3YjQ0OGNjZDVmOGQ2ZGZjZjQwNzBlZTQ0ZTczYzQ4ZDRiNDI0Y2YxYTJkMzE0NSJ9fX0=");
  }

}
