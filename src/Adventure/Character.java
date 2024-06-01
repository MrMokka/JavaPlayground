package Adventure;

import Util.Range;

public class Character {
  
  int health, maxHealth;
  Range damageRange;
  String name;

  public Character(String name, int maxhealth, Range damageRange) {
    this.name = name;
    this.maxHealth = maxhealth;
    health = maxhealth;
    this.damageRange = damageRange;
  }

  public void takeDamage(int damage) {
    health -= damage;
  }

}
