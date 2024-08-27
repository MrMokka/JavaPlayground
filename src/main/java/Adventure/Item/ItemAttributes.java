package Adventure.Item;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemAttributes {
  
  String name;
  int damage;
  int healing;
  int defence;
  
  
  //region Getters and Setters
  
  public int getDamage() {
    return damage;
  }
  
  public void setDamage(int damage) {
    this.damage = damage;
  }
  
  public int getHealing() {
    return healing;
  }
  
  public void setHealing(int healing) {
    this.healing = healing;
  }
  
  public int getDefence() {
    return defence;
  }
  
  public void setDefence(int defence) {
    this.defence = defence;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  //endregion
}
