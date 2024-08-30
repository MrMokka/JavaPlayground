package Adventure.Item.ItemType;

import Adventure.Item.Item;

public class Weapon extends Item {
  
  int damage;
  int healing;
  int defence;
  
  private Weapon(Builder builder) {
    super(builder);
    this.damage = builder.damage;
    this.healing = builder.healing;
    this.defence = builder.defence;
  }
  
  public static class Builder extends Item.Builder {
    
    private final int damage;
    
    private int healing = 0;
    private int defence = 0;
    
    public Builder(int id, String name, int damage) {
      super(id, name);
      this.damage = damage;
    }
    
    public Builder healing(int healing) {
      this.healing = healing;
      return this;
    }
    
    public Builder defence(int defence) {
      this.defence = defence;
      return this;
    }
    
    public Weapon build() {
      return new Weapon(this);
    }
  }
  
}
