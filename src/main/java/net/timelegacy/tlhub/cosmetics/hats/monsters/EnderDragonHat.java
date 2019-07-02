package net.timelegacy.tlhub.cosmetics.hats.monsters;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class EnderDragonHat extends Hat {

  public EnderDragonHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MONSTERS);
    setName("Ender Dragon Hat");
    setDisplayName(getRarity().getColor() + "Ender Dragon Hat");
    setPermissionNode("hub.cosmetics.hats.ender_dragon");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRlY2MwNDA3ODVlNTQ2NjNlODU1ZWYwNDg2ZGE3MjE1NGQ2OWJiNGI3NDI0YjczODFjY2Y5NWIwOTVhIn19fQ==");
  }

}
