package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class WaspHat extends Hat {

  public WaspHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Wasp Hat");
    setDisplayName(getRarity().getColor() + "Wasp Hat");
    setPermissionNode("hub.cosmetics.hats.wasp");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDUzYzZhODRiNWE1NGMxMDIyMTAyNzgwZTVkNTJiYWQ2NmZkNDJmYzY2NGY2ZGFjOThlOTQxOTY2OTdiOSJ9fX0=");
  }

}
