package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class EnglandHat extends Hat {

  public EnglandHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("England Hat");
    setDisplayName(getRarity().getColor() + "England Hat");
    setPermissionNode("hub.cosmetics.hats.england");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmVlNWM4NTBhZmJiN2Q4ODQzMjY1YTE0NjIxMWFjOWM2MTVmNzMzZGNjNWE4ZTIxOTBlNWMyNDdkZWEzMiJ9fX0=");
  }

}
