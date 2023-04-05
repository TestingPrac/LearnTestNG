package Day6;

import org.testng.annotations.Test;

public class Group1 {
    @Test(groups = {"smoke","regression","windows.smoke","ios.smoke"})
    public void test1(){
        System.out.println("Test1");
    }
    @Test(groups = {"smoke","windows.regression","ios.regression"})
    public void test2(){
        System.out.println("Test2");
    }
    @Test(groups = {"sanity","windows.sanity","ios.sanity"})
    public void test3(){
        System.out.println("Test3");
    }

}
