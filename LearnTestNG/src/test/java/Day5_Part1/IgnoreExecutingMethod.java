package Day5_Part1;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreExecutingMethod {

    //In this code - I want to Ignore executing the test1() method, So I am going to mention @ignore annotation above the test1()


    @Ignore
    @Test
    public void test1(){
        System.out.println("Test1");
    }

    //we can use (enabled = false) instead of @ignore annotation to Ignore the execution of particular method

    @Test(enabled = false)
    public void test2(){
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        System.out.println("Test3");
    }
}
