package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class BeachBallHat extends Hat {

  public BeachBallHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Beach Ball Hat");
    setDisplayName(getRarity().getColor() + "Beach Ball Hat");
    setPermissionNode("hub.cosmetics.hats.beach_ball");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWE1YWIwNWVhMjU0YzMyZTNjNDhmM2ZkY2Y5ZmQ5ZDc3ZDNjYmEwNGU2YjVlYzJlNjhiM2NiZGNmYWMzZmQifX19");
  }

}
