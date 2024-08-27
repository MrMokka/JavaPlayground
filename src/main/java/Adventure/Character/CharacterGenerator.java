package Adventure.Character;
import Util.Random;
import Util.Range;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CharacterGenerator {
  
  static PossibleEnemy[] possibleEnemies = new PossibleEnemy[]{
          new PossibleEnemy(new String[]{"Orc"}, new Range(5, 10), new Range(1, 3), new Range(1, 2), new Range(5, 15), new Range(10, 20)),
          new PossibleEnemy(new String[]{"Rat"}, new Range(1, 4), new Range(0, 1), new Range(0, 0), new Range(1, 5), new Range(0, 4))
  };
  
  static Object[] enemies = new Object[10];
  
  
  public static void initEnemyList() throws IOException {
    String resourcePath = "../../../resources/EnemyAttributes.json";
    InputStream is = CharacterGenerator.class.getResourceAsStream("/EnemyAttributes.json");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Enemy> enemies = objectMapper.readValue(is, new TypeReference<List<Enemy>>(){});
    for(Enemy enemy : enemies) {
      System.out.println(enemy.name);
    }
    
    
  }
  
  public static Enemy generateEnemy() {
    int enemyIndex = Random.rand.nextInt(possibleEnemies.length);
    PossibleEnemy enemy = possibleEnemies[enemyIndex];
    return new Enemy(enemy.getName(), enemy.getHealth(), enemy.getDamageRange(), enemy.getXpValue(), enemy.getGoldValue(), enemy.getArmourValue());
  }
  
  
  
}

class PossibleEnemy  {
  String[] names;
  Range healthRange, damageRange, armourRange, xpRange, goldRange;

  public PossibleEnemy(String[] names, Range healthRange, Range damageRange, Range armourRange, Range xpRange, Range goldRange) {
    this.names = names;
    this.healthRange = healthRange;
    this.damageRange = damageRange;
    this.xpRange = xpRange;
    this.goldRange = goldRange;
    this.armourRange = armourRange;
  }

  public String getName() {
    return names[Random.range(0, names.length)];
  }

  public Range getHealth() {
    return healthRange;
  }

  public Range getDamageRange() {
    return damageRange;
  }

  public Range getXpValue() {
    return xpRange;
  }

  public Range getGoldValue() {
    return goldRange;
  }

  public Range getArmourValue() {
    return armourRange;
  }
}


