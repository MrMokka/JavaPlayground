package Adventure.Item.ItemType;

import Adventure.Item.Item;

public class Armor extends Item {
  
  int hpBonus;
  int defence;
  Slot armorSlot;
  
  public enum Slot {
    HEAD,
    CHEST,
    LEGS,
    FEET,
    HANDS
  }

  private Armor(Armor.Builder builder) {
    super(builder);
    this.hpBonus = builder.hpBonus;
    this.defence = builder.defence;
    this.armorSlot = builder.armorSlot;
  }

  public static class Builder extends Item.Builder {

    private final Slot armorSlot;

    private int hpBonus = 0;
    private int defence = 0;

    public Builder(int id, String name, Slot armorSlot) {
      super(id, name);
      this.armorSlot = armorSlot;
    }

    public Armor.Builder hpBonus(int hpBonus) {
      this.hpBonus = hpBonus;
      return this;
    }

    public Armor.Builder defence(int defence) {
      this.defence = defence;
      return this;
    }

    public Armor build() {
      return new Armor(this);
    }
  }
  
}
