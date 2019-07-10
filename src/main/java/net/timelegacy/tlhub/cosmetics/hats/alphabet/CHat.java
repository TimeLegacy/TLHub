package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CHat extends Hat {

  public CHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("C Hat");
    setDisplayName(getRarity().getColor() + "'C' Hat");
    setPermissionNode("hub.cosmetics.hats.c");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGUzMmY0YTRjMzZhMjFhODM1ODkxMzJlNTk5ZTdjYzQ2YWY3NmY1ZDBkM2VmYzkyZGEzZTBjYmZlOGRjNyJ9fX0=");
  }

}
