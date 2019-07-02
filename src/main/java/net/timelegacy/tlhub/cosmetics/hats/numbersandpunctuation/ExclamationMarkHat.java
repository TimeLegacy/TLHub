package net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ExclamationMarkHat extends Hat {

  public ExclamationMarkHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.NUMBERS_AND_PUNCTUATION);
    setName("Exclamation Mark Hat");
    setDisplayName(getRarity().getColor() + "'!' Hat");
    setPermissionNode("hub.cosmetics.hats.exclamation_mark");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzJmZjJlNGZkNDE0Y2FiYTU5YzI0NmI5NzY2YjA0MDdjOWRlZWQ1Nzk3ZjQ2NGE1OTE0N2I4OGRmOTZmYzYifX19");
  }

}
