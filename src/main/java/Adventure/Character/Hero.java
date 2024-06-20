package Adventure.Character;

import Util.Range;

public class Hero extends Character {

  int healthPotions = 3;
  int gold = 0, xp = 0, level = 1;

  public Hero(String name, int maxHealth, Range damageRange, int armour) {
    super(name, maxHealth, damageRange, armour);
  }

  public void heal() {
    if(healthPotions > 0) {
      healthPotions--;
      health += 3;
      if(health > maxHealth)
        health = maxHealth;
      System.out.println("You heal 3 hp");
    }
  }

  public void addXp(int xp) {
    this.xp += xp;
  }

  public int getGold() {
    return gold;
  }

  public void addGold(int gold) {
    this.gold += gold;
    System.out.printf("Added %d gold, you now have %d gold%n", gold, this.gold);
  }

  public void removeGold(int gold) {
    this.gold = Math.min(0, this.gold - gold);
  }

  public int getLevel() {
    return level;
  }

  public int getHealthPotions() {
    return healthPotions;
  }

}
