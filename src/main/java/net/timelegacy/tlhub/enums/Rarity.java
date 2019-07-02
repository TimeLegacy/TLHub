package net.timelegacy.tlhub.enums;

public enum Rarity {

  COMMON(80, "&a"),
  UNCOMMON(50, "&e"),
  RARE(25, "&9"),
  EPIC(10, "&5"),
  LEGENDARY(5, "&6"),

  NONE(0, "&7");
  ;

  private final int change;
  private final String color;

  Rarity(int chance, String color) {
    this.change = chance;
    this.color = color;
  }

  public int getPercentage() {
    return change;
  }

  public String getColor() {
    return color;
  }
}
