package net.timelegacy.tlhub.cosmetics.hats.monsters;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SpiderHat extends Hat {

  public SpiderHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MONSTERS);
    setName("Spider Hat");
    setDisplayName(getRarity().getColor() + "Spider Hat");
    setPermissionNode("hub.cosmetics.hats.spider");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTNlYWQ4MTMyNmVkNWQ1YWE5N2I1M2IwZjU0MGI4MjViNzljYmY0ODU1Y2U5YjkwZmU3M2VhMjMxMWViM2EifX19");
  }

}
