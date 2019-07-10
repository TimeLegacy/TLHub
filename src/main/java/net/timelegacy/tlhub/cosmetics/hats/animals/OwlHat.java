package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class OwlHat extends Hat {

  public OwlHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Owl Hat");
    setDisplayName(getRarity().getColor() + "Owl Hat");
    setPermissionNode("hub.cosmetics.hats.owl");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzI4YmRiZjZiN2M3OThiODNmN2U1YmFjOTdlZTIzNzE3Zjc3MmM0NDZhOTM4MjRmN2I3OWZhM2Q5ZmYxYWQifX19");
  }

}
