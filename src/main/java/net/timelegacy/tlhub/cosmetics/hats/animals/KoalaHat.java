package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class KoalaHat extends Hat {

  public KoalaHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Koala Hat");
    setDisplayName(getRarity().getColor() + "Koala Hat");
    setPermissionNode("hub.cosmetics.hats.koala");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODZjOWQ1MWU5OGJlM2U2ODlmNmM2OWRjN2ZkNDU0ZDk1OTYyOWE1MDU1OWJlZDE2ZWFiY2Q3YTM4Zjk4MWYifX19");
  }

}
