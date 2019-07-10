package net.timelegacy.tlhub.cosmetics.hats.monsters;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class WitherSkeletonHat extends Hat {

  public WitherSkeletonHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MONSTERS);
    setName("Wither Skeleton Hat");
    setDisplayName(getRarity().getColor() + "Wither Skeleton Hat");
    setPermissionNode("hub.cosmetics.hats.wither_skeleton");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzk1M2I2YzY4NDQ4ZTdlNmI2YmY4ZmIyNzNkNzIwM2FjZDhlMWJlMTllODE0ODFlYWQ1MWY0NWRlNTlhOCJ9fX0=");
  }

}
