package Adventure.Character;

import Adventure.Info.HealingInfo;
import Adventure.Inventory.Inventory;
import Adventure.Item.Item;
import Adventure.Item.ItemType.Armour;
import Adventure.Item.ItemType.Weapon;
import Util.Random;
import Util.Range;

import java.util.HashMap;

public class Enemy extends Character {

  public int xpValue, goldValue;

  protected Enemy(Builder builder) {
    super(builder);
  }

  public static class Builder extends Character.Builder {

    public Builder(int id, String name, int maxHealth, HashMap<Armour.Slot, Item> equipment, Weapon weapon, HashMap<Item, Integer> inventoryItems) {
      super(id, name, maxHealth, equipment, weapon, inventoryItems);
    }

    public Builder(int id, String name, int maxHealth, HashMap<Armour.Slot, Item> equipment, Weapon weapon) {
      super(id, name, maxHealth, equipment, weapon, new HashMap<>());
    }

    public Enemy build() {
      return new Enemy(this);
    }
  }

}
