package Adventure;

import Util.Range;

public class Enemy extends Character {
  public int xpValue, goldValue;
  public Enemy(String name, int maxHealth, Range damageRange, int xpValue, int goldValue) {
    super(name, maxHealth, damageRange);
    this.xpValue = xpValue;
    this.goldValue = goldValue;
  }
}
