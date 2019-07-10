package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ElfHat extends Hat {

  public ElfHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Elf Hat");
    setDisplayName(getRarity().getColor() + "Elf Hat");
    setPermissionNode("hub.cosmetics.hats.elf");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmE3NjkzMzUzYTZhZTU3N2I1NzQ0ODdiMzkwZTMzNjYxNWU0ZDdlNGM2MjdkYThmM2U5MzRkMzg5YWM2NWMifX19");
  }

}
