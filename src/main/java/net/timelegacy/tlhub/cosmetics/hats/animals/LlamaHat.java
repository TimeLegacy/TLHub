package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class LlamaHat extends Hat {

  public LlamaHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Llama Hat");
    setDisplayName(getRarity().getColor() + "Llama Hat");
    setPermissionNode("hub.cosmetics.hats.llama");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODE4Y2Q0NTdmYmFmMzI3ZmEzOWYxMGI1YjM2MTY2ZmQwMTgyNjQwMzY4NjUxNjRjMDJkOWU1ZmY1M2Y0NSJ9fX0=");
  }

}
