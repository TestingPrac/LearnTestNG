package Day1;

import org.testng.annotations.Test;

public class PracticeDayOne1 {
    @Test(priority = 1)
    void setUp(){
        System.out.println("Setting Up the browser");
    }

    @Test(priority = 2)
    void login(){
        System.out.println("Logging In");
    }

    @Test(priority = 3)
    void tearDown(){
        System.out.println("Closing the Browser");
    }

}
