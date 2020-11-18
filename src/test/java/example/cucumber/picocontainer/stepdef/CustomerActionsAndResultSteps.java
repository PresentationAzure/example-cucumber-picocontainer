package example.cucumber.picocontainer.stepdef;

import example.cucumber.picocontainer.model.Item;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.inject.Inject;

import org.testng.Assert;
import java.util.Objects;

// For the example we can divide all steps definitions in three classes that are "Client Classes".
// The Dependency Injection (DI) is possible using Cucumber-PicoContainer, all "Client Classes" depend of base class.
// The injected "base" class is shared with all three Step Definition classes.
public class CustomerActionsAndResultSteps {

    // We also used an alternative Method for inject dependency using annotation.
    private Base base;
    @Inject
    public CustomerActionsAndResultSteps(final Base base ) {
        this.base = Objects.requireNonNull( base, "appService must not be null" );
    }

    // So we have the When and Then step definitions
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
        System.out.printf("TRANSACTION: She will get $%d refunded", base.customer.getRefunded());
        System.out.println();
    }
}
