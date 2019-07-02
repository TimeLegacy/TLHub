package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class BurgerHat extends Hat {

  public BurgerHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Burger Hat");
    setDisplayName(getRarity().getColor() + "Burger Hat");
    setPermissionNode("hub.cosmetics.hats.burger");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19");
  }

}
