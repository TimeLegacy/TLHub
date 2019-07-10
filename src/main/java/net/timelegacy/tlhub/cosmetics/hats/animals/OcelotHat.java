package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class OcelotHat extends Hat {

  public OcelotHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Ocelot Hat");
    setDisplayName(getRarity().getColor() + "Ocelot Hat");
    setPermissionNode("hub.cosmetics.hats.ocelot");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTFmMDdlM2YyZTVmMjU2YmZhZGU2NjZhOGRlMWI1ZDMwMjUyYzk1ZTk4ZjhhOGVjYzZlM2M3YjdmNjcwOTUifX19");
  }

}
