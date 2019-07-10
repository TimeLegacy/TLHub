package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class RaccoonHat extends Hat {

  public RaccoonHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Raccoon Hat");
    setDisplayName(getRarity().getColor() + "Raccoon Hat");
    setPermissionNode("hub.cosmetics.hats.raccoon");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjJjNjRmMjUxNzM2Yzk5MmRmNDhjOGM0YjI4YjQyZWE0MTI1ZWUyOTVjOWY5YmRjZmUwNDliZWZkZWE0MmVlIn19fQ==");
  }

}
