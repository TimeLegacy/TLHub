package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MonacoHat extends Hat {

  public MonacoHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Monaco Hat");
    setDisplayName(getRarity().getColor() + "Monaco Hat");
    setPermissionNode("hub.cosmetics.hats.monaco");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWRiMjY3OGNjYWJhNzkzNDQxMmNiOTdlZTE2ZDQxNjQ2M2EzOTI1NzRjNTkwNjM1MmYxOGRlYTQyODk1ZWUifX19");
  }

}
