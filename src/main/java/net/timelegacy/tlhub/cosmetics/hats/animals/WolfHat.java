package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class WolfHat extends Hat {

  public WolfHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Wolf Hat");
    setDisplayName(getRarity().getColor() + "Wolf Hat");
    setPermissionNode("hub.cosmetics.hats.wolf");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGMzZGQ5ODRiYjY1OTg0OWJkNTI5OTQwNDY5NjRjMjI3MjVmNzE3ZTk4NmIxMmQ1NDhmZDE2OTM2N2Q0OTQifX19");
  }

}
