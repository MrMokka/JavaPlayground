package Adventure.Character;
import Adventure.GameController;
import Util.Random;

public class CharacterGenerator {
  
  public static Enemy generateEnemy() {
    return GameController.enemyData.get(Random.range(0, GameController.enemyData.size())).generateEnemy();
    //int enemyIndex = Random.rand.nextInt(possibleEnemies.length);
    //PossibleEnemy enemy = possibleEnemies[enemyIndex];
    //return new Enemy(enemy.getName(), enemy.getHealth(), enemy.getDamageRange(), enemy.getXpValue(), enemy.getGoldValue(), enemy.getArmourValue());
  }
  
}
