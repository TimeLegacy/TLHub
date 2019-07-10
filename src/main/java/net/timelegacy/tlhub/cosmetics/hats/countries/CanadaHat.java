package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CanadaHat extends Hat {

  public CanadaHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Canada Hat");
    setDisplayName(getRarity().getColor() + "Canada Hat");
    setPermissionNode("hub.cosmetics.hats.canada");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjI0MWE2OTdmNmRmYjFjNTdjZGEzMjdiYWE2NzMyYTc4MjhjMzk4YmU0ZWJmZGJkMTY2YzIzMmJjYWUyYiJ9fX0=");
  }

}
