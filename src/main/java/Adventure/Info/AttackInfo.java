package Adventure.Info;

import Adventure.Character.Character;

public class AttackInfo {
  
  public Character attacker;
  public Character defender;
  
  public int attackerHealed;
  public int defenderDamageTaken;
  
  public AttackInfo(Character attacker, Character defender) {
    this.attacker = attacker;
    this.defender = defender;
  }
}
