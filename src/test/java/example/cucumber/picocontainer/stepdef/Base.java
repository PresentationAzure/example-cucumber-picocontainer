package example.cucumber.picocontainer.stepdef;

import example.cucumber.picocontainer.model.Customer;
import example.cucumber.picocontainer.model.Item;


//This is the class that will be injected in the step definitions and hooks.
//In other words, it is the "Service Class"
public class Base {
    Customer customer;
    Item item;
}
