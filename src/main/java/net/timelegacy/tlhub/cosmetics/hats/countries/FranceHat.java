package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class FranceHat extends Hat {

  public FranceHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("France Hat");
    setDisplayName(getRarity().getColor() + "France Hat");
    setPermissionNode("hub.cosmetics.hats.france");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEyNjlhMDY3ZWUzN2U2MzYzNWNhMWU3MjNiNjc2ZjEzOWRjMmRiZGRmZjk2YmJmZWY5OWQ4YjM1Yzk5NmJjIn19fQ==");
  }

}
