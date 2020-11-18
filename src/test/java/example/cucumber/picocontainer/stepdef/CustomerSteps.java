package example.cucumber.picocontainer.stepdef;

import example.cucumber.picocontainer.model.Item;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.inject.Inject;

import org.testng.Assert;
import java.util.Objects;

public class CustomerSteps {

    private Base base;
    /*
     * Alternative Method for inject dependency using annotation.
    */
    @Inject
    public CustomerSteps(final Base base ) {
        this.base = Objects.requireNonNull( base, "appService must not be null" );
    }

    @When("she return the {string} to the store")
    public void return_the_an_item_to_the_store(final String itemType) throws Throwable {
        Item expectedItem = new Item(itemType);
        Assert.assertEquals(base.item.getItemType(), expectedItem.getItemType());
    }

    @When("she show her receipt")
    public void she_can_show_a_receipt() throws Throwable {
        base.customer.refund(base.item.getPrice());
    }

    @Then("she will get ${int} refunded")
    public void sheWillGet$Refunded(final int refunded) {
        System.out.printf("she will get $%d refunded", base.customer.getRefunded());
    }
}
