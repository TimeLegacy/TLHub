package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PinkDonutHat extends Hat {

  public PinkDonutHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Pink Donut Hat");
    setDisplayName(getRarity().getColor() + "Pink Donut Hat");
    setPermissionNode("hub.cosmetics.hats.pink_donut");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllOWEwZGRiYjI1MDBkZWUwYWU3ZTFmMmJkYjQ1ZTY4MGYxZmZmYmIyYTJmYTU3MDBiZDNlMmEzYTFkODlmNiJ9fX0=");
  }

}
