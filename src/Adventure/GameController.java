package Adventure;

import Adventure.Character.CharacterGenerator;
import Adventure.Character.Enemy;
import Adventure.Character.Hero;
import Util.Calculate;
import Util.Random;
import Util.Range;

import java.util.Objects;
import java.util.Scanner;

public class GameController {

  Enemy enemy;
  Hero hero;

  Scanner scanner = new Scanner(System.in);
  boolean gameRunning = false;

  public GameController() {
    hero = new Hero("Garen", 10, new Range(1, 3), 1);

    gameRunning = true;
    gameLoop();
  }

  void gameLoop() {
    Calculate.xp(20);
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
          int damage = Calculate.damage(hero, enemy.getArmour());
          enemy.takeDamage(damage);
          System.out.println("You hit " + enemy.getName() + " for " + damage + " damage");
          break;
        case "heal":
          if(hero.getHealthPotions() > 0){
            inputAccepted = true;
            hero.heal();
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
    if(hero.getHealth() <= 0) {
      gameRunning = false;
      System.out.println("You are dead!");
    }
    if(enemy.getHealth() <= 0) {
      System.out.println(enemy.getName() + " has died!");
      enemy = null;
    } else if(gameRunning) {
      int damage = Calculate.damage(enemy, hero.getArmour());
      hero.takeDamage(damage);
      System.out.println(enemy.getName() + " hits you for " + damage + " damage");
    }
  }

}
