package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CompanionCubeHat extends Hat {

  public CompanionCubeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Companion Cube Hat");
    setDisplayName(getRarity().getColor() + "Companion Cube Hat");
    setPermissionNode("hub.cosmetics.hats.companion_cube");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2Q5NmI3ZmU1ZjRmYjJhYmFhMWE0MzEyNzc2NmUyNTI0YzQyZjkyZGYxNWIxYTczZjNlN2Y2NTUxOWRkYzgyIn19fQ==");
  }

}
