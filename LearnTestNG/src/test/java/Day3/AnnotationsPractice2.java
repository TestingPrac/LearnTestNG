package Day3;

import org.testng.annotations.*;

public class AnnotationsPractice2 {
    @Test
    public void method3(){
        System.out.println("This is Method 3");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("This is Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is After Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is After Method");
    }

}
