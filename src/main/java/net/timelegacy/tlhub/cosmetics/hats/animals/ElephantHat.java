package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ElephantHat extends Hat {

  public ElephantHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Elephant Hat");
    setDisplayName(getRarity().getColor() + "Elephant Hat");
    setPermissionNode("hub.cosmetics.hats.elephant");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzcxZTgyOTY1ZDMzMjEzZWYyNmY2Yjg5NzIyZWRlZTQzNDZjMzU0YzA4ZTM0ZWNmY2ZkNmRkZDM2MWE5ZTdlIn19fQ==");
  }

}
