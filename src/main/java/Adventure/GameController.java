package Adventure;

import Adventure.Character.CharacterGenerator;
import Adventure.Character.Enemy;
import Adventure.Character.EnemyData;
import Adventure.Character.Hero;
import Adventure.Info.AttackInfo;
import Adventure.Item.ItemData;
import Adventure.Data.ItemList;
import Adventure.Item.ItemType.Armour;
import Util.Calculate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class GameController {

  Enemy enemy;
  Hero hero;

  Scanner scanner = new Scanner(System.in);
  boolean gameRunning;
  
  public static List<EnemyData> enemyData = new ArrayList<>();
  public static ItemData itemData;

  public GameController() {
    /*
    try{
      readEnemyData();
      readItemData();
    } catch(IOException e) {
      System.err.println(e);
      e.printStackTrace();
    }
    */
    hero = new Hero.Builder(
            -1, 
            "Garen", 
            300, 
            new HashMap<>(Map.ofEntries(
              Map.entry(Armour.Slot.HEAD, ItemList.getArmour(200)),
              Map.entry(Armour.Slot.CHEST, ItemList.getArmour(201)),
              Map.entry(Armour.Slot.LEGS, ItemList.getArmour(202)),
              Map.entry(Armour.Slot.FEET, ItemList.getArmour(203)),
              Map.entry(Armour.Slot.HANDS, ItemList.getArmour(204))
            )),
            ItemList.getWeapon(100),
            new HashMap<>(Map.ofEntries(
                    Map.entry(ItemList.getConsumable(500), 3)
            ))
    ).build();

    gameRunning = true;
    gameLoop();
  }

  void gameLoop() {
    while (gameRunning) {
      if(Objects.nonNull(enemy)) {
        fight();
      } else {
        enemy = CharacterGenerator.generateEnemy();
      }
      
      
      
    }
  }
  
  void fight() {
    System.out.println("-----------------------------------------------------------------------------");
    System.out.println();
    System.out.println("Enemy : " + String.format("%-" + 7 + "s", enemy.getName()) + " - hp: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
    System.out.println("You   : " + String.format("%-" + 7 + "s", hero.getName()) + " - hp: " + hero.getHealth() + "/" + hero.getMaxHealth());
    System.out.println();
    System.out.println("What will you do?");
    System.out.println("Attack - Heal (" + hero.getHealthPotions() + ") - Run");

    boolean inputAccepted = false;
    while (!inputAccepted) {
      System.out.print(":");
      String input = scanner.nextLine().toLowerCase();
      System.out.println();

      switch (input) {
        case "attack":
          inputAccepted = true;
          AttackInfo attackInfo = Calculate.attack(new AttackInfo(hero, enemy));
          
          enemy.takeDamage(attackInfo.defenderDamageTaken);
          System.out.println("You hit " + enemy.getName() + " for " + attackInfo.defenderDamageTaken + " damage");
          
          if(attackInfo.attackerHealed > 0) {
            hero.heal(attackInfo.attackerHealed);
            System.out.println("You healed yourself for " + attackInfo.attackerHealed + " hp");
          }
          break;
        case "heal":
          if(hero.getHealthPotions() > 0){
            inputAccepted = true;
            hero.useHealItem();
          }
          else System.out.println("You dont have any heal potions left!");
          break;
        case "run":
          inputAccepted = true;
          System.out.println("You run away and hide. Feeling the shame of running, you retire as a hero and never look back.");
          System.out.println("Game Over!");
          gameRunning = false;
          break;
        default:
          System.out.println("Input error, try again");
      }
    }
    if (!gameRunning)
      return;
    if(enemy.getHealth() <= 0) {
      System.out.println(enemy.getName() + " has died!");
      enemy = null;
    } else if(gameRunning) {
      //Enemy attack phase
      AttackInfo attackInfo = Calculate.attack(new AttackInfo(enemy, hero));
      
      hero.takeDamage(attackInfo.defenderDamageTaken);
      System.out.println(enemy.getName() + " hits you for " + attackInfo.defenderDamageTaken + " damage");
      
      if(attackInfo.attackerHealed > 0) {
        enemy.heal(attackInfo.attackerHealed);
        System.out.println(enemy.getName() + " heals itself for " + attackInfo.attackerHealed + " hp");
      }
    }
    if(hero.getHealth() <= 0) {
      gameRunning = false;
      System.out.println("You are dead!");
    }
  }
  
  void readEnemyData() throws IOException {
    InputStream iStream = CharacterGenerator.class.getResourceAsStream("/EnemyAttributes.json");
    enemyData = new ObjectMapper().readValue(iStream, new TypeReference<>(){});
  }
  
  void readItemData() throws IOException {
    InputStream iStream = CharacterGenerator.class.getResourceAsStream("/Items.json");
    itemData = new ObjectMapper().readValue(iStream, ItemData.class);
  }

}
