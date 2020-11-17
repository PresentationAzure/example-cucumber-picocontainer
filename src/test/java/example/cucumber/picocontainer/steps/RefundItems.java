package example.cucumber.picocontainer.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.cucumber.picocontainer.model.Customer;
import example.cucumber.picocontainer.model.Item;

import org.testng.Assert;

public class RefundItems {
  private Customer customer;
  private Item item;

  @Given("^that (.*) bought a faulty (.*) for \\$(\\d+)$")
  public void that_bought_a_faulty_kettle(String name, String itemType, int price) throws Throwable {
    customer = new Customer(name);
    item = new Item(itemType, price);
  }

  @When("^she return the (.*) to the store$")
  public void return_the_an_item_to_the_store(String itemType) throws Throwable {
    Item returnedItem = new Item(itemType);
    Assert.assertEquals(item, returnedItem);
  }

  @When("^she show her receipt$")
  public void she_can_show_a_receipt() throws Throwable {
    customer.refund(item.getPrice());
  }

  @Then("^she will get \\$(\\d+) refunded$")
  public void she_will_get_$_back(int expected) throws Throwable {
    Assert.assertEquals(customer.getRefunded(), expected);
  }
}
