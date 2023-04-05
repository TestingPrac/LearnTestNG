package Day1;

import org.testng.annotations.Test;

public class PracticeDayOne2 {

    @Test(priority = 1)
    void validateTitle(){
        System.out.println("Title Validation Successful");
    }

    @Test(priority = 2)
    void searchCustomer(){
        System.out.println("Searching Customer");
    }
}
