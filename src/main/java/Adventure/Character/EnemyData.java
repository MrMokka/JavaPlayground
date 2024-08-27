package Adventure.Character;

import Util.Random;
import Util.Range;

public class EnemyData {
  
  String name;
  Range healthRange;
  Range damageRange;
  Range armorRange;
  Range xpRange;
  Range goldRange;
  
  public EnemyData() {
    
  }
  
  public Enemy generateEnemy(){
    return new Enemy(
        name,
        Random.range(healthRange.low, healthRange.high),
        damageRange,
        Random.range(xpRange.low, xpRange.high),
        Random.range(goldRange.low, goldRange.high),
        Random.range(armorRange.low, armorRange.high)
    );
  }
  
  
  
  //region Getters and Setters
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Range getHealthRange() {
    return healthRange;
  }
  
  public void setHealthRange(Range healthRange) {
    this.healthRange = healthRange;
  }
  
  public Range getDamageRange() {
    return damageRange;
  }
  
  public void setDamageRange(Range damageRange) {
    this.damageRange = damageRange;
  }
  
  public Range getArmorRange() {
    return armorRange;
  }
  
  public void setArmorRange(Range armorRange) {
    this.armorRange = armorRange;
  }
  
  public Range getXpRange() {
    return xpRange;
  }
  
  public void setXpRange(Range xpRange) {
    this.xpRange = xpRange;
  }
  
  public Range getGoldRange() {
    return goldRange;
  }
  
  public void setGoldRange(Range goldRange) {
    this.goldRange = goldRange;
  }
  
  //endregion
  
}
