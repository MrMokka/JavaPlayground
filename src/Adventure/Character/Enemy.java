package Adventure.Character;

import Util.Range;

public class Enemy extends Character {
  public int xpValue, goldValue;
  public Enemy(String name, int maxHealth, Range damageRange, int xpValue, int goldValue, int armour) {
    super(name, maxHealth, damageRange, armour);
    this.xpValue = xpValue;
    this.goldValue = goldValue;
  }
}
