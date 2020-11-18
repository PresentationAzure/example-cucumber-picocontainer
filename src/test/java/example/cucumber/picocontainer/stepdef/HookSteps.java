package example.cucumber.picocontainer.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

// This is another "Client class" that depends of base class.
// The injected "base" class is shared also with After and Before Hooks.
public class HookSteps {

    private Base base;
    public HookSteps(final Base base) {
        this.base = base;
    }

    //In this Before step, data is empty so we wait a NullPointerException to catch.
    @Before
    public void it_does_not_show_nothing(){
        System.out.println(">>>>>>BEGINNING OF 'BEFORE' HOOK STEP<<<<<<");
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
        System.out.println(">>>>>>END OF 'BEFORE' HOOK STEP<<<<<<");
        System.out.println();
    }

    //As we can see the data also was shared with this After step and it persists after the running of the scenario.
    @After
    public void verify_successful_transaction(){
        System.out.println();
        System.out.println(">>>>>>BEGINNING OF 'AFTER' HOOK STEP<<<<<<");
        System.out.println("Transaction done Successfully!!!");
        System.out.println("$" + base.customer.getRefunded() + " was refunded to " + base.customer.getName() + " for devolution of " + base.item.getItemType());
        System.out.println(">>>>>>END OF 'AFTER' HOOK STEP<<<<<<");
    }
}
