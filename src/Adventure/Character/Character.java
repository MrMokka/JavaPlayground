package Adventure.Character;

import Util.Range;

public class Character {
  
  int health, maxHealth, armour;
  Range damageRange;
  String name;

  public Character(String name, int maxHealth, Range damageRange, int armour) {
    this.name = name;
    this.maxHealth = maxHealth;
    health = maxHealth;
    this.damageRange = damageRange;
    this.armour = armour;
  }

  public void takeDamage(int damage) {
    health -= damage;
  }

  public int getHealth() {
    return health;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public Range getDamageRange() {
    return damageRange;
  }

  public String getName() {
    return name;
  }

  public int getArmour() {
    return armour;
  }
}
