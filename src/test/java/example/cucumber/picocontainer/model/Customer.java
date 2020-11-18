package example.cucumber.picocontainer.model;

public class Customer {

  private String name;
  private int refund;

  public Customer(final String name) {
    this.name = name;
  }
  public void refund(final int price) {
    this.refund = price;
  }

  public int getRefunded() {
    return this.refund;
  }
  public String getName() {
    return this.name;
  }
}
