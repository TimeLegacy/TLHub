package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class FerretHat extends Hat {

  public FerretHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Ferret Hat");
    setDisplayName(getRarity().getColor() + "Ferret Hat");
    setPermissionNode("hub.cosmetics.hats.ferret");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjM2ZWRmN2RlOWFkY2E3MjMwOGE5NGQxYzM4YzM1OGFjYzgyOTE4ZmU4ZmNlZDI1ZDQ3NDgyMGY0Y2I3ODQifX19");
  }

}
