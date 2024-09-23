package Adventure.Item;

import Adventure.Item.ItemType.Weapon;

import java.util.List;
import java.util.Map;

public class ItemData {
  
  Map<String, ItemAttributes> weapons;
  Map<String, ItemAttributes> armour;
  Map<String, List<ItemAttributes>> consumables;
  
  
  public Item generateWeapon(String name){
    ItemAttributes weaponAttributes = weapons.get(name);
//    return new Weapon(
//        weaponAttributes.name,
//        weaponAttributes.damage,
//        weaponAttributes.healing,
//        weaponAttributes.defence
//    );
    return null;
  }
  
  //region Getters and Setters
  
  public Map<String, ItemAttributes> getWeapons() {
    return weapons;
  }
  
  public void setWeapons(Map<String, ItemAttributes> weapons) {
    this.weapons = weapons;
  }
  
  public Map<String, ItemAttributes> getArmour() {
    return armour;
  }
  
  public void setArmour(Map<String, ItemAttributes> armour) {
    this.armour = armour;
  }
  
  public Map<String, List<ItemAttributes>> getConsumables() {
    return consumables;
  }
  
  public void setConsumables(Map<String, List<ItemAttributes>> consumables) {
    this.consumables = consumables;
  }
  
  //endregion
  
}
