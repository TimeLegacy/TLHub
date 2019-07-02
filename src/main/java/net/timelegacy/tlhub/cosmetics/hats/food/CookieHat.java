package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CookieHat extends Hat {

  public CookieHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Cookie Hat");
    setDisplayName(getRarity().getColor() + "Cookie Hat");
    setPermissionNode("hub.cosmetics.hats.cookie");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTFmZDk4MWNlMTVhMjk4MGE5NjExNWM4ZDY3MDk5ZjRiY2I0OTFmMmU2Yzc5MDg0N2E3OWMzNjBlNWZjIn19fQ==");
  }

}
