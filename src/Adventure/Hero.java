package Adventure;

public class Hero extends Character {

  int healthPotions = 3;
  int gold = 0;

  public Hero(String name, int maxhealth, int attackPower) {
    super(name, maxhealth, attackPower);
  }

  public void heal() {
    if(healthPotions > 0) {
      healthPotions--;
      health += 3;
      if(health > maxHealth)
        health = maxHealth;
      System.out.println("You heal 3 hp");
    }
  }
  
}
