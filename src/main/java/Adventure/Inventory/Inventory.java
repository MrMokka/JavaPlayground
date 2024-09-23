package Adventure.Inventory;

import Adventure.Item.Item;
import Adventure.Item.ItemType.Armour;
import Adventure.Item.ItemType.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Inventory {

  HashMap<Armour.Slot, Item> equipment;
  Weapon weapon;
  ArrayList<Item> inventory = new ArrayList<>();
  
  public Inventory(HashMap<Armour.Slot, Item> equipment, Weapon weapon) {
    this.equipment = equipment;
    this.weapon = weapon;
  }
  
  public void setInventory(ArrayList<Item> inventory) {
    this.inventory = inventory;
  }
  
  public void equipArmour(Armour armour) {
    Armour.Slot slot = armour.getArmourSlot();
    if(slot != null) {
      addToInventory(equipment.get(slot), 1);
    }
    equipment.put(armour.getArmourSlot(), armour);
  }
  
  public void equipWeapon(Weapon weapon) {
    if(weapon != null) {
      addToInventory(this.weapon, 1);
    }
    this.weapon = weapon;
  }
  
  public void addToInventory(Item item, int count) {
    for (int i = 0; i < count; i++) {
      inventory.add(item);
    }
  }
  
  public void addToInventory(HashMap<Item, Integer> items) {
    for (Item item : items.keySet()) {
      addToInventory(item, items.get(item));
    }
  }
  
  public Item takeItemFromInventory(String itemName) {
    Optional<Item> item = inventory.stream().filter(i -> i.getName().equals(itemName)).findFirst();
    if(item.isPresent()) {
      inventory.remove(item.get());
      return item.get();
    }
    return null;
  }
  
  public HashMap<String, Integer> getItemList() {
    HashMap<String, Integer> itemList = new HashMap<>();
    for (Item i: inventory) {
      itemList.put(i.getName(), itemList.get(i.getName()) + 1);
    }
    return itemList;
  }
  
  public ArrayList<Item> getInventory() {
    return inventory;
  }
  
  public Weapon getWeapon() {
    return weapon;
  }
  
  public HashMap<Armour.Slot, Item> getEquipedArmour() {
    return equipment;
  }
  
  
}
