package Adventure.Data;

import Adventure.Character.Character;
import Adventure.Character.Enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyList {

  static Map<Integer, Enemy> enemyMap = Map.ofEntries(
          Map.entry(100, new Enemy.Builder(1000, "Goblin", 30, new HashMap<>(), ItemList.getWeapon(100)).build()),
          Map.entry(101, new Enemy.Builder(1001, "Orc", 40, new HashMap<>(), ItemList.getWeapon(100)).build()),
          Map.entry(102, new Enemy.Builder(1002, "Skeleton", 50, new HashMap<>(), ItemList.getWeapon(100)).build())
  );
  
  
  
  
  
  
}
