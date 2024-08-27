package Adventure.Item;

public class Weapon extends Item {
  
  int damage;
  int healing;
  int defence;
  
  public Weapon(String name, int damage, int healing, int defence) {
    super(name);
    this.damage = damage;
    this.healing = healing;
    this.defence = defence;
  }
  
  
}
