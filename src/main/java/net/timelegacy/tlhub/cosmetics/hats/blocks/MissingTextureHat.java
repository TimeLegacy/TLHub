package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MissingTextureHat extends Hat {

  public MissingTextureHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Missing Textures Hat");
    setDisplayName(getRarity().getColor() + "Missing Textures Hat");
    setPermissionNode("hub.cosmetics.hats.missing_texture");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllYjlkYTI2Y2YyZDMzNDEzOTdhN2Y0OTEzYmEzZDM3ZDFhZDEwZWFlMzBhYjI1ZmEzOWNlYjg0YmMifX19");
  }

}
