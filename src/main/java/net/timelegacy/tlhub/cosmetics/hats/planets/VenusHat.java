package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class VenusHat extends Hat {

  public VenusHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Venus Hat");
    setDisplayName(getRarity().getColor() + "Venus Hat");
    setPermissionNode("hub.cosmetics.hats.venus");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMGVmMTQ3ZGRjOTA4ZTY4MjVjMjI5OTk3YWE1Mjk3NjFmNTE2OTFhMTFjOTU1MTI5YTIzMzYzMmQ1NTQ4NzVlIn19fQ==");
  }

}
