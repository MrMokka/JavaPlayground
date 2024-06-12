package Adventure.Character;

import Util.Random;
import Util.Range;

public class CharacterGenerator {
  
  static PossibleEnemy[] possibleEnemies = new PossibleEnemy[]{
          new PossibleEnemy(new String[]{"Orc"}, new Range(5, 10), new Range(1, 3), new Range(5, 15), new Range(10, 20), 1),
          new PossibleEnemy(new String[]{"Rat"}, new Range(1, 4), new Range(0, 1), new Range(1, 5), new Range(0, 4), 0)
  };
  
  
  public static Enemy generateEnemy() {
    int enemyIndex = Random.rand.nextInt(possibleEnemies.length);
    PossibleEnemy enemy = possibleEnemies[enemyIndex];
    return new Enemy(enemy.getName(), enemy.getHealth(), enemy.getDamageRange(), enemy.getXpValue(), enemy.getGoldValue(), enemy.getArmour());
  }
  
  
  
}

class PossibleEnemy  {
  String[] names;
  Range healthRange, damageRange, xpRange, goldRange;
  int armour;

  public PossibleEnemy(String[] names, Range healthRange, Range damageRange, Range xpRange, Range goldRange, int armour) {
    this.names = names;
    this.healthRange = healthRange;
    this.damageRange = damageRange;
    this.xpRange = xpRange;
    this.goldRange = goldRange;
    this.armour = armour;
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

  public int getArmour() {
    return armour;
  }
}


