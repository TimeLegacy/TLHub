package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class DogeHat extends Hat {

  public DogeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Doge Hat");
    setDisplayName(getRarity().getColor() + "Doge Hat");
    setPermissionNode("hub.cosmetics.hats.doge");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZThlNmY3Nzk1ZGYyZWI4ZDdmNGZmNWQwYWVkNTI5YmU4MTEzNGQ5N2JiNTEyNjNlMzhjYjY5NGQ2NzA0ZGE0In19fQ==");
  }

}
