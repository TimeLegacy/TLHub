package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PokeballHat extends Hat {

  public PokeballHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Pokeball Hat");
    setDisplayName(getRarity().getColor() + "Pokeball Hat");
    setPermissionNode("hub.cosmetics.hats.pokeball");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQzZDRiN2FjMjRhMWQ2NTBkZGY3M2JkMTQwZjQ5ZmMxMmQyNzM2ZmMxNGE4ZGMyNWMwZjNmMjlkODVmOGYifX19");
  }

}
