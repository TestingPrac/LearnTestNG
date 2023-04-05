package Day6;

import org.testng.annotations.Test;

public class Group2 {
    @Test(groups = {"smoke","windows.smoke","ios.smoke"})
    public void test4(){
        System.out.println("Test4");
    }
    @Test(groups = {"regression","windows.regression","ios.regression"})
    public void test5(){
        System.out.println("Test5");
    }
    @Test(groups = {"sanity","windows.sanity","ios.sanity"})
    public void test6(){
        System.out.println("Test6");
    }
}
