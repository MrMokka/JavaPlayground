package Adventure;

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
    hero = new Hero("Garen", 10, new Range(1, 3));

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
    System.out.println("Enemy : " + String.format("%-" + 7 + "s", enemy.name) + " - hp: " + enemy.health + "/" + enemy.maxHealth);
    System.out.println("You   : " + String.format("%-" + 7 + "s", hero.name) + " - hp: " + hero.health + "/" + hero.maxHealth);
    System.out.println();
    System.out.println("What will you do?");
    System.out.println("Attack - Heal (" + hero.healthPotions + ") - Run");

    boolean inputAccepted = false;
    while (!inputAccepted) {
      System.out.print(":");
      String input = scanner.nextLine().toLowerCase();
      System.out.println();

      switch (input) {
        case "attack":
          inputAccepted = true;
          int damage = Random.range(hero.damageRange);
          enemy.takeDamage(damage);
          System.out.println("You hit " + enemy.name + " for " + damage + " damage");
          break;
        case "heal":
          if(hero.healthPotions > 0){
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
    if(hero.health <= 0) {
      gameRunning = false;
      System.out.println("You are dead!");
    }
    if(enemy.health <= 0) {
      System.out.println(enemy.name + " has died!");
      enemy = null;
    } else if(gameRunning) {
      int damage = Random.range(enemy.damageRange);
      hero.takeDamage(damage);
      System.out.println(enemy.name + " hits you for " + damage + " damage");
    }
  }

}
