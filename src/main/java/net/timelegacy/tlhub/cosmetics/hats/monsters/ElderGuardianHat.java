package net.timelegacy.tlhub.cosmetics.hats.monsters;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ElderGuardianHat extends Hat {

  public ElderGuardianHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MONSTERS);
    setName("Elder Guardian Hat");
    setDisplayName(getRarity().getColor() + "Elder Guardian Hat");
    setPermissionNode("hub.cosmetics.hats.elder_guardian");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkyMDg5NjE4NDM1YTBlZjYzZTk1ZWU5NWE5MmI4MzA3M2Y4YzMzZmE3N2RjNTM2NTE5OWJhZDMzYjYyNTYifX19");
  }

}
