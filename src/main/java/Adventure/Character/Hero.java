package Adventure.Character;

import Adventure.Item.Item;
import Adventure.Item.ItemType.Armour;
import Adventure.Item.ItemType.Weapon;

import java.util.HashMap;

public class Hero extends Character {

  int healthPotions = 3;
  int gold = 0, xp = 0, level = 1;
  
  protected Hero(Builder builder) {
    super(builder);
  }

  public static class Builder extends Character.Builder {

    public Builder(int id, String name, int maxHealth, HashMap<Armour.Slot, Item> equipment, Weapon weapon, HashMap<Item, Integer> inventoryItems) {
      super(id, name, maxHealth, equipment, weapon, inventoryItems);
    }

    public Builder(int id, String name, int maxHealth, HashMap<Armour.Slot, Item> equipment, Weapon weapon) {
      super(id, name, maxHealth, equipment, weapon, new HashMap<>());
    }

    public Hero build() {
      return new Hero(this);
    }
  }

  public void useHealItem() {
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
