package Adventure.Character.PossibleEnemies;

import Adventure.Character.Enemy;
import Util.Random;

public class Orc {
  public int health, damage, armour, xp, gold;
  public int maxHealth = Random.range(5,10);
  
  
  public Orc(String name) {
    health = maxHealth;
    
  }
  
  
}
