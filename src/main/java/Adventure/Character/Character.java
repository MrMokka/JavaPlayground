package Adventure.Character;

import Adventure.Info.ArmourInfo;
import Adventure.Info.AttackInfo;
import Adventure.Info.HealingInfo;
import Adventure.Inventory.Inventory;
import Adventure.Item.Item;
import Adventure.Item.ItemType.Armour;
import Adventure.Item.ItemType.Weapon;
import Util.Random;
import Util.Range;

import java.util.HashMap;

public class Character {
  
  int id, health, maxHealth;
  String name;
  public Inventory inventory;

  public Character(Character.Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.health = builder.health == -1 ? builder.maxHealth : builder.health;
    this.maxHealth = builder.maxHealth;
    this.inventory = builder.inventory;
  }

  public static class Builder {
    
    private final int id;
    private final String name;
    private final int maxHealth;
    private final Inventory inventory;
    
    private int health = -1;

    public Builder(int id, String name, int maxHealth, HashMap<Armour.Slot, Item> equipment, Weapon weapon, HashMap<Item, Integer> inventoryItems) {
      this.id = id;
      this.name = name;
      this.maxHealth = maxHealth;
      this.inventory = new Inventory(equipment, weapon);
      this.inventory.addToInventory(inventoryItems);
    }
    
    public Builder(int id, String name, int maxHealth, HashMap<Armour.Slot, Item> equipment, Weapon weapon) {
      this(id, name, maxHealth, equipment, weapon, new HashMap<>());
    }

    public Builder startingHealth(int startingHealth) {
      this.health = startingHealth;
      return this;
    }

    public Character build() {
      return new Character(this);
    }
  }
  
  public void addToInventory(HashMap<Item, Integer> items) {
    for(Item item : items.keySet()) {
      inventory.addToInventory(item, items.get(item));
    }
  }
  
  public Range getDamageRange() {
    Weapon weapon = inventory.getWeapon();
    int lower = (int) Math.floor(weapon.getDamage() * 0.1f);
    int upper = (int) Math.ceil(weapon.getDamage() * 1.1f);
    return new Range(lower, upper);
  }

  public int getDamage() {
    Weapon weapon = inventory.getWeapon();
    int lower = (int) Math.floor(weapon.getDamage() * 0.1f);
    int upper = (int) Math.ceil(weapon.getDamage() * 1.1f);
    return Random.range(lower, upper);
  }

  public void takeDamage(int damage) {
    health -= damage;
  }
  
  public void heal(int health) {
    this.health += health;
  }

  public int getHealth() {
    return health;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public String getName() {
    return name;
  }
  
  public ArmourInfo getArmourInfo() {
    ArmourInfo info = new ArmourInfo();
    for (Item item : inventory.getEquipedArmour().values()) {
      Armour armour = (Armour) item;
      if(armour != null) {
        info.totalArmourPoints += armour.getArmour();
        info.damageReduction += armour.getDamageReduction();
      }
    }
    return info;
  }
  
}

