package Adventure.Item;

import Adventure.Item.ItemType.*;
import Util.Random;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
  
  static List<Item> itemList = new ArrayList<>() {{
    add(new Item("Item 1"));
    add(new Item("Item 2"));
    add(new Item("Item 3"));
    add(new Item("Item 4"));
    add(new Item("Item 5"));
  }};
  
  static List<Weapon> weaponList = new ArrayList<>() {{
    add(new Weapon.Builder("Short Sword", 2).build());
    add(new Weapon.Builder("Long Sword", 4).build());
    add(new Weapon.Builder("Cleaver", 2).defence(1).build());
    add(new Weapon.Builder("Mace", 3).defence(1).build());
    add(new Weapon.Builder("War Hammer", 5).build());
    add(new Weapon.Builder("Elemental Staff", 1).healing(1).build());
    add(new Weapon.Builder("Battle Staff", 3).healing(2).build());
  }};
  
  static List<Weapon> consumableList = new ArrayList<>() {{
    add(new Weapon.Builder("Short Sword", 2).build());
  }};
  
  public static Item GetItem() {
    return itemList.get(0);
  }
  
  public static Weapon getWeapon() {
    return weaponList.get(0);
  }
  
}
