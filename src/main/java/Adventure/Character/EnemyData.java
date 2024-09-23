package Adventure.Character;

import Util.Random;
import Util.Range;

public class EnemyData {
  
  String name;
  Range healthRange;
  Range damageRange;
  Range armourRange;
  Range xpRange;
  Range goldRange;
  
  public EnemyData() {
    
  }
  
  public Enemy generateEnemy(){
    return null;
    /*
    return new Enemy(
        name,
        Random.range(healthRange.low, healthRange.high),
        damageRange,
        Random.range(xpRange.low, xpRange.high),
        Random.range(goldRange.low, goldRange.high),
        Random.range(armourRange.low, armourRange.high)
    );
    */
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
  
  public Range getArmourRange() {
    return armourRange;
  }
  
  public void setArmourRange(Range armourRange) {
    this.armourRange = armourRange;
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
