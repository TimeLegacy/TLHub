package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SlothHat extends Hat {

  public SlothHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Sloth Hat");
    setDisplayName(getRarity().getColor() + "Sloth Hat");
    setPermissionNode("hub.cosmetics.hats.sloth");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU1MTg0YWFhY2U5YjZhODM2NTE3Mzk4YTY4YjRiZmJlNjE0NDYwNWVjNGFkNTZjYjQ3YWRlZTdmYTg1OSJ9fX0=");
  }

}
