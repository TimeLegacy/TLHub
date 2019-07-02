package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SingaporeHat extends Hat {

  public SingaporeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Singapore Hat");
    setDisplayName(getRarity().getColor() + "Singapore Hat");
    setPermissionNode("hub.cosmetics.hats.singapore");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI1ZWQxMWY3OTdmM2ZjNjFlYWY4ZGFmYjZiZjMyMzRkMzFiOTZhYjc1OTZiZDJkZjcyMmQyZWYzNDczYzI3In19fQ==");
  }

}
