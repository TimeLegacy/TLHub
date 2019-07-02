package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class BreadHat extends Hat {

  public BreadHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Bread Hat");
    setDisplayName(getRarity().getColor() + "Bread Hat");
    setPermissionNode("hub.cosmetics.hats.bread");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE5OTdkYTY0MDQzYjI4NDgyMjExNTY0M2E2NTRmZGM0ZThhNzIyNjY2NGI0OGE0ZTFkYmI1NTdiNWMwZmUxNCJ9fX0=");
  }

}
