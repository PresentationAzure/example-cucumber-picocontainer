package example.cucumber.picocontainer.stepdef;

import example.cucumber.picocontainer.model.Item;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CustomerSteps {

    private Base base;

    public CustomerSteps(Base base) {
        this.base = base;
    }

    @When("^she return the (.*) to the store$")
    public void return_the_an_item_to_the_store(final String itemType) throws Throwable {
        Item expectedItem = new Item(itemType);
        Assert.assertEquals(base.item.getItemType(), expectedItem.getItemType());
    }

    @When("^she show her receipt$")
    public void she_can_show_a_receipt() throws Throwable {
        System.out.println("she_can_show_a_receipt");
    }

    @Then("^she will get \\$(\\d+) refunded$")
    public void sheWillGet$Refunded(final int arg0) {
        int expected = 100;
        Assert.assertEquals(arg0, expected);
    }
}
