package Adventure.Character;

import Util.Random;
import Util.Range;
import com.fasterxml.jackson.annotation.*;

public class Enemy extends Character {

  public int xpValue, goldValue;

  @JsonCreator
  public Enemy(
          @JsonProperty("name") String name,
          @JsonProperty("healthRange") Range healthRange,
          @JsonProperty("damageRange") Range damageRange,
          @JsonProperty("armourRange") Range armourRange,
          @JsonProperty("xpRange") Range xpRange,
          @JsonProperty("goldRange") Range goldRange
  ) {
    super(
            name,
            Random.range(healthRange),
            damageRange,
            Random.range(armourRange)
    );
    this.xpValue = Random.range(xpRange);
    this.goldValue = Random.range(goldRange);
  }

}
