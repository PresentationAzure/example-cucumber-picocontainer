package example.cucumber.picocontainer.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AfterStep {

    private Base base;
    public AfterStep(final Base base) {
        this.base = base;
    }

    @Before
    public void it_does_not_show_nothing(){
        System.out.println("At this moment data is empty:");
        try {
            System.out.println("Customer name: " + base.customer.getName());
        } catch (NullPointerException e) {
            System.out.println("The Customer's name is null!");
        }
        try {
            System.out.println("Item type: " + base.item.getItemType());
        } catch (NullPointerException e) {
            System.out.println("The Item's type is null too!");
        }
        try {
            System.out.println("Item price: " + base.item.getPrice());
        } catch (NullPointerException e) {
            System.out.println("The same with Item's price!");
        }

    }

    @After
    public void verify_successful_transaction(){
        System.out.println();
        System.out.println("TRANSACTION DONE SUCCESSFULLY!!!");
        System.out.println("$" + base.customer.getRefunded() + " was refunded to " + base.customer.getName() + " for devolution of " + base.item.getItemType());
    }
}
