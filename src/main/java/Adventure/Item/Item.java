package Adventure.Item;

import Adventure.Item.ItemType.Weapon;

public class Item {
  
  int id;
  String name, shortName;

  public Item(Item.Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.shortName = ItemList.getShortname(id);
  }

  public static class Builder {

    private final int id;
    private final String name;

    public Builder(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public Item build() {
      return new Item(this);
    }
  }
  
  
  
}
