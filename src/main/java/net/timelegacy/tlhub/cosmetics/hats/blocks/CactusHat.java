package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CactusHat extends Hat {

  public CactusHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Cactus Hat");
    setDisplayName(getRarity().getColor() + "Cactus Hat");
    setPermissionNode("hub.cosmetics.hats.cactus");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmY1ODViNDFjYTVhMWI0YWMyNmY1NTY3NjBlZDExMzA3Yzk0ZjhmOGExYWRlNjE1YmQxMmNlMDc0ZjQ3OTMifX19");
  }

}
