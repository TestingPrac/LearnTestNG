package Day3;

import org.testng.annotations.*;

public class AnnotationsPractice1 {

    @Test(priority = 1)
    public void method1(){
        System.out.println("This is Method 1");
    }

    @Test(priority = 2)
    public void method2(){
        System.out.println("This is Method 2");
    }

    @BeforeSuite
    public void beforeSuiteMethod(){
        System.out.println("This is Before Suite");
    }

    @AfterSuite
    public void afterSuiteMethod(){
        System.out.println("This is After Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("This is Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("This is After Test");
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
