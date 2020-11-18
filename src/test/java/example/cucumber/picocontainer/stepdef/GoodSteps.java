package example.cucumber.picocontainer.stepdef;

import example.cucumber.picocontainer.model.Customer;
import example.cucumber.picocontainer.model.Item;
import io.cucumber.java.en.Given;

public class GoodSteps {

    private Base base;

    public GoodSteps(Base base) {
        this.base = base;
    }

    @Given("that {string} bought a faulty {string} for ${int}")
    public void that_bought_a_faulty_kettle(String name, String itemType, int price) throws Throwable {
        System.out.println(name);
        System.out.println(itemType);
        base.customer = new Customer(name);
        base.item = new Item(itemType, price);
    }
}
