package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SwedenHat extends Hat {

  public SwedenHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Sweden Hat");
    setDisplayName(getRarity().getColor() + "Sweden Hat");
    setPermissionNode("hub.cosmetics.hats.sweden");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkxMDkwNGJmZjljODZmNmVkNDc2ODhlOTQyOWMyNmU4ZDljNWQ1NzQzYmQzZWJiOGU2ZjUwNDBiZTE5Mjk5OCJ9fX0=");
  }

}
