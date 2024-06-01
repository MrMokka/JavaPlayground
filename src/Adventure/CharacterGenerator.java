package Adventure;

import Util.Random;
import Util.Range;

public class CharacterGenerator {
  
  static PossibleEnemy[] possibleEnemies = new PossibleEnemy[]{
          new PossibleEnemy(new String[]{"Orc"}, new Range(5, 15), new Range(1, 3)),
          new PossibleEnemy(new String[]{"Rat"}, new Range(1, 4), new Range(0, 1))
  };
  
  
  public static Enemy generateEnemy() {
    int enemyIndex = Random.rand.nextInt(possibleEnemies.length);
    PossibleEnemy enemy = possibleEnemies[enemyIndex];
    return new Enemy(enemy.getName(), enemy.getHealth(), enemy.getDamage());
  }
  
  
  
}

class PossibleEnemy  {
  String[] names;
  Range healthRange, damageRange;

  public PossibleEnemy(String[] names, Range healthRange, Range damageRange) {
    this.names = names;
    this.healthRange = healthRange;
    this.damageRange = damageRange;
  }

  public String getName() {
    return names[Random.range(0, names.length)];
  }

  public int getHealth() {
    return Random.range(healthRange.low, healthRange.high);
  }

  public int getDamage() {
    return Random.range(damageRange.low, damageRange.high);
  }
}


