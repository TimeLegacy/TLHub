package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class BeeHat extends Hat {

  public BeeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Bee Hat");
    setDisplayName(getRarity().getColor() + "Bee Hat");
    setPermissionNode("hub.cosmetics.hats.bee");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdkYjlhNjA0N2QyOTlhNjk0NWZhMzYwMjk5ZTEyYTEzNzM2ZDU2ZjFmZGZjMTkyZWMyMGYyOWNmNDY4MThjIn19fQ==");
  }

}
