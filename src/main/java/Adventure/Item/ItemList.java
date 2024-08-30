package Adventure.Item;

import Adventure.Item.ItemType.*;
import Util.Random;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemList {
  
  static Map<Integer, Weapon> weaponMap = Map.ofEntries(
          Map.entry(100, new Weapon.Builder(100, "Short Sword", 2).build()),
          Map.entry(101, new Weapon.Builder(101, "Long Sword", 4).build()),
          Map.entry(102, new Weapon.Builder(102, "Mace", 3).defence(1).build()),
          Map.entry(103, new Weapon.Builder(103, "War Hammer", 5).build()),
          Map.entry(104, new Weapon.Builder(104, "Elemental Staff", 1).healing(1).build()),
          Map.entry(105, new Weapon.Builder(105, "Battle Staff", 3).healing(2).build())
  );

  static Map<Integer, Armor> armorMap = Map.ofEntries(
          Map.entry(200, new Armor.Builder(200, "Leather Helmet", Armor.Slot.HEAD).build()),
          Map.entry(201, new Armor.Builder(201, "Leather Chestplate", Armor.Slot.CHEST).build()),
          Map.entry(202, new Armor.Builder(202, "Leather Leggings", Armor.Slot.LEGS).build()),
          Map.entry(203, new Armor.Builder(203, "Leather Boots", Armor.Slot.FEET).build()),
          Map.entry(204, new Armor.Builder(204, "Leather Gloves", Armor.Slot.HANDS).build())
  );

  static Map<Integer, Consumable> consumableMap = Map.ofEntries(
          Map.entry(500, new Consumable.Builder(500, "Health Potion").healing(3).build()),
          Map.entry(501, new Consumable.Builder(501, "Large Health Potion").healing(7).build())
  );

  //region Shortname list
  
  static BiMap<String, Integer> shortnameMap = HashBiMap.create();
  static {
    //Weapons
    shortnameMap.put("sword.short", 100);
    shortnameMap.put("sword.long", 101);
    shortnameMap.put("mace", 102);
    shortnameMap.put("hammer.war", 103);
    shortnameMap.put("staff.elemental", 104);
    shortnameMap.put("staff.battle", 105);

    //Armor
    shortnameMap.put("leather.helmet", 200);
    shortnameMap.put("leather.chestplate", 201);
    shortnameMap.put("leather.leggings", 202);
    shortnameMap.put("leather.boots", 203);
    shortnameMap.put("leather.gloves", 204);
    
    //Consumables
    shortnameMap.put("potion.health", 500);
    shortnameMap.put("potion.health.large", 501);
  }
  
  //endregion
  
  //region Weapon Functions

  public static Weapon getWeapon(String shortName) {
    return weaponMap.get(shortnameMap.get(shortName));
  }

  public static Weapon getWeapon(int id) {
    return weaponMap.get(id);
  }
  
  public static Weapon getRandomWeapon() {
    List<Integer> keys = new ArrayList<>(weaponMap.keySet());
    int randomIndex = Random.range(keys.size());
    return weaponMap.get(keys.get(randomIndex));
  }
  
  //endregion

  //region Armor Functions

  public static Armor getArmor(String shortName) {
    return armorMap.get(shortnameMap.get(shortName));
  }

  public static Armor getArmor(int id) {
    return armorMap.get(id);
  }

  public static Armor getRandomArmor() {
    List<Integer> keys = new ArrayList<>(armorMap.keySet());
    int randomIndex = Random.range(keys.size());
    return armorMap.get(keys.get(randomIndex));
  }

  //endregion

  //region Consumable Functions
  
  public static Consumable getConsumable(String shortName) {
    return consumableMap.get(shortnameMap.get(shortName));
  }
  
  public static Consumable getConsumable(int id) {
    return consumableMap.get(id);
  }
  
  public static Consumable getRandomConsumable() {
    List<Integer> keys = new ArrayList<>(consumableMap.keySet());
    int randomIndex = Random.range(keys.size());
    return consumableMap.get(keys.get(randomIndex));
  }
  
  //endregion
  
  public static String getShortname(int key) {
    return shortnameMap.inverse().get(key);
  }
  
  
  
}
