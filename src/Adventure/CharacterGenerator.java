package Adventure;

import Util.Random;
import Util.Range;

public class CharacterGenerator {
  
  static PossibleEnemy[] possibleEnemies = new PossibleEnemy[]{
          new PossibleEnemy(new String[]{"Orc"}, new Range(5, 10), new Range(1, 3), new Range(5, 15), new Range(10, 20)),
          new PossibleEnemy(new String[]{"Rat"}, new Range(1, 4), new Range(0, 1), new Range(1, 5), new Range(0, 4))
  };
  
  
  public static Enemy generateEnemy() {
    int enemyIndex = Random.rand.nextInt(possibleEnemies.length);
    PossibleEnemy enemy = possibleEnemies[enemyIndex];
    return new Enemy(enemy.getName(), enemy.getHealth(), enemy.getDamageRange(), enemy.getXpValue(), enemy.getGoldValue());
  }
  
  
  
}

class PossibleEnemy  {
  String[] names;
  Range healthRange, damageRange, xpRange, goldRange;

  public PossibleEnemy(String[] names, Range healthRange, Range damageRange, Range xpRange, Range goldRange) {
    this.names = names;
    this.healthRange = healthRange;
    this.damageRange = damageRange;
    this.xpRange = xpRange;
    this.goldRange = goldRange;
  }

  public String getName() {
    return names[Random.range(0, names.length)];
  }

  public int getHealth() {
    return Random.range(healthRange.low, healthRange.high);
  }

  public Range getDamageRange() {
    return damageRange;
  }

  public int getXpValue() {
    return Random.range(xpRange.low, xpRange.high);
  }

  public int getGoldValue() {
    return Random.range(xpRange.low, xpRange.high);
  }
}


