package Adventure.Info;

public class HealingInfo {
  
  public enum HealingType {
    FLAT,
    PERCENTAGE_MAX_HP,
    PERCENTAGE_DAMAGE
  }
  
  public float healingAmount;
  public HealingType healingType;
  
  public HealingInfo(HealingType healingType, float healingAmount) {
    this.healingType = healingType;
    this.healingAmount = healingAmount;
  }
  
}
