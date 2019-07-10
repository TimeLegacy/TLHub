package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SnowmanHat extends Hat {

  public SnowmanHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Snowman Hat");
    setDisplayName(getRarity().getColor() + "Snowman Hat");
    setPermissionNode("hub.cosmetics.hats.snowman");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzJhNDVjY2RjZWUxZjZmNmFjM2U4ZmZmMDkzYzIyZTkwZWFlOTU5ZmI2MDkyYzliYjJlOTg2NDNhOWYyZDQ0In19fQ==");
  }

}
