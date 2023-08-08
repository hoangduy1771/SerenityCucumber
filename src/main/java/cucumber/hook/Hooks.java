package cucumber.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public void setUp() {
        System.out.println("Setting up");
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down");
    }

}
