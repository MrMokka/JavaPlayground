package Adventure.Item.ItemType;

import Adventure.Item.Item;

public class Armour extends Item {
  
  int hpBonus;
  int armour;
  Slot armourSlot;
  float damageReduction;

  public enum Slot {
    HEAD,
    CHEST,
    LEGS,
    FEET,
    HANDS
  }

  protected Armour(Armour.Builder builder) {
    super(builder);
    this.hpBonus = builder.hpBonus;
    this.armour = builder.armour;
    this.armourSlot = builder.armourSlot;
    this.damageReduction = builder.damageReduction;
  }

  public static class Builder extends Item.Builder {

    private final Slot armourSlot;

    private int hpBonus = 0;
    private int armour = 0;
    private float damageReduction = 0;

    public Builder(int id, String name, Slot armourSlot, int armour) {
      super(id, name);
      this.armourSlot = armourSlot;
      this.armour = armour;
    }

    public Builder hpBonus(int hpBonus) {
      this.hpBonus = hpBonus;
      return this;
    }
    
    public Builder damageReduction(float percentage) {
      this.damageReduction = percentage;
      return this;
    }
    
    @Override
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Armour build() {
      return new Armour(this);
    }
  }
  
  public int getArmour() {
    return armour;
  }
  
  public float getDamageReduction() {
    return damageReduction;
  }

  public Slot getArmourSlot() {
    return armourSlot;
  }

  @Override
  public int OnTakeDamage(int damage) {
    if(damageReduction != 0) {
      float percentage = damageReduction / 100f;
      int newDamage = (int) Math.floor(damage * percentage);
      return newDamage;
    }
    return damage;
  }
  
}
