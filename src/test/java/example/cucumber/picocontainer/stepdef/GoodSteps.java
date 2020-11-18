package example.cucumber.picocontainer.stepdef;

import example.cucumber.picocontainer.model.Customer;
import example.cucumber.picocontainer.model.Item;
import io.cucumber.java.en.Given;

public class GoodSteps {

    private Base base;

    public GoodSteps(final Base base) {
        this.base = base;
    }

    @Given("that {string} bought a faulty {string} for ${int}")
    public void that_bought_a_faulty_kettle(final String name, final String itemType, final int price) throws Throwable {
        base.customer = new Customer(name);
        base.item = new Item(itemType, price);
    }
}
