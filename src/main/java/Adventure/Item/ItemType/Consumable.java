package Adventure.Item.ItemType;

import Adventure.Item.Item;

public class Consumable extends Item {

  int healing;

  private Consumable(Builder builder) {
    super(builder);
    this.healing = builder.healing;
  }

  public static class Builder extends Item.Builder {

    private int healing = 0;

    public Builder(int id, String name) {
      super(id, name);
    }

    public Builder healing(int healing) {
      this.healing = healing;
      return this;
    }

    public Consumable build() {
      return new Consumable(this);
    }
  }

}
