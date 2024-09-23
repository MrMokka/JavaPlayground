package Adventure.Item;

import Adventure.Data.ItemList;

public class Item {
  
  int id;
  String name, shortName;
  protected String description;
  
  public Item(Item.Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.shortName = ItemList.getShortname(id);
    this.description = builder.description;
  }

  public static class Builder {

    private final int id;
    private final String name;
    
    protected String description = "";

    public Builder(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public Item.Builder description(String description) {
      this.description = description;
      return this;
    }

    public Item build() {
      return new Item(this);
    }
  }
  
  public String getName() {
    return name;
  }
  
  public int OnTakeDamage(int damage) {
    return damage;
  }
  
  public String description() {
    if(description.isEmpty())
      return"Missing description";
    return description;
  }
  
}
