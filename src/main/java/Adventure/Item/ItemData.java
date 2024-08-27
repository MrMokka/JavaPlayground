package Adventure.Item;

import java.util.List;
import java.util.Map;

public class ItemData {
  
  Map<String, ItemAttributes> weapons;
  Map<String, ItemAttributes> armor;
  Map<String, List<ItemAttributes>> consumables;
  
  
  public Item generateWeapon(String name){
    ItemAttributes weaponAttributes = weapons.get(name);
    return new Weapon(
        weaponAttributes.name,
        weaponAttributes.damage,
        weaponAttributes.healing,
        weaponAttributes.defence
    );
  }
  
  //region Getters and Setters
  
  public Map<String, ItemAttributes> getWeapons() {
    return weapons;
  }
  
  public void setWeapons(Map<String, ItemAttributes> weapons) {
    this.weapons = weapons;
  }
  
  public Map<String, ItemAttributes> getArmor() {
    return armor;
  }
  
  public void setArmor(Map<String, ItemAttributes> armor) {
    this.armor = armor;
  }
  
  public Map<String, List<ItemAttributes>> getConsumables() {
    return consumables;
  }
  
  public void setConsumables(Map<String, List<ItemAttributes>> consumables) {
    this.consumables = consumables;
  }
  
  //endregion
  
}
