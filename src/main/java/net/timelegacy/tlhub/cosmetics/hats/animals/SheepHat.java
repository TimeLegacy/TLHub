package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SheepHat extends Hat {

  public SheepHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Sheep Hat");
    setDisplayName(getRarity().getColor() + "Sheep Hat");
    setPermissionNode("hub.cosmetics.hats.sheep");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjMxZjljY2M2YjNlMzJlY2YxM2I4YTExYWMyOWNkMzNkMThjOTVmYzczZGI4YTY2YzVkNjU3Y2NiOGJlNzAifX19");
  }

}
