package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CakeHat extends Hat {

  public CakeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Cake Hat");
    setDisplayName(getRarity().getColor() + "Cake Hat");
    setPermissionNode("hub.cosmetics.hats.cake");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWNiYjRmZGRhY2I1NDZkYmRmNjgyNzg0MGIxMmFiNDk5OTQzMmZjMmJhMjllOWJkZWU1MzNhNmRkMjU0ZmE4In19fQ==");
  }

}
