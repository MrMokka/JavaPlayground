package Adventure.Item.ItemType;

import Adventure.Info.HealingInfo;
import Adventure.Item.Item;

public class Weapon extends Item {
  
  int damage;
  HealingInfo healingInfo;
  int defence;
  
  protected Weapon(Builder builder) {
    super(builder);
    this.damage = builder.damage;
    this.healingInfo = builder.healingInfo;
    this.defence = builder.defence;
  }
  
  public static class Builder extends Item.Builder {
    
    private final int damage;
    
    private HealingInfo healingInfo = new HealingInfo(HealingInfo.HealingType.FLAT, 0);
    private int defence = 0;
    
    public Builder(int id, String name, int damage) {
      super(id, name);
      this.damage = damage;
    }
    
    public Builder healingInfo(HealingInfo healingInfo) {
      this.healingInfo = healingInfo;
      return this;
    }
    
    public Builder defence(int defence) {
      this.defence = defence;
      return this;
    }

    @Override
    public Builder description(String description) {
      this.description = description;
      return this;
    }
    
    public Weapon build() {
      return new Weapon(this);
    }
  }

  public int getDamage() {
    return damage;
  }

  public HealingInfo getHealingInfo() {
    return healingInfo;
  }

  public int getDefence() {
    return defence;
  }
}
