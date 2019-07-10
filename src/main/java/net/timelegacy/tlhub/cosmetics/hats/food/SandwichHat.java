package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SandwichHat extends Hat {

  public SandwichHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Sandwich Hat");
    setDisplayName(getRarity().getColor() + "Sandwich Hat");
    setPermissionNode("hub.cosmetics.hats.sandwich");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTVmYWZkODk3MmI2Yjc2OTBmYjEzMWRjM2Y5MTdjNTU5OTkzOGY4N2I1ODRjMmY1ZTdkNDBhMGRlNDFlNTJmIn19fQ==");
  }

}
