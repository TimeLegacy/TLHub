package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PugHat extends Hat {

  public PugHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Pug Hat");
    setDisplayName(getRarity().getColor() + "Pug Hat");
    setPermissionNode("hub.cosmetics.hats.pug");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDdiNGY4NGUxOWI1MmYzMTIxNzcxMmU3YmE5ZjUxZDU2ZGE1OWQyNDQ1YjRkN2YzOWVmNmMzMjNiODE2NiJ9fX0=");
  }

}
