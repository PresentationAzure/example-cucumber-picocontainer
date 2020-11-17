package example.cucumber.picocontainer.model;

public class Item {
  private String itemType;
  private int price;

  public Item(final String itemType, final int price) {
    this.itemType = itemType;
    this.price = price;
  }

  public Item(final String itemType) {
    this.itemType = itemType;
    this.price = 100;
  }

  public int getPrice() {
    return this.price;
  }

  public String getItemType() {
    return itemType;
  }
}
