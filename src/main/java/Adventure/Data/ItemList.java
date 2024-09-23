package Adventure.Data;

import Adventure.Info.HealingInfo;
import Adventure.Item.ItemType.*;
import Util.Random;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemList {
  
  static Map<Integer, Weapon> weaponMap = Map.ofEntries(
          Map.entry(100, new Weapon.Builder(100, "Short Sword", 20).build()),
          Map.entry(101, new Weapon.Builder(101, "Long Sword", 40).build()),
          Map.entry(102, new Weapon.Builder(102, "Mace", 30).defence(5).build()),
          Map.entry(103, new Weapon.Builder(103, "War Hammer", 55).build()),
          Map.entry(104, new Weapon.Builder(104, "Elemental Staff", 15).healingInfo(new HealingInfo(HealingInfo.HealingType.FLAT, 8)).description("Heal 8hp on every attack").build()),
          Map.entry(105, new Weapon.Builder(105, "Battle Staff", 25).healingInfo(new HealingInfo(HealingInfo.HealingType.FLAT, 15)).description("Heal 15hp on every attack").build())
  );

  static Map<Integer, Armour> armourMap = Map.ofEntries(
          Map.entry(200, new Armour.Builder(200, "Leather Helmet", Armour.Slot.HEAD, 4).build()),
          Map.entry(201, new Armour.Builder(201, "Leather Chestplate", Armour.Slot.CHEST, 7).build()),
          Map.entry(202, new Armour.Builder(202, "Leather Leggings", Armour.Slot.LEGS, 5).build()),
          Map.entry(203, new Armour.Builder(203, "Leather Boots", Armour.Slot.FEET, 2).build()),
          Map.entry(204, new Armour.Builder(204, "Leather Gloves", Armour.Slot.HANDS, 2).build()),
          Map.entry(205, new Armour.Builder(205, "Chestplate of Reduction", Armour.Slot.CHEST, 15).damageReduction(0.5f).description("Reduces damage by 50%").build())
  );

  static Map<Integer, Consumable> consumableMap = Map.ofEntries(
          Map.entry(500, new Consumable.Builder(500, "Health Potion").healing(50).description("Heal 50hp").build()),
          Map.entry(501, new Consumable.Builder(501, "Large Health Potion").healing(100).description("Heal 100hp").build())
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

    //Armour
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

  //region Armour Functions

  public static Armour getArmour(String shortName) {
    return armourMap.get(shortnameMap.get(shortName));
  }

  public static Armour getArmour(int id) {
    return armourMap.get(id);
  }

  public static Armour getRandomArmour() {
    List<Integer> keys = new ArrayList<>(armourMap.keySet());
    int randomIndex = Random.range(keys.size());
    return armourMap.get(keys.get(randomIndex));
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
    if(shortnameMap == null || shortnameMap.isEmpty()){
      System.err.println("ERROR, shortnameMap is error");
      return "";
    }
    return shortnameMap.inverse().get(key);
  }
  
  
  
}
