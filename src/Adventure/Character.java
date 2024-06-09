package Adventure;

import Util.Range;

public class Character {
  
  int health, maxHealth;
  Range damageRange;
  String name;

  public Character(String name, int maxHealth, Range damageRange) {
    this.name = name;
    this.maxHealth = maxHealth;
    health = maxHealth;
    this.damageRange = damageRange;
  }

  public void takeDamage(int damage) {
    health -= damage;
  }

}
