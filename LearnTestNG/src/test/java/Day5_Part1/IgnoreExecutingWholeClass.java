package Day5_Part1;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//In this code - I want to Ignore executing whole class, So I am going to mention @ignore annotation above the class name


@Ignore
public class IgnoreExecutingWholeClass {
    @Test
    public void test4(){
        System.out.println("Test4");
    }

    @Test
    public void test5(){
        System.out.println("Test5");
    }
    @Test
    public void test6(){
        System.out.println("Test6");
    }
}
