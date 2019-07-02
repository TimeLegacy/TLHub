package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class JupiterHat extends Hat {

  public JupiterHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Jupiter Hat");
    setDisplayName(getRarity().getColor() + "Jupiter Hat");
    setPermissionNode("hub.cosmetics.hats.jupiter");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjhhYWE4YTM1NjFlODBlZjFmOTU2MWYxNzIxMWU3NzBkZTE4YTlmOThjMjY5MWVjZjlkNjk2NTU5YTFiOTE4YyJ9fX0=");
  }

}
